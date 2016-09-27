package cass.rollup.processors;

import org.cass.competency.EcCompetency;
import org.cass.competency.EcFramework;
import org.cass.competency.EcLevel;
import org.cass.competency.EcRollupRule;
import org.cass.profile.EcAssertion;
import org.cassproject.ebac.repository.EcRepository;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.Map;
import org.stjs.javascript.functions.Callback1;

import com.eduworks.ec.callback.EcCallbackReturn1;
import com.eduworks.ec.crypto.EcPk;
import com.eduworks.schema.ebac.EbacSignature;

import cass.rollup.InquiryPacket;
import cass.rollup.InquiryPacket.IPType;

public abstract class AssertionProcessor
{
	public Array<EcRepository> repositories;
	public boolean step;
	public Callback1<Object> logFunction;

	private static final boolean DEF_STEP = false;

	public Map<String, String> processedEquivalencies;

	public AssertionProcessor()
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

	public boolean isIn(InquiryPacket ip, Array<InquiryPacket> alreadyDone)
	{
		for (int i = 0; i < alreadyDone.$length(); i++)
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

	protected abstract void determineResult(InquiryPacket ip);

	protected abstract void findCompetencyRelationships(InquiryPacket ip);

	protected abstract void findSubjectAssertionsForCompetency(InquiryPacket ip);

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

	protected void checkStep(InquiryPacket ip)
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

	protected void processEventFailure(String message, InquiryPacket ip)
	{
		log(ip, "Event failed: " + message);
		ip.numberOfQueriesRunning--;
		ip.failure.$invoke(message);
	}

	protected void logFoundAssertion(EcAssertion a, InquiryPacket ip)
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

	protected String buildAssertionSearchQuery(InquiryPacket ip, EcCompetency competency)
	{
		if (IPType.ROLLUPRULE.equals(ip.type))
			return "(" + new EcAssertion().getSearchStringByType() + ") AND (" + ip.rule + ")";
		else if (IPType.COMPETENCY.equals(ip.type))
			return new EcAssertion().getSearchStringByTypeAndCompetency(competency);
		throw new RuntimeException("Trying to build an assertion search query on an unsupported type: " + ip.type);
	}

	protected void processRelationshipPacketsGenerated(InquiryPacket ip, EcCompetency competency)
	{
		log(ip, "Relationships succesfully processed for: " + competency.id);
		ip.numberOfQueriesRunning--;
		checkStep(ip);
	}

	protected void processRollupRuleInterpretSuccess(Boolean status, InquiryPacket ip)
	{
		log(ip, "Rollup rule successfully interpreted.");
		ip.numberOfQueriesRunning--;
		ip.status = status;
		checkStep(ip);
	}

	private void findRollupRulesForCompetency(final InquiryPacket ip)
	{
		ip.hasCheckedRollupRulesForCompetency = true;
		if (!IPType.COMPETENCY.equals(ip.type) && !IPType.ROLLUPRULE.equals(ip.type))
		{
			log(ip, "No rollup rules for combinator types");
			checkStep(ip);
			return;
		}
		final AssertionProcessor ep = this;
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

	protected abstract void processFindRollupRuleSuccess(EcRollupRule rr, InquiryPacket ip)
	;

}
