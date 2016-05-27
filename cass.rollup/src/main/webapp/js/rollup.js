log = function(ctx)
{
    $("#log").append("<br>");
    $("#log").append(ctx);
}
var finalStmt = null;
onSEnter = function(ctx){
    finalStmt = "";
}

onSExit = function(ctx){
    log("Final statement: " + finalStmt.trim())
    log("Evaluating:"+finalStmt.replace(/AND/g,"&").replace(/OR/g,"|"))
    log("Final Result: " + eval(finalStmt.replace(/AND/g,"&").replace(/OR/g,"|")));
}

onLogical_or_math_operatorExit = function(ctx){
    if (ctx.cLogic != null)
        finalStmt += ctx.cLogic.text + " ";
    if (ctx.cMath != null)
        finalStmt += ctx.cMath.text + " ";
}

onTokenExit = function(ctx){
    if (ctx.cNumber != null)
        finalStmt += ctx.cNumber.text + " ";
    if (ctx.cBoolean != null)
        finalStmt += ctx.cBoolean.text + " ";
    if (onQueryExitResult != null)
        finalStmt += onQueryExitResult + " ";
}

var query = null;
onQueryEnter = function(ctx)
{
    log("Parsing Query Statement.");
    query = "";
    onQueryExitResult = null;
}

var onQueryExitResult = null;
onQueryExit = function(ctx)
{
    log();
    log("Executing Query...");
    log("http://skyrepo.service.eduworks.com/sky/repo/search")
    log("query      = (@type:\"http://schema.eduworks.com/cass/0.2/assertion\" AND (" + query.trim() + "))");
    log("individual = "+$("#pk").val());
    log();
    var rand = Math.round(Math.random() * 2);
    log(rand + " records retreived. This number was randomly generated.");
    log();
    if (rand > 0)
        onQueryExitResult = 1.0;
    else
        onQueryExitResult = 0.0;
}

onInnerQueryExit = function(ctx)
{
    console.log(ctx);
    if (ctx.cKey != null)
        console.log(ctx.cKey.text);
    if (ctx.cLogic != null)
        query += " " + ctx.cLogic.text + " ";
    if (ctx.cValue != null)
    {
        console.log(ctx.cValue.text);
        log(ctx.cKey.text +" "+ ctx.cOperator.text + " " + ctx.cValue.text);
        query += ctx.cKey.text +""+ ctx.cOperator.text + "\"" + ctx.cValue.text + "\" ";
    }
    if (ctx.cNumber != null)
    {
        console.log(ctx.cNumber.text);
        log(ctx.cKey.text +" "+ ctx.cOperator.text + " " + ctx.cNumber.text);
        query += ctx.cKey.text +""+ ctx.cOperator.text + "" + ctx.cNumber.text + " ";
    }
}

function parse()
{
    $("#log").html("");
    var input = $("#text").val();
    
    var chars = new antlr4.InputStream(input);
    var lexer = new RollupLexer.RollupLexer(chars);
    var tokens  = new antlr4.CommonTokenStream(lexer);
    var parser = new RollupParser.RollupParser(tokens);
    parser.buildParseTrees = true;

    var listener = new RollupListener.RollupListener();
    listener.enterS = onSEnter;
    listener.exitS = onSExit;
    listener.exitToken = onTokenExit;
    listener.enterQuery = onQueryEnter;
    listener.exitQuery = onQueryExit;
    listener.exitInnerquery = onInnerQueryExit;
    listener.exitLogical_or_math_operator = onLogical_or_math_operatorExit;
    parser.addParseListener(listener);

    var tree = parser.s();
}