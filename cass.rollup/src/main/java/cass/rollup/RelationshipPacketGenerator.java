package cass.rollup;

import org.cass.competency.EcAlignment;
import org.cass.competency.EcCompetency;
import org.stjs.javascript.Array;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;

import cass.rollup.InquiryPacket.IPType;

public class RelationshipPacketGenerator
{

	public Callback1<String> failure;
	public Callback0 success;
	private InquiryPacket ip;
	private int numberOfRelationsToProcess = 0;
	private int numberOfRelationsProcessed = 0;

	public Array<InquiryPacket> narrowsPackets;
	public Array<InquiryPacket> requiredPackets;
	private EvidenceProcessor epo;

	public RelationshipPacketGenerator(InquiryPacket ip, EvidenceProcessor ep)
	{
		this.ip = ip;
		this.epo = ep;
		narrowsPackets = new Array<InquiryPacket>();
		requiredPackets = new Array<InquiryPacket>();
	}

	private void processEventFailure(String message, InquiryPacket ip)
	{
		ip.numberOfQueriesRunning--;
		failure.$invoke(message);
	}

	private void pushRequiredPacketsToIp()
	{
		final EvidenceProcessor ep = this.epo;
		final InquiryPacket meIp = ip;
		InquiryPacket rootRequiredPacket = new InquiryPacket(ip.subject, null, null, ip.context, new Callback1<InquiryPacket>()
		{
			@Override
			public void $invoke(InquiryPacket p1)
			{
				if (ep != null)
					ep.continueProcessing(meIp);
			}
		}, ip.failure, null, IPType.COMBINATOR_AND);
		rootRequiredPacket.subPackets = requiredPackets;
		ip.subPackets.push(rootRequiredPacket);
	}

	private void pushNarrowsPacketsToIp()
	{
		final EvidenceProcessor ep = this.epo;
		final InquiryPacket meIp = ip;
		InquiryPacket rootNarrowsPacket = new InquiryPacket(ip.subject, null, null, ip.context, new Callback1<InquiryPacket>()
		{
			@Override
			public void $invoke(InquiryPacket p1)
			{
				if (ep != null)
					ep.continueProcessing(meIp);
			}
		}, ip.failure, null, IPType.COMBINATOR_OR);
		rootNarrowsPacket.subPackets = narrowsPackets;
		ip.subPackets.push(rootNarrowsPacket);
	}

	private void finishRelationProcessing()
	{
		pushRequiredPacketsToIp();
		pushNarrowsPacketsToIp();
		success.$invoke();
	}

	private void processGetRelatedCompetencySuccess(EcCompetency relatedCompetency, String relationType, final InquiryPacket ip)
	{
		final EvidenceProcessor ep = this.epo;
		numberOfRelationsProcessed++;
		if (EcAlignment.IS_EQUIVALENT_TO.equals(relationType))
		{
			ip.equivalentPackets.push(new InquiryPacket(ip.subject, relatedCompetency, null, ip.context, new Callback1<InquiryPacket>()
			{
				@Override
				public void $invoke(InquiryPacket p1)
				{
					if (ep != null)
						ep.continueProcessing(ip);
				}
			}, ip.failure, null, IPType.COMPETENCY));
		}
		else if (EcAlignment.REQUIRES.equals(relationType))
		{
			requiredPackets.push(new InquiryPacket(ip.subject, relatedCompetency, null, ip.context, new Callback1<InquiryPacket>()
			{
				@Override
				public void $invoke(InquiryPacket p1)
				{
					if (ep != null)
						ep.continueProcessing(ip);
				}
			}, ip.failure, null, IPType.COMPETENCY));
		}
		else if (EcAlignment.NARROWS.equals(relationType))
		{
			narrowsPackets.push(new InquiryPacket(ip.subject, relatedCompetency, null, ip.context, new Callback1<InquiryPacket>()
			{
				@Override
				public void $invoke(InquiryPacket p1)
				{
					if (ep != null)
						ep.continueProcessing(ip);
				}
			}, ip.failure, null, IPType.COMPETENCY));
		}
		ip.numberOfQueriesRunning--;
		if (numberOfRelationsProcessed >= numberOfRelationsToProcess)
			finishRelationProcessing();
	}

	private void processFindCompetencyRelationshipSuccess(final EcAlignment alignment, final InquiryPacket ip)
	{
		ip.numberOfQueriesRunning--;
		if (!ip.competency.isId(alignment.source) && !ip.competency.isId(alignment.target))
			return;
		String relatedCompetencyId = null;
		if (ip.competency.isId(alignment.source))
			relatedCompetencyId = alignment.target;
		else
			relatedCompetencyId = alignment.source;
		ip.numberOfQueriesRunning++;
		final RelationshipPacketGenerator rpg = this;
		EcCompetency.get(relatedCompetencyId, new Callback1<EcCompetency>()
		{
			@Override
			public void $invoke(EcCompetency p1)
			{
				rpg.processGetRelatedCompetencySuccess(p1, alignment.relationType, ip);
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
		// ip.hasCheckedRelationshipsForCompetency = true;
	}

}
