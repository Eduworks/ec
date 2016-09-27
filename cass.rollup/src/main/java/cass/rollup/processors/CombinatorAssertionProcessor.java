package cass.rollup.processors;

import org.cass.competency.EcCompetency;
import org.cass.competency.EcRollupRule;
import org.cass.profile.EcAssertion;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.Date;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;

import com.eduworks.ec.crypto.EcPk;

import cass.rollup.InquiryPacket;
import cass.rollup.RelationshipPacketGenerator;
import cass.rollup.InquiryPacket.IPType;
import cass.rollup.rule.RollupRuleInterface;
import cass.rollup.rule.RollupRuleProcessor;

public abstract class CombinatorAssertionProcessor extends AssertionProcessor
{
	private void processFoundAssertion(EcRemoteLinkedData searchData, InquiryPacket ip)
	{
		EcAssertion a = new EcAssertion();
		a.copyFrom(searchData);
		EcPk currentSubject;
		for (int i = 0; i < ip.subject.$length(); i++)
		{
			currentSubject = ip.subject.$get(i);
			if (a.getSubject() == null)
				continue;
			if (a.getSubject().equals(currentSubject))
			{
				log(ip, "Matching Assertion found.");
				if (a.getAssertionDate() > (long) new Date().getTime())
				{
					log(ip, "Assertion is made for a future date.");
					return;
				}
				else if (a.getExpirationDate() <= (long) new Date().getTime())
				{
					log(ip, "Assertion is expired. Skipping.");
					return;
				}
				logFoundAssertion(a, ip);
				if (a.getNegative())
				{
					log(ip, "Found valid negative assertion");
					ip.negative.push(a);
				}
				else
				{
					log(ip, "Found valid positive assertion");
					ip.positive.push(a);
				}
			}
		}
	}

	private void processFindAssertionsSuccess(Array<EcRemoteLinkedData> data, InquiryPacket ip)
	{
		if (data.$length() == 0)
			log(ip, "No results found.");
		else
			log(ip, "Total number of assertions found: " + data.$length());
		ip.numberOfQueriesRunning--;
		checkStep(ip);
	}

	protected void findSubjectAssertionsForCompetency(final InquiryPacket ip)
	{
		ip.hasCheckedAssertionsForCompetency = true;
		if (IPType.RELATION_AND.equals(ip.type) || IPType.RELATION_OR.equals(ip.type) || IPType.RELATION_NARROWS.equals(ip.type)
				|| IPType.RELATION_BROADENS.equals(ip.type) || IPType.RELATION_REQUIRES.equals(ip.type))
		{
			log(ip, "No assertions for combinator types");
			checkStep(ip);
			return;
		}
		final CombinatorAssertionProcessor ep = this;
		for (int i = 0; i < repositories.$length(); i++)
		{
			EcRepository currentRepository = repositories.$get(i);
			ip.numberOfQueriesRunning++;
			log(ip, "Searching: " + currentRepository.selectedServer);
			for (int h = 0; h < ip.competency.$length(); h++)
			{
				EcCompetency competency = ip.competency.$get(h);
				log(ip, "Querying repositories for subject assertions on competency: " + competency.id);
				currentRepository.search(buildAssertionSearchQuery(ip, competency), new Callback1<EcRemoteLinkedData>()
				{
					@Override
					public void $invoke(EcRemoteLinkedData p1)
					{
						ep.processFoundAssertion(p1, ip);
					}
				}, new Callback1<Array<EcRemoteLinkedData>>()
				{
					@Override
					public void $invoke(Array<EcRemoteLinkedData> p1)
					{
						ep.processFindAssertionsSuccess(p1, ip);
					}
				}, new Callback1<String>()
				{
					@Override
					public void $invoke(String p1)
					{
						ep.processEventFailure(p1, ip);
					}
				});
			}
		}
	}

	protected void findCompetencyRelationships(final InquiryPacket ip)
	{
		ip.hasCheckedRelationshipsForCompetency = true;
		if (IPType.RELATION_AND.equals(ip.type) || IPType.RELATION_OR.equals(ip.type) || IPType.RELATION_NARROWS.equals(ip.type)
				|| IPType.RELATION_BROADENS.equals(ip.type) || IPType.RELATION_REQUIRES.equals(ip.type))
		{
			log(ip, "No relationships for combinator types");
			checkStep(ip);
			return;
		}
		final CombinatorAssertionProcessor ep = this;
		for (int i = 0; i < ip.competency.$length(); i++)
		{
			log(ip, "Finding relationships for competency: " + ip.competency.$get(i));
			findCompetencyRelationship(ip, ep, ip.competency.$get(i));
		}
	}

	protected void findCompetencyRelationship(final InquiryPacket ip, final CombinatorAssertionProcessor ep, final EcCompetency c)
	{
		RelationshipPacketGenerator rpg = new RelationshipPacketGenerator(ip, ep, processedEquivalencies);
		rpg.failure = ip.failure;
		rpg.logFunction = logFunction;
		rpg.success = new Callback0()
		{
			@Override
			public void $invoke()
			{
				ep.processRelationshipPacketsGenerated(ip, c);
			}
		};
		log(ip, "Executing relationship packet generator");
		ip.numberOfQueriesRunning++;
		rpg.go();
	}

	protected void processFindRollupRuleSuccess(EcRollupRule rr, final InquiryPacket ip)
	{
		// TODO, need to take another pass with antlr...Nested competencies
		// checks is messed up
		// Things like this will fail [(competency:Addition1 OR
		// competency:Addition2) AND confidence>0.6]
		if (!ip.hasId(rr.competency))
			return;
		final AssertionProcessor ep = this;
		log(ip, "Found rollup rule: " + rr.rule);
		RollupRuleProcessor rrp = new RollupRuleProcessor(ip, this);
		rrp.positive = ip.positive;
		rrp.negative = ip.negative;
		RollupRuleInterface rri = new RollupRuleInterface(rr.rule, rrp);
		rri.logFunction = logFunction;
		rri.success = new Callback1<Boolean>()
		{
			@Override
			public void $invoke(Boolean p1)
			{
				ep.processRollupRuleInterpretSuccess(p1, ip);
			}
		};
		rri.failure = ip.failure;
		log(ip, "Executing rollup rule interpreter");
		rri.go();
	}

}
