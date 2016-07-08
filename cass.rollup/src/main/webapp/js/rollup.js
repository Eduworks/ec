log = function(ctx)
{
    $("#log").append("<br>");
    $("#log").append(ctx);
}

function parse()
{
    $("#log").html("");
    var input = $("#text").val();
    
    var rr = new RollupRuleProcessor(input);
    rr.log = log;
    rr.go();
    
}