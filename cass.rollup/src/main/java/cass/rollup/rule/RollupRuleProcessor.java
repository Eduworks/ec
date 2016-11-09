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

	public RollupRuleProcessor(InquiryPacket ip, AssertionProcessor ep)
	{
		this.ip = ip;
		rollupRulePacketGenerator = new RollupRulePacketGenerator(ip, ep);
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
		if (ctx.cLogic != null)
			query += " " + ctx.cLogic.text + " ";
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
			} else if ("OR".equals(ctx.cLogic.text.toUpperCase()))
			{
				log("ADDING OPERATION: " + OperationType.OR);
				rollupRulePacketGenerator.addQueryOperation(OperationType.OR);
			}
		}
		// if (ctx.cMath != null) finalStmt += ctx.cMath.text + " ";
	}

}
