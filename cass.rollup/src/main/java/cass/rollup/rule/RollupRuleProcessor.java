package cass.rollup.rule;

import org.cass.profile.EcAssertion;
import org.stjs.javascript.Array;
import org.stjs.javascript.functions.Callback1;

import cass.rollup.InquiryPacket;
import cass.rollup.js.bridges.context;
import cass.rollup.processors.AssertionProcessor;
import cass.rollup.rule.RollupRulePacketGenerator.OperationType;

public class RollupRuleProcessor
{
	protected Double onQueryExitResult;
	protected String query;
	public Callback1<Boolean> success;
	public Callback1<String> failure;

	public Callback1<Object> logFunction;
	public Array<EcAssertion> positive;
	public Array<EcAssertion> negative;
	
	private RrS s;
	private RrToken tok;
	private RrQuery que;
	
	private InquiryPacket ip;
	
	RollupRulePacketGenerator rollupRulePacketGenerator;

	public RollupRuleProcessor(InquiryPacket ip,AssertionProcessor ep)
	{
	   this.ip = ip;
	   rollupRulePacketGenerator = new RollupRulePacketGenerator(ip,ep);
	}

	protected void log(Object string)
	{
		if (logFunction != null) logFunction.$invoke(string);
	}

	public void enterS(context ctx)
	{
	   if (s != null) throw new RuntimeException("We found another S in our S.");
		s = new RrS();		
	}

	public void exitS(context ctx)
	{
	   ip.subPackets.push(rollupRulePacketGenerator.generatePacket());
	}

	public void enterToken(context ctx)
	{
	   s.addToken(tok = new RrToken());		
	}
	
	public void exitToken(context ctx)
	{
	}

	public void enterQuery(context ctx)
	{
	   s.addQuery(que = new RrQuery());
		query = "";
		onQueryExitResult = null;		
	}

	public void exitQuery(context ctx)
	{
		que.query = query.trim();
		log("ADDING QUERY: " + query.trim());
		rollupRulePacketGenerator.addQuery(query.trim());
	}

	public void exitInnerquery(context ctx)
	{		
	   if (ctx.cLogic != null) query += " " + ctx.cLogic.text + " ";
      if (ctx.cValue != null)
      {
         query += ctx.cKey.text + "" + ctx.cOperator.text + "\"" + ctx.cValue.text + "\" ";
      }
      if (ctx.cNumber != null)
      {
         query += ctx.cKey.text + "" + ctx.cOperator.text + "" + ctx.cNumber.text + " ";
      }      
	}

	public void exitLogical_or_math_operator(context ctx)
	{
	   if (ctx.cLogic != null)
	   {
	      if ("AND".equals(ctx.cLogic.text.toUpperCase()))
	      {
	         log("ADDING OPERATION: " + OperationType.AND);
	         rollupRulePacketGenerator.addQueryOperation(OperationType.AND);
	      }
	      else if ("OR".equals(ctx.cLogic.text.toUpperCase()))
	      {
	         log("ADDING OPERATION: " + OperationType.OR);
	         rollupRulePacketGenerator.addQueryOperation(OperationType.OR);
	      }
	   }
		//if (ctx.cMath != null) finalStmt += ctx.cMath.text + " ";		
	}

}


