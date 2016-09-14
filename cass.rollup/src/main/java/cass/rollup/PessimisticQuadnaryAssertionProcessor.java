package cass.rollup;

import org.cass.competency.EcAlignment;
import org.cass.competency.EcCompetency;
import org.cass.competency.EcFramework;
import org.cass.competency.EcLevel;
import org.cass.competency.EcRollupRule;
import org.cass.profile.EcAssertion;
import org.cassproject.ebac.repository.EcRepository;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.Date;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.Map;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;

import com.eduworks.ec.callback.EcCallbackReturn0;
import com.eduworks.ec.callback.EcCallbackReturn1;
import com.eduworks.ec.crypto.EcPk;
import com.eduworks.schema.ebac.EbacSignature;

import cass.rollup.InquiryPacket.IPType;
import cass.rollup.InquiryPacket.ResultType;

public class PessimisticQuadnaryAssertionProcessor
{
	public Array<EcRepository> repositories;
	public boolean step;
	public Callback1<Object> logFunction;

	private static final boolean DEF_STEP = false;

	private Map<String, String> processedEquivalencies;

	public PessimisticQuadnaryAssertionProcessor()
	{
		repositories = new Array<EcRepository>();
		step = DEF_STEP;
	}

	protected void log(InquiryPacket ip, Object string)
	{
		if (logFunction != null)
			logFunction.$invoke(string);
		ip.log += "\n" + string;
	}

	public void has(Array<EcPk> subject, EcCompetency competency, EcLevel level, EcFramework context, Array<EbacSignature> additionalSignatures,
			Callback1<InquiryPacket> success, EcCallbackReturn1<String> ask, Callback1<String> failure)
	{
		InquiryPacket ip = new InquiryPacket(subject, competency, level, context, success, failure, null, IPType.COMPETENCY);
		processedEquivalencies = JSCollections.$map();
		log(ip, "Created new inquiry.");
		continueProcessing(ip);
	}

	public boolean isIn(InquiryPacket ip,Array<InquiryPacket> alreadyDone)
	{
		for (int i = 0;i < alreadyDone.$length();i++)
			if (ip == alreadyDone.$get(i))
				return true;
		return false;
	}

	public boolean continueProcessing(InquiryPacket ip)
	{
		// Build inquiry packet tree
		if (!ip.finished)
		{
			if (!ip.hasCheckedAssertionsForCompetency)
			{
				findSubjectAssertionsForCompetency(ip);
				return true;
			}
			else if (!ip.hasCheckedRelationshipsForCompetency)
			{
				findCompetencyRelationships(ip);
				return true;
			}
			else if (!ip.hasCheckedRollupRulesForCompetency)
			{
				findRollupRulesForCompetency(ip);
				return true;
			}
			else
			{
				ip.finished = true;
			}
		}
		if (ip.finished)
		{
			if (processChildPackets(ip.equivalentPackets))
				return true;
			if (processChildPackets(ip.subPackets))
				return true;
		}
		// determine result
		if (ip.result == null)
		{
			determineResult(ip);
			if (ip.result != null && ip.success != null)
				ip.success.$invoke(ip);
			return true;
		}
		return false;
	}

	private boolean processChildPackets(Array<InquiryPacket> childPackets)
	{
		if (childPackets != null)
		{
			for (int i = 0; i < childPackets.$length(); i++)
			{
				if (continueProcessing(childPackets.$get(i)))
					return true;
				// TB - not sure why this return was here
				// FR - The return is here because we don't want to process
				// multiple things at the same time, as it locks up the UI
				// thread and spams the log with async data.
				// FR - "drip processing" makes the logs more readable and will
				// interrupt the UI thread less.
			}
		}
		return false;
	}

	private void checkStep(InquiryPacket ip)
	{
		// TODO Fritz, please make sure this is correct
		log(ip, "Checkstep: " + ip.numberOfQueriesRunning);
		if (ip.numberOfQueriesRunning == 0)
		{
			if (!step)
				continueProcessing(ip);
		}
		// FR - This isn't a polling loop. If step is turned on, then we expect
		// an external process to keep clicking continueProcessing.
		// FR - If step is turned off, when a single thing gets done, we can
		// start doing the next thing.
		// FR - This is another artifact of 'drip processing', where we have to
		// trickle the process and allow the UI thread to jump in and refresh
		// the screen during any async operation.
		// else
		// {
		// checkStep(ip);
		// }
	}

	private void processEventFailure(String message, InquiryPacket ip)
	{
		log(ip, "Event failed: " + message);
		ip.numberOfQueriesRunning--;
		ip.failure.$invoke(message);
	}

