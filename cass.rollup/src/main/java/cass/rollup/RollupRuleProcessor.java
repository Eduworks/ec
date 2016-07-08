package cass.rollup;

import org.stjs.javascript.Array;
import org.stjs.javascript.JSGlobal;
import org.stjs.javascript.functions.Callback1;

import com.eduworks.ec.crypto.EcPk;

import cass.rollup.js.context;
import cass.rollup.rule.RrQuery;
import cass.rollup.rule.RrS;
import cass.rollup.rule.RrToken;

public class RollupRuleProcessor
{
	protected Double onQueryExitResult;
	protected String query;
	String finalStmt = null;

	private EcPk target;

	public Callback1<Boolean> success;
	public Callback1<String> failure;

	public Callback1<Object> logFunction;
	public Array<Object> positive;
	public Array<Object> negative;
	
	private String result;
	
	private RrS s;
	private RrToken tok;
	private RrQuery que;

	public RollupRuleProcessor(EcPk target)
	{
		this.target = target;
	}

	protected void log(Object string)
	{
		if (logFunction != null)
			logFunction.$invoke(string);
	}

	public void enterS(context ctx)
	{
		if (s != null)
			throw new RuntimeException("We found another S in our S.");
		s = new RrS();
		finalStmt = "";
	}

	public void exitS(context ctx)
	{
		log("Final statement: " + finalStmt.trim());
		String replaceAll = finalStmt.replaceAll("AND", "&").replaceAll("OR", "|");
		log("Evaluating:" + replaceAll);
		log("Final Result: " + (result = JSGlobal.eval(replaceAll)));
	}

	public void enterToken(context ctx)
	{
		s.addToken(tok = new RrToken());
	}
	
	public void exitToken(context ctx)
	{
		if (ctx.cNumber != null)
			finalStmt += (tok.number = Double.parseDouble(ctx.cNumber.text)) + " ";
		if (ctx.cBoolean != null)
			finalStmt += (tok.bool = Boolean.parseBoolean(ctx.cBoolean.text)) + " ";
		if (onQueryExitResult != null)
			finalStmt += onQueryExitResult + " ";
	}


	public void enterQuery(context ctx)
	{
		s.addQuery(que = new RrQuery());
		log("Parsing Query Statement.");
		query = "";
		onQueryExitResult = null;
	}

	public void exitQuery(context ctx)
	{
		que.query = query.trim();
		log("");
		log("Executing Query...");
		log("http://skyrepo.service.eduworks.com/sky/repo/search");
		log("query      = (@type:\"http://schema.eduworks.com/cass/0.2/assertion\" AND (" + query.trim() + "))");
		log("individual = " + target.toPem());
		log("");
		double rand = Math.round(Math.random() * 2);
		log(rand + " records retreived. This number was randomly generated.");
		log("");
		if (rand > 0)
			onQueryExitResult = 1.0;
		else
			onQueryExitResult = 0.0;
	}

	public void exitInnerquery(context ctx)
	{
		log(ctx);
		if (ctx.cKey != null)
			log(ctx.cKey.text);
		if (ctx.cLogic != null)
			query += " " + ctx.cLogic.text + " ";
		if (ctx.cValue != null)
		{
			log(ctx.cValue.text);
			log(ctx.cKey.text + " " + ctx.cOperator.text + " " + ctx.cValue.text);
			query += ctx.cKey.text + "" + ctx.cOperator.text + "\"" + ctx.cValue.text + "\" ";
		}
		if (ctx.cNumber != null)
		{
			log(ctx.cNumber.text);
			log(ctx.cKey.text + " " + ctx.cOperator.text + " " + ctx.cNumber.text);
			query += ctx.cKey.text + "" + ctx.cOperator.text + "" + ctx.cNumber.text + " ";
		}
	}

	public void exitLogical_or_math_operator(context ctx)
	{
		if (ctx.cLogic != null)
			finalStmt += ctx.cLogic.text + " ";
		if (ctx.cMath != null)
			finalStmt += ctx.cMath.text + " ";
	}

}
