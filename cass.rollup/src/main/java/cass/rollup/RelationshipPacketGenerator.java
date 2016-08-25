package cass.rollup;

import org.cass.competency.EcAlignment;
import org.cass.competency.EcCompetency;
import org.stjs.javascript.Array;
import org.stjs.javascript.Map;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;

import cass.rollup.InquiryPacket.IPType;

public class RelationshipPacketGenerator
{

	public Callback1<String> failure;
	public Callback0 success;
	public Callback1<Object> logFunction;
	
	private int numberOfRelationsToProcess = 0;
	private int numberOfRelationsProcessed = 0;

	public Array<InquiryPacket> narrowsPackets;
	public Array<InquiryPacket> requiredPackets;
	private Map<String,String> processedEquivalencies;
	
	private EvidenceProcessor ep;
	private InquiryPacket ip;

	public RelationshipPacketGenerator(InquiryPacket ip, EvidenceProcessor ep, Map<String,String> processedEquivalencies)
	{
		this.ip = ip;
		this.ep = ep;
		this.processedEquivalencies = processedEquivalencies;
		narrowsPackets = new Array<InquiryPacket>();
		requiredPackets = new Array<InquiryPacket>();		
	}
	
	protected void log(Object string)
   {
      if (logFunction != null) logFunction.$invoke(string);
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
   		final EvidenceProcessor meEp = ep;
   		final InquiryPacket meIp = ip;
   		InquiryPacket rootRequiredPacket = new InquiryPacket(ip.subject, null, null, ip.context, new Callback1<InquiryPacket>()
   		{
   			@Override
   			public void $invoke(InquiryPacket p1)
   			{
   				if (meEp != null)
   				   meEp.continueProcessing(meIp);
   			}
   		}, ip.failure, null, IPType.COMBINATOR_REQUIRES);
   		rootRequiredPacket.subPackets = requiredPackets;
   		ip.subPackets.push(rootRequiredPacket);
	   }
	}

	private void pushNarrowsPacketsToIp()
	{
	   if (narrowsPackets.$length() > 0)
	   {
   		final EvidenceProcessor meEp = ep;
   		final InquiryPacket meIp = ip;
   		InquiryPacket rootNarrowsPacket = new InquiryPacket(ip.subject, null, null, ip.context, new Callback1<InquiryPacket>()
   		{
   			@Override
   			public void $invoke(InquiryPacket p1)
   			{
   				if (meEp != null)
   				   meEp.continueProcessing(meIp);
   			}
   		}, ip.failure, null, IPType.COMBINATOR_NARROWS);
   		rootNarrowsPacket.subPackets = narrowsPackets;
   		ip.subPackets.push(rootNarrowsPacket);
	   }
	}

	private void finishRelationProcessing()
	{
		pushRequiredPacketsToIp();
		pushNarrowsPacketsToIp();
		success.$invoke();
	}

	private void processGetRelatedCompetencySuccess(EcCompetency relatedCompetency, EcAlignment alignment)
	{
	   numberOfRelationsProcessed++;
	   final EvidenceProcessor meEp = ep;
      final InquiryPacket meIp = ip;
      log("Adding new " + alignment.relationType + " relationship packet");
		if (EcAlignment.IS_EQUIVALENT_TO.equals(alignment.relationType))
		{
		   processedEquivalencies.$put(alignment.source,alignment.target);
		   processedEquivalencies.$put(alignment.target,alignment.source);
			ip.equivalentPackets.push(new InquiryPacket(ip.subject, relatedCompetency, null, ip.context, new Callback1<InquiryPacket>()
			{
				@Override
				public void $invoke(InquiryPacket p1)
				{
					if (meEp != null)
					   meEp.continueProcessing(meIp);
				}
			}, ip.failure, null, IPType.COMPETENCY));
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
			narrowsPackets.push(new InquiryPacket(ip.subject, relatedCompetency, null, ip.context, new Callback1<InquiryPacket>()
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
	
	private boolean hasEquivalencyAlreadyBeenAdded(String sourceId, String targetId) 
	{
	   String eqId = processedEquivalencies.$get(sourceId);
	   if (targetId.equals(eqId)) 
      {
	      log("Equivalency was previously processed");
	      return true;      
      }
	   eqId = processedEquivalencies.$get(targetId);
	   if (sourceId.equals(eqId))
	   {
	      log("Equivalency was previously processed");
	      return true;
	   }
	   return false;
	}

	private void processFindCompetencyRelationshipSuccess(final EcAlignment alignment, final InquiryPacket ip)
	{
		ip.numberOfQueriesRunning--;	
		log("Relationship found (" + alignment.relationType + ") source: " + alignment.source + " target: " + alignment.target);
		if ((EcAlignment.IS_EQUIVALENT_TO.equals(alignment.relationType) && hasEquivalencyAlreadyBeenAdded(alignment.source,alignment.target)) ||
		    (!ip.competency.isId(alignment.source)))
		{
		   numberOfRelationsProcessed++;
		   checkForFinish();
		}
		else 
		{
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