	private void logFoundAssertion(EcAssertion a, InquiryPacket ip)
	{
		log(ip, "No issues found with assertion.");
		log(ip, "Record Id: " + a.shortId());
		log(ip, "Confidence: " + a.confidence);
		log(ip, "Number of pieces of evidence: " + a.getEvidenceCount());
		log(ip, "Evidence:");
		for (int j = 0; j < a.getEvidenceCount(); j++)
			log(ip, "  " + a.getEvidence(j));
		log(ip, "Recording in inquiry.");
	}

	private void processFoundAssertion(EcRemoteLinkedData searchData, InquiryPacket ip)
	{
		EcAssertion a = new EcAssertion();
		a.copyFrom(searchData);
		EcPk currentSubject;
		for (int i = 0; i < ip.subject.$length(); i++)
		{
			currentSubject = ip.subject.$get(i);
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
				   log(ip,"Found valid negative assertion");
					ip.negative.push(a);
				}
				else
				{
				   log(ip,"Found valid positive assertion");
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

	private String buildAssertionSearchQuery(InquiryPacket ip)
	{
		if (IPType.ROLLUPRULE.equals(ip.type))
			return "(" + new EcAssertion().getSearchStringByType() + ") AND (" + ip.rule + ")";
		else if (IPType.COMPETENCY.equals(ip.type))
			return new EcAssertion().getSearchStringByTypeAndCompetency(ip.competency);
		throw new RuntimeException("Trying to build an assertion search query on an unsupported type: " + ip.type);
	}

	private void findSubjectAssertionsForCompetency(final InquiryPacket ip)
	{
		ip.hasCheckedAssertionsForCompetency = true;
		if (IPType.COMBINATOR_AND.equals(ip.type) || IPType.COMBINATOR_OR.equals(ip.type) || IPType.COMBINATOR_NARROWS.equals(ip.type)|| IPType.COMBINATOR_BROADENS.equals(ip.type)
				|| IPType.COMBINATOR_REQUIRES.equals(ip.type))
		{
			log(ip, "No assertions for combinator types");
			checkStep(ip);
			return;
		}
		final PessimisticQuadnaryAssertionProcessor ep = this;
		log(ip, "Querying repositories for subject assertions on competency: " + ip.competency.id);
		for (int i = 0; i < repositories.$length(); i++)
		{
			EcRepository currentRepository = repositories.$get(i);
			ip.numberOfQueriesRunning++;
			log(ip, "Searching: " + currentRepository.selectedServer);
			currentRepository.search(buildAssertionSearchQuery(ip), new Callback1<EcRemoteLinkedData>()
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

	private void processRelationshipPacketsGenerated(InquiryPacket ip)
	{
		log(ip, "Relationships succesfully processed for: " + ip.competency.id);
		ip.numberOfQueriesRunning--;
		checkStep(ip);
	}

	private void findCompetencyRelationships(final InquiryPacket ip)
	{
		ip.hasCheckedRelationshipsForCompetency = true;
		if (IPType.COMBINATOR_AND.equals(ip.type) || IPType.COMBINATOR_OR.equals(ip.type) || IPType.COMBINATOR_NARROWS.equals(ip.type)|| IPType.COMBINATOR_BROADENS.equals(ip.type)
				|| IPType.COMBINATOR_REQUIRES.equals(ip.type))
		{
			log(ip, "No relationships for combinator types");
			checkStep(ip);
			return;
		}
		final PessimisticQuadnaryAssertionProcessor ep = this;
		log(ip, "Finding relationships for competency: " + ip.competency.id);
		RelationshipPacketGenerator rpg = new RelationshipPacketGenerator(ip, ep, processedEquivalencies);
		rpg.failure = ip.failure;
		rpg.logFunction = logFunction;
		rpg.success = new Callback0()
		{
			@Override
			public void $invoke()
			{
				ep.processRelationshipPacketsGenerated(ip);
			}
		};
		log(ip, "Executing relationship packet generator");
		ip.numberOfQueriesRunning++;
		rpg.go();
	}

	private void processRollupRuleInterpretSuccess(Boolean status, InquiryPacket ip)
	{
		log(ip, "Rollup rule successfully interpreted.");
		ip.numberOfQueriesRunning--;
		ip.status = status;
		checkStep(ip);
	}

	private void processFindRollupRuleSuccess(EcRollupRule rr, final InquiryPacket ip)
	{
		// TODO, need to take another pass with antlr...Nested competencies
		// checks is messed up
		// Things like this will fail [(competency:Addition1 OR
		// competency:Addition2) AND confidence>0.6]
		if (!ip.competency.isId(rr.competency))
			return;
		final PessimisticQuadnaryAssertionProcessor ep = this;
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

	private void findRollupRulesForCompetency(final InquiryPacket ip)
	{
		ip.hasCheckedRollupRulesForCompetency = true;
		if (IPType.COMBINATOR_AND.equals(ip.type) || IPType.COMBINATOR_OR.equals(ip.type) || IPType.COMBINATOR_NARROWS.equals(ip.type)|| IPType.COMBINATOR_BROADENS.equals(ip.type)
				|| IPType.COMBINATOR_REQUIRES.equals(ip.type))
		{
			log(ip, "No rollup rules for combinator types");
			checkStep(ip);
			return;
		}
		log(ip, "Finding rollup rules for competency: " + ip.competency.id);
		final PessimisticQuadnaryAssertionProcessor ep = this;
		if (ip.getContext().rollupRule == null)
			continueProcessing(ip);
		else
			for (int i = 0; i < ip.getContext().rollupRule.$length(); i++)
			{
				ip.numberOfQueriesRunning++;
				EcRollupRule.get(ip.getContext().rollupRule.$get(i), new Callback1<EcRollupRule>()
				{
					@Override
					public void $invoke(EcRollupRule rr)
					{
						ep.processFindRollupRuleSuccess(rr, ip);
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
	
	private void determineCombinatorAndResult(InquiryPacket ip)
	{
		if (ip.anyChildPacketsAreFalse())
			ip.result = ResultType.FALSE;
		else if (ip.anyIndeterminantChildPackets())
			ip.result = ResultType.INDETERMINANT;
		else if (ip.anyChildPacketsAreUnknown())
			ip.result = ResultType.UNKNOWN;
		else
			ip.result = ResultType.TRUE;
	}

	private void determineCombinatorNarrowsResult(InquiryPacket ip)
	{
		if (ip.anyChildPacketsAreTrue())
			ip.result = ResultType.TRUE;
		else
			ip.result = ResultType.UNKNOWN;
	}

	private void determineCombinatorBroadensResult(InquiryPacket ip)
	{
		if (ip.anyChildPacketsAreFalse())
			ip.result = ResultType.FALSE;
		else
			ip.result = ResultType.UNKNOWN;
	}

	private void determineCombinatorRequiresResult(InquiryPacket ip)
	{
		if (ip.anyChildPacketsAreFalse())
			ip.result = ResultType.FALSE;
		else
			ip.result = ResultType.UNKNOWN;
	}

	private void determineCombinatorOrResult(InquiryPacket ip)
	{
		if (ip.anyChildPacketsAreTrue())
			ip.result = ResultType.TRUE;
		else if (ip.anyIndeterminantChildPackets())
			ip.result = ResultType.INDETERMINANT;
		else if (ip.allChildPacketsUnknown())
			ip.result = ResultType.UNKNOWN;
		else
			ip.result = ResultType.FALSE;
	}

	private ResultType getPacketAssertionResult(InquiryPacket ip)
	{
		if (ip.positive.$length() > 0 && ip.negative.$length() == 0)
			return ResultType.TRUE;
		else if (ip.positive.$length() == 0 && ip.negative.$length() > 0)
			return ResultType.FALSE;
		else if (ip.positive.$length() > 0 && ip.negative.$length() > 0)
			return ResultType.INDETERMINANT;
		else
			return ResultType.UNKNOWN;
	}

	private void determineResultForUnknownAssertionResult(InquiryPacket ip)
	{
		if (ip.allChildPacketsUnknown())
			ip.result = ResultType.UNKNOWN;
		else if (ip.allEquivalentPacketsUnknown())
		{
			if (ip.allSubPacketsTrueOrUnknown())
				ip.result = ResultType.TRUE;
			else if (ip.allEquivalentPacketsFalseOrUnknown())
				ip.result = ResultType.FALSE;
			else
				ip.result = ResultType.INDETERMINANT;
		}
		else if (ip.allEquivalentPacketsTrueOrUnknown())
		{
			if (ip.allSubPacketsTrueOrUnknown())
				ip.result = ResultType.TRUE;
			else
				ip.result = ResultType.INDETERMINANT;
		}
		else if (ip.allEquivalentPacketsFalseOrUnknown())
		{
			if (ip.allSubPacketsFalseOrUnknown())
				ip.result = ResultType.FALSE;
			else
				ip.result = ResultType.INDETERMINANT;
		}
		else
			ip.result = ResultType.INDETERMINANT;
	}

	private void determineResultForTrueAssertionResult(InquiryPacket ip)
	{
		if (ip.allEquivalentPacketsTrueOrUnknown())
		{
			if (ip.allSubPacketsTrueOrUnknown())
				ip.result = ResultType.TRUE;
			else
				ip.result = ResultType.INDETERMINANT;
		}
		else
			ip.result = ResultType.INDETERMINANT;
	}

	private void determineResultForFalseAssertionResult(InquiryPacket ip)
	{
		if (ip.allEquivalentPacketsFalseOrUnknown())
		{
			if (ip.allSubPacketsFalseOrUnknown())
				ip.result = ResultType.FALSE;
			else
				ip.result = ResultType.INDETERMINANT;
		}
		else
			ip.result = ResultType.INDETERMINANT;
	}

	/**
	 * IF IP type is COMPETENCY|ROLLUPRULE: assertionResult = ( IF number of
	 * positive assertions > 0 && number of negative assertions = 0 THEN
	 * assertionResult = TRUE IF number of positive assertions = 0 && number of
	 * negative assertions > 0 THEN assertionResult = FALSE IF number of
	 * positive assertions > 0 && number of negative assertions > 0 THEN
	 * assertionResult = INDETERMINANT IF number of positive assertions = 0 &&
	 * number of negative assertions = 0 THEN assertionResult = UNKNOWN )
	 * 
	 * IF assertionResult = INDETERMINANT THEN INDETERMINANT ELSE IF any
	 * equivalent packets = INDETERMINANT THEN INDETERMINANT ELSE IF any sub
	 * packets = INDETERMINANT THEN INDETERMINANT
	 * 
	 * ELSE IF assertionResult = UNKNOWN: IF all equivalent packets = UNKNOWN IF
	 * all sub packets = UNKNOWN THEN UNKNOWN IF all sub packets = TRUE|UNKNOWN
	 * THEN TRUE IF all sub packets = FALSE|UNKNOWN THEN FALSE ELSE
	 * INDETERMINANT
	 * 
	 * ELSE IF all equivalent packets = TRUE|UNKNOWN IF all sub packets =
	 * TRUE|UNKNOWN THEN TRUE ELSE INDETERMINANT
	 * 
	 * ELSE IF all equivalent packets = FALSE|UNKNOWN IF all sub packets =
	 * FALSE|UNKNOWN THEN FALSE ELSE INDETERMINANT
	 * 
	 * ELSE INDETERMINANT
	 * 
	 * 
	 * ELSE IF assertionResult = TRUE: IF all equivalent packets = TRUE|UNKNOWN
	 * IF all sub packets = TRUE|UNKNOWN THEN TRUE ELSE INDETERMINANT
	 * 
	 * ELSE INDETERMINANT
	 * 
	 * ELSE IF assertionResult = FALSE: IF all equivalent packets =
	 * FALSE|UNKNOWN IF all sub packets = FALSE|UNKNOWN THEN FALSE ELSE
	 * INDETERMINANT
	 * 
	 * ELSE INDETERMINANT
	 * 
	 */
	private void determineCompetencyRollupRuleResult(InquiryPacket ip)
	{
		ResultType assertionResult = getPacketAssertionResult(ip);
		if (ResultType.INDETERMINANT.equals(assertionResult) || ip.anyIndeterminantChildPackets())
			ip.result = ResultType.INDETERMINANT;
		else if (ResultType.UNKNOWN.equals(assertionResult))
			determineResultForUnknownAssertionResult(ip);
		else if (ResultType.TRUE.equals(assertionResult))
			determineResultForTrueAssertionResult(ip);
		else
			determineResultForFalseAssertionResult(ip);
	}

	private void determineResult(InquiryPacket ip)
	{
		if (ip.numberOfQueriesRunning == 0)
		{
			if (IPType.COMBINATOR_AND.equals(ip.type))
				determineCombinatorAndResult(ip);
			else if (IPType.COMBINATOR_OR.equals(ip.type))
				determineCombinatorOrResult(ip);
			else if (IPType.COMBINATOR_NARROWS.equals(ip.type))
				determineCombinatorNarrowsResult(ip);
			else if (IPType.COMBINATOR_BROADENS.equals(ip.type))
				determineCombinatorBroadensResult(ip);
			else if (IPType.COMBINATOR_REQUIRES.equals(ip.type))
				determineCombinatorRequiresResult(ip);
			else
				determineCompetencyRollupRuleResult(ip);
		}
		else
		{
			log(ip, "We are not finished accumulating data to answer this query. Error: " + ip.numberOfQueriesRunning);

		}
	}

}
