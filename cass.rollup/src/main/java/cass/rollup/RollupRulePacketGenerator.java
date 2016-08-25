package cass.rollup;

import org.stjs.javascript.Array;
import org.stjs.javascript.functions.Callback1;

import cass.rollup.InquiryPacket.IPType;

public class RollupRulePacketGenerator
{

	public enum OperationType
	{
		AND, OR
	}

	private Array<String> queries;
	private Array<OperationType> queryOperations;
	private InquiryPacket ip;
	private EvidenceProcessor ep;

	public RollupRulePacketGenerator(InquiryPacket ip, EvidenceProcessor ep)
	{
		this.ip = ip;
		this.ep = ep;
		queries = new Array<String>();
		queryOperations = new Array<OperationType>();
	}

	public void addQuery(String query)
	{
		queries.push(query);
	}

	public void addQueryOperation(OperationType operation)
	{
		queryOperations.push(operation);
	}

	private boolean hasOrOperation()
	{
		for (int i = 0; i < queryOperations.$length(); i++)
		{
			if (OperationType.OR.equals(queryOperations.$get(i)))
				return true;
		}
		return false;
	}

	private IPType getIPType()
	{
		if (hasOrOperation())
			return IPType.COMBINATOR_OR;
		return IPType.COMBINATOR_AND;
	}

	private InquiryPacket generateComboAndPacket()
	{
		final EvidenceProcessor meEp = ep;
		final InquiryPacket meIp = ip;
		return new InquiryPacket(ip.subject, null, null, ip.context, new Callback1<InquiryPacket>()
		{
			@Override
			public void $invoke(InquiryPacket p1)
			{
				if (meEp != null)
				   meEp.continueProcessing(meIp);
			}
		}, ip.failure, null, IPType.COMBINATOR_AND);
	}

	private InquiryPacket generateRollupRulePacket(String rule)
	{
		final EvidenceProcessor meEp = ep;
		final InquiryPacket meIp = ip;
		return new InquiryPacket(ip.subject, null, null, ip.context, new Callback1<InquiryPacket>()
		{
			@Override
			public void $invoke(InquiryPacket p1)
			{
				if (meEp != null)
				   meEp.continueProcessing(meIp);
			}
		}, ip.failure, rule, IPType.ROLLUPRULE);
	}

	private void addAllQueries(InquiryPacket rollupIp)
	{
		for (int i = 0; i < queries.$length(); i++)
		{
			rollupIp.subPackets.push(generateRollupRulePacket(queries.$get(i)));
		}
	}

	private void buildQueryTree(InquiryPacket rollupIp)
	{
		if (queryOperations.$length() <= 0)
			return;
		InquiryPacket currentAndPacket = generateComboAndPacket();
		OperationType priorOt;
		if (OperationType.OR.equals(queryOperations.$get(0)))
			rollupIp.subPackets.push(generateRollupRulePacket(queries.$get(0)));
		else
			currentAndPacket.subPackets.push(generateRollupRulePacket(queries.$get(0)));
		priorOt = queryOperations.$get(0);
		for (int i = 1; i < queryOperations.$length(); i++)
		{
			if (OperationType.OR.equals(queryOperations.$get(i)))
			{
				if (OperationType.OR.equals(priorOt))
					rollupIp.subPackets.push(generateRollupRulePacket(queries.$get(i)));
				else
				{
					currentAndPacket.subPackets.push(generateRollupRulePacket(queries.$get(i)));
					rollupIp.subPackets.push(currentAndPacket);
				}
			}
			else
			{
				if (OperationType.OR.equals(priorOt))
				{
					currentAndPacket = generateComboAndPacket();
					currentAndPacket.subPackets.push(generateRollupRulePacket(queries.$get(i)));
				}
				else
					currentAndPacket.subPackets.push(generateRollupRulePacket(queries.$get(i)));
			}
			priorOt = queryOperations.$get(i);
		}
		if (OperationType.OR.equals(priorOt))
			rollupIp.subPackets.push(generateRollupRulePacket(queries.$get(queries.$length() - 1)));
		else
		{
			currentAndPacket.subPackets.push(generateRollupRulePacket(queries.$get(queries.$length() - 1)));
			rollupIp.subPackets.push(currentAndPacket);
		}
	}

	public InquiryPacket generatePacket()
	{
	   IPType ipt = getIPType();
		final EvidenceProcessor meEp = ep;		
		final InquiryPacket meIp = ip;
		InquiryPacket rollupIp = new InquiryPacket(ip.subject, null, null, ip.context, new Callback1<InquiryPacket>()
		{
			@Override
			public void $invoke(InquiryPacket p1)
			{
				if (meEp != null)
				   meEp.continueProcessing(meIp);
			}
		}, ip.failure, null, ipt);
		if (IPType.COMBINATOR_AND.equals(ipt))
			addAllQueries(rollupIp);
		else
			buildQueryTree(rollupIp);
		return rollupIp;
	}

	public static void main(String[] args) throws Exception
	{
		// InquiryPacket ip = new
		// InquiryPacket(null,null,null,null,null,null,null,null);
		// RollupRulePacketGenerator rpg = new RollupRulePacketGenerator(ip);
		// rpg.addQuery("competency:http://Addition AND confidence>0.6");
		// rpg.addQuery("competency:http://Subtraction AND confidence>0.6");
		// rpg.addQuery("competency:http://Multiplication AND confidence>0.6");
		// rpg.addQuery("competency:http://Division AND confidence>0.6");
		// rpg.addQueryOperation(OperationType.AND);
		// rpg.addQueryOperation(OperationType.AND);
		// rpg.addQueryOperation(OperationType.OR);
		// InquiryPacket rip = rpg.generatePacket();
		// System.out.println(rip.type);
		// InquiryPacket sp;
		// for (int i=0;i<rip.subPackets.$length();i++)
		// {
		// sp = rip.subPackets.$get(i);
		// if (sp.type.equals(IPType.ROLLUPRULE)) System.out.println(" " +
		// sp.type + " - " + sp.rule);
		// else
		// {
		// System.out.println(" " + sp.type);
		// for (int j=0;j<sp.subPackets.$length();j++)
		// {
		// System.out.println(" " + sp.subPackets.$get(j).type + " - " +
		// sp.subPackets.$get(j).rule);
		// }
		// }
		// }

		/**
		 * rpg.addQuery("Y0"); rpg.addQuery("Y1"); rpg.addQuery("Y2");
		 * rpg.addQuery("Y3"); rpg.addQuery("Y4"); rpg.addQuery("Y5");
		 * rpg.addQuery("Y6"); rpg.addQuery("Y7");
		 * rpg.addQueryOperation(OperationType.OR);
		 * rpg.addQueryOperation(OperationType.AND);
		 * rpg.addQueryOperation(OperationType.AND);
		 * rpg.addQueryOperation(OperationType.OR);
		 * rpg.addQueryOperation(OperationType.AND);
		 * rpg.addQueryOperation(OperationType.OR);
		 * rpg.addQueryOperation(OperationType.OR);
		 * 
		 */

	}

}