/**
 * package cass.rollup;

import org.cass.profile.EcAssertion;
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

   private Array<EcPk> target;

   public Callback1<Boolean> success;
   public Callback1<String> failure;

   public Callback1<Object> logFunction;
   public Array<EcAssertion> positive;
   public Array<EcAssertion> negative;
   
   private String result;
   
   private RrS s;
   private RrToken tok;
   private RrQuery que;

   public RollupRuleProcessor(InquiryPacket ip)
   {
//    this.target = subject;
   }

   protected void log(Object string)
   {
      if (logFunction != null)
         logFunction.$invoke(string);
   }

   public void enterS(context ctx)
   {
      log("**********************************************************************************************");
      log("!!! START enterS !!!");
      if (s != null)
         throw new RuntimeException("We found another S in our S.");
      s = new RrS();
      finalStmt = "";
      log("!!! END enterS !!!");
      log("**********************************************************************************************\n\n");
   }

   public void exitS(context ctx)
   {
      log("**********************************************************************************************");
      log("!!! START exitS !!!");
      log("Final statement: " + finalStmt.trim());
      String replaceAll = finalStmt.replaceAll("AND", "&").replaceAll("OR", "|");
      log("Evaluating:" + replaceAll);
      log("Final Result: " + (result = JSGlobal.eval(replaceAll)));
      log("!!! END exitS !!!");
      log("**********************************************************************************************\n\n");
   }

   public void enterToken(context ctx)
   {
      log("**********************************************************************************************");
      log("!!! START enterToken !!!");
      s.addToken(tok = new RrToken());
      log("!!! END enterToken !!!");
      log("**********************************************************************************************\n\n");
   }
   
   public void exitToken(context ctx)
   {
      log("**********************************************************************************************");
      log("!!! START exitToken !!!");
      log("---finalStmt: " + finalStmt); 
      if (ctx.cNumber != null)
         finalStmt += (tok.number = Double.parseDouble(ctx.cNumber.text)) + " ";
      if (ctx.cBoolean != null)
         finalStmt += (tok.bool = Boolean.parseBoolean(ctx.cBoolean.text)) + " ";
      if (onQueryExitResult != null)
         finalStmt += onQueryExitResult + " ";
      log("---finalStmt: " + finalStmt);
      log("!!! END exitToken !!!");
      log("**********************************************************************************************\n\n");
   }


   public void enterQuery(context ctx)
   {
      log("**********************************************************************************************");
      log("!!! START enterQuery !!!");
      s.addQuery(que = new RrQuery());
      log("Parsing Query Statement.");
      query = "";
      onQueryExitResult = null;
      log("!!! END enterQuery !!!");
      log("**********************************************************************************************\n\n");
   }

   public void exitQuery(context ctx)
   {
      log("**********************************************************************************************");
      log("!!! START exitQuery !!!");
      que.query = query.trim();
      log("");
      log("Executing Query...");
      log("http://skyrepo.service.eduworks.com/sky/repo/search");
      log("query      = (@type:\"http://schema.eduworks.com/cass/0.2/assertion\" AND (" + query.trim() + "))");
//    log("individual = " + target.toPem());
      log("");
      double rand = Math.round(Math.random() * 2);
      log(rand + " records retreived. This number was randomly generated.");
      log("");
      if (rand > 0)
         onQueryExitResult = 1.0;
      else
         onQueryExitResult = 0.0;
      log("!!! END exitQuery !!!");
      log("**********************************************************************************************\n\n");
   }

   public void exitInnerquery(context ctx)
   {
      log("**********************************************************************************************");
      log("!!! START exitInnerquery !!!");
      log("---query: " + query);
      log(ctx);
      if (ctx.cKey != null)
         log("cKey: " + ctx.cKey.text);
      if (ctx.cLogic != null)
         query += " " + ctx.cLogic.text + " ";
      if (ctx.cValue != null)
      {
         log("cValue: " + ctx.cValue.text);
         log("key + operator + value: " + ctx.cKey.text + " " + ctx.cOperator.text + " " + ctx.cValue.text);
         query += ctx.cKey.text + "" + ctx.cOperator.text + "\"" + ctx.cValue.text + "\" ";
      }
      if (ctx.cNumber != null)
      {
         log("cNumber: " + ctx.cNumber.text);
         log("key + operator + number: " + ctx.cKey.text + " " + ctx.cOperator.text + " " + ctx.cNumber.text);
         query += ctx.cKey.text + "" + ctx.cOperator.text + "" + ctx.cNumber.text + " ";
      }
      log("---query: " + query);
      log("!!! END exitInnerquery !!!");
      log("**********************************************************************************************\n\n");
   }

   public void exitLogical_or_math_operator(context ctx)
   {
      log("**********************************************************************************************");
      log("!!! START exitLogical_or_math_operator !!!");
      log("---finalStmt: " + finalStmt);
      if (ctx.cLogic != null)
         finalStmt += ctx.cLogic.text + " ";
      if (ctx.cMath != null)
         finalStmt += ctx.cMath.text + " ";
      log("---finalStmt: " + finalStmt);
      log("!!! END exitLogical_or_math_operator !!!");
      log("**********************************************************************************************\n\n");
   }

}
**/
