package cass.rollup;

import org.cass.competency.EcAlignment;
import org.cass.competency.EcCompetency;
import org.stjs.javascript.Array;
import org.stjs.javascript.Map;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;

import cass.rollup.InquiryPacket.IPType;
import cass.rollup.processors.AssertionProcessor;

public class RelationshipPacketGenerator
{

	public Callback1<String> failure;
	public Callback0 success;
	public Callback1<Object> logFunction;

	private int numberOfRelationsToProcess = 0;
	private int numberOfRelationsProcessed = 0;

	public Array<InquiryPacket> narrowsPackets;
	public Array<InquiryPacket> broadensPackets;
	public Array<InquiryPacket> requiredPackets;
	private Map<String, String> processedAlignments;

	private AssertionProcessor ep;
	private InquiryPacket ip;

	public RelationshipPacketGenerator(InquiryPacket ip, AssertionProcessor ep, Map<String, String> processedAlignments)
	{
		this.ip = ip;
		this.ep = ep;
		this.processedAlignments = processedAlignments;
		narrowsPackets = new Array<InquiryPacket>();
		broadensPackets = new Array<InquiryPacket>();
		requiredPackets = new Array<InquiryPacket>();
	}

	protected void log(Object string)
	{
		if (logFunction != null)
			logFunction.$invoke(string);
	}

	private void processEventFailure(String message, InquiryPacket ip)
	{
		ip.numberOfQueriesRunning--;
		failure.$invoke(message);
	}

	private void pushRequiredPacketsToIp()
	{
		if (requiredPackets.$length() > 0)
		{
			final AssertionProcessor meEp = ep;
			final InquiryPacket meIp = ip;
			InquiryPacket rootRequiredPacket = new InquiryPacket(ip.subject, null, null, ip.context, new Callback1<InquiryPacket>()
			{
				@Override
				public void $invoke(InquiryPacket p1)
				{
					if (meEp != null)
						meEp.continueProcessing(meIp);
				}
			}, ip.failure, null, IPType.RELATION_REQUIRES);
			rootRequiredPacket.subPackets = requiredPackets;
			ip.subPackets.push(rootRequiredPacket);
		}
	}

	private void pushNarrowsPacketsToIp()
	{
		if (narrowsPackets.$length() > 0)
		{
			final AssertionProcessor meEp = ep;
			final InquiryPacket meIp = ip;
			InquiryPacket rootNarrowsPacket = new InquiryPacket(ip.subject, null, null, ip.context, new Callback1<InquiryPacket>()
			{
				@Override
				public void $invoke(InquiryPacket p1)
				{
					if (meEp != null)
						meEp.continueProcessing(meIp);
				}
			}, ip.failure, null, IPType.RELATION_NARROWS);
			rootNarrowsPacket.subPackets = narrowsPackets;
			ip.subPackets.push(rootNarrowsPacket);
		}
	}

	private void pushBroadensPacketsToIp()
	{
		if (broadensPackets.$length() > 0)
		{
			final AssertionProcessor meEp = ep;
			final InquiryPacket meIp = ip;
			InquiryPacket rootBroadensPacket = new InquiryPacket(ip.subject, null, null, ip.context, new Callback1<InquiryPacket>()
			{
				@Override
				public void $invoke(InquiryPacket p1)
				{
					if (meEp != null)
						meEp.continueProcessing(meIp);
				}
			}, ip.failure, null, IPType.RELATION_BROADENS);
			rootBroadensPacket.subPackets = broadensPackets;
			ip.subPackets.push(rootBroadensPacket);
		}
	}

	private void finishRelationProcessing()
	{
		pushRequiredPacketsToIp();
		pushNarrowsPacketsToIp();
		pushBroadensPacketsToIp();
		success.$invoke();
	}

	private void processGetRelatedCompetencySuccess(EcCompetency relatedCompetency, EcAlignment alignment)
	{
		numberOfRelationsProcessed++;
		final AssertionProcessor meEp = ep;
		final InquiryPacket meIp = ip;

		if (processedAlignments.$get(alignment.shortId()) != null)
		{
			ip.numberOfQueriesRunning--;
			checkForFinish();
			return;
		}
		processedAlignments.$put(alignment.shortId(), "done");
		
		log("Adding new " + alignment.relationType + " relationship packet");

		if (EcAlignment.IS_EQUIVALENT_TO.equals(alignment.relationType))
		{
			InquiryPacket ip2 = null;
			ip.equivalentPackets.push(ip2 = new InquiryPacket(ip.subject, relatedCompetency, null, ip.context, new Callback1<InquiryPacket>()
			{
				@Override
				public void $invoke(InquiryPacket p1)
				{
					if (meEp != null)
						meEp.continueProcessing(meIp);
				}
			}, ip.failure, null, IPType.COMPETENCY));
//			ip2.equivalentPackets.push(ip);
		}
		else if (EcAlignment.REQUIRES.equals(alignment.relationType))
		{
			requiredPackets.push(new InquiryPacket(ip.subject, relatedCompetency, null, ip.context, new Callback1<InquiryPacket>()
			{
				@Override
				public void $invoke(InquiryPacket p1)
				{
					if (meEp != null)
						meEp.continueProcessing(meIp);
				}
			}, ip.failure, null, IPType.COMPETENCY));
		}
		else if (EcAlignment.NARROWS.equals(alignment.relationType))
		{
			if (ip.hasId(alignment.source))
				narrowsPackets.push(new InquiryPacket(ip.subject, relatedCompetency, null, ip.context, new Callback1<InquiryPacket>()
				{
					@Override
					public void $invoke(InquiryPacket p1)
					{
						if (meEp != null)
							meEp.continueProcessing(meIp);
					}
				}, ip.failure, null, IPType.COMPETENCY));
			else
				broadensPackets.push(new InquiryPacket(ip.subject, relatedCompetency, null, ip.context, new Callback1<InquiryPacket>()
				{
					@Override
					public void $invoke(InquiryPacket p1)
					{
						if (meEp != null)
							meEp.continueProcessing(meIp);
					}
				}, ip.failure, null, IPType.COMPETENCY));
		}
		ip.numberOfQueriesRunning--;
		checkForFinish();
	}

	private void checkForFinish()
	{
		if (numberOfRelationsProcessed >= numberOfRelationsToProcess)
			finishRelationProcessing();
	}

	private void processFindCompetencyRelationshipSuccess(final EcAlignment alignment, final InquiryPacket ip)
	{
		ip.numberOfQueriesRunning--;
		String relatedCompetencyId = null;
		if (ip.hasId(alignment.source))
			relatedCompetencyId = alignment.target;
		else if (ip.hasId(alignment.target))
			relatedCompetencyId = alignment.source;
		else
		{
			numberOfRelationsProcessed++;
			checkForFinish();
			return;
		}
		log("Relationship found (" + alignment.relationType + ") source: " + alignment.source + " target: " + alignment.target);
		
		ip.numberOfQueriesRunning++;
		final RelationshipPacketGenerator rpg = this;
		EcCompetency.get(relatedCompetencyId, new Callback1<EcCompetency>()
		{
			@Override
			public void $invoke(EcCompetency p1)
			{
				rpg.processGetRelatedCompetencySuccess(p1, alignment);
			}
		}, new Callback1<String>()
		{
			@Override
			public void $invoke(String p1)
			{
				rpg.processEventFailure(p1, ip);
			}
		});
	}

	public void go()
	{
		final RelationshipPacketGenerator rpg = this;
		if (ip.getContext().relation == null)
			success.$invoke();
		else
		{
			numberOfRelationsToProcess = ip.getContext().relation.$length();
			numberOfRelationsProcessed = 0;
			for (int i = 0; i < ip.getContext().relation.$length(); i++)
			{
				ip.numberOfQueriesRunning++;
				EcAlignment.get(ip.getContext().relation.$get(i), new Callback1<EcAlignment>()
				{
					@Override
					public void $invoke(EcAlignment p1)
					{
						rpg.processFindCompetencyRelationshipSuccess(p1, rpg.ip);
					}
				}, new Callback1<String>()
				{
					@Override
					public void $invoke(String p1)
					{
						rpg.processEventFailure(p1, rpg.ip);
					}
				});
			}
		}
	}

}
