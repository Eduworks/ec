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
import org.stjs.javascript.functions.Callback1;

import com.eduworks.ec.crypto.EcPk;

public class EvidenceProcessor
{
	public Array<EcRepository> repositories;
	public boolean step;
	public Callback1<Object> logFunction;

	public EvidenceProcessor()
	{
		repositories = new Array<EcRepository>();
		step = true;
	}

	protected void log(Object string)
	{
		if (logFunction != null)
			logFunction.$invoke(string);
	}

	public void has(EcPk subject, EcCompetency competency, EcLevel level, EcFramework context, Callback1<InquiryPacket> success, Callback1<String> failure)
	{
		InquiryPacket ip = new InquiryPacket(subject, competency, level, context, success, failure);

		log("Created new inquiry.");
		continueProcessing(ip);
	}

	public void continueProcessing(InquiryPacket ip)
	{
		// First, just check to see if the person has the competency. No rollup
		// necessary.
		if (!ip.finished)
		{
			if (ip.checkedAssertionsAboutCompetency == false)
				hasAssertionAboutCompetency(ip);
			else if (ip.checkedRollupRulesAboutCompetency == false)
				hasRollupRulesAboutCompetency(ip);
			else if (ip.foundRollupRuleAboutCompetency == false && ip.checkedDefaultRuleAboutCompetency == false)
				defaultRollupRulesAboutCompetency(ip);
			else
				ip.finished = true;
		}
		if (ip.finished)
			for (int i = 0; i < ip.equivalentPackets.$length(); i++)
			{
				InquiryPacket eip = ip.equivalentPackets.$get(i);
				continueProcessing(eip);
			}
	}

	private void hasAssertionAboutCompetency(final InquiryPacket ip)
	{
		final EvidenceProcessor me = this;
		log("Checking to see if the subject has an assertion about the competency.");
		for (int i = 0; i < repositories.$length(); i++)
		{
			EcRepository r = repositories.$get(i);
			ip.queriesRunning++;
			log("Searching: " + r.selectedServer);
			r.search(new EcAssertion().getSearchStringByTypeAndCompetency(ip.competency), new Callback1<EcRemoteLinkedData>()
			{
				@Override
				public void $invoke(EcRemoteLinkedData p1)
				{
					EcAssertion a = new EcAssertion();
					a.copyFrom(p1);
					if (a.getSubject().equals(ip.subject))
					{
						me.log("Matching Assertion found.");
						if (a.getAssertionDate() > new Date().getDate())
						{
							me.log("Assertion is made for a future date.");
							return;
						}
						if (a.getExpirationDate() <= new Date().getDate())
						{
							me.log("Assertion is expired. Skipping.");
							return;
						}
						me.log("No issues found with assertion.");
						me.log("Record Id: " + a.shortId());
						me.log("Confidence: " + a.confidence);
						me.log("Number of pieces of evidence: " + a.getEvidenceCount());
						me.log("Evidence:");
						for (int i = 0; i < a.getEvidenceCount(); i++)
							me.log("  " + a.getEvidence(i));
						me.log("Recording in inquiry.");
						ip.positive.push(a);
					}
				}
			}, new Callback1<Array<EcRemoteLinkedData>>()
			{
				@Override
				public void $invoke(Array<EcRemoteLinkedData> p1)
				{
					if (p1.$length() == 0)
						me.log("No results found.");
					ip.queriesRunning--;
					if (ip.queriesRunning == 0)
					{
						if (!me.step)
							me.continueProcessing(ip);
					}
				}
			}, new Callback1<String>()
			{
				@Override
				public void $invoke(String p1)
				{
					ip.queriesRunning--;
					ip.failure.$invoke(p1);
				}
			});
		}
		for (int i = 0; i < ip.context.relation.$length(); i++)
		{
			ip.queriesRunning++;
			EcAlignment.get(ip.context.relation.$get(i), new Callback1<EcAlignment>()
			{
				@Override
				public void $invoke(EcAlignment p1)
				{
					ip.queriesRunning--;
					if (!p1.source.equals(ip.competency) && !p1.target.equals(ip.competency))
						return;
					String otherCompetency = null;
					if (p1.source.equals(ip.competency))
						otherCompetency = p1.target;
					else
						otherCompetency = p1.source;

					if (p1.relationType.equals(EcAlignment.IS_EQUIVALENT_TO))
					{
						ip.queriesRunning++;
						EcCompetency.get(otherCompetency, new Callback1<EcCompetency>()
						{

							@Override
							public void $invoke(EcCompetency p1)
							{
								InquiryPacket newIp = new InquiryPacket(ip.subject, p1, null, ip.context, null, ip.failure);
								ip.equivalentPackets.push(newIp);

								ip.queriesRunning--;
								if (ip.queriesRunning == 0)
								{
									if (!me.step)
										me.continueProcessing(ip);
								}
							}
						}, new Callback1<String>()
						{
							@Override
							public void $invoke(String p1)
							{
								ip.queriesRunning--;
								ip.failure.$invoke(p1);
							}
						});
					}
				}
			}, new Callback1<String>()
			{

				@Override
				public void $invoke(String p1)
				{
					ip.queriesRunning--;
					ip.failure.$invoke(p1);
				}

			});
		}
		ip.checkedAssertionsAboutCompetency = true;
	}

	private void hasRollupRulesAboutCompetency(final InquiryPacket ip)
	{
		final EvidenceProcessor me = this;
		log("Checking to see if rollup rules exist for the competency.");
		for (int i = 0; i < ip.getContext().rollupRule.$length(); i++)
		{
			ip.queriesRunning++;
			EcRollupRule.get(ip.getContext().rollupRule.$get(i), new Callback1<EcRollupRule>()
			{
				@Override
				public void $invoke(EcRollupRule rr)
				{
					if (!rr.isId(ip.competency.shortId()))
						return;

					me.log("Found. Rule is: " + rr.rule);

					RollupRuleProcessor rrp = new RollupRuleProcessor(ip.subject);

					rrp.positive = ip.positive;
					rrp.negative = ip.negative;

					RollupRuleInterface rri = new RollupRuleInterface(rr.rule, rrp);

					rri.logFunction = me.logFunction;
					rri.success = new Callback1<Boolean>()
					{
						@Override
						public void $invoke(Boolean p1)
						{
							me.log("Rollup Rule completed.");
							ip.queriesRunning--;
							ip.status = p1;
							ip.checkedRollupRulesAboutCompetency = true;
							if (ip.queriesRunning == 0)
							{
								if (!me.step)
									me.continueProcessing(ip);
							}
						}
					};
					rri.failure = ip.failure;
					me.log("Executing Rollup Rule Interpreter.");
					rri.go();
					ip.foundRollupRuleAboutCompetency = true;
				}
			}, new Callback1<String>()
			{
				@Override
				public void $invoke(String p1)
				{
					ip.queriesRunning--;
					ip.failure.$invoke(p1);
				}
			});
		}
	}

	private void defaultRollupRulesAboutCompetency(final InquiryPacket ip)
	{
		final EvidenceProcessor me = this;
		log("Checking to see if rollup rules exist for the competency.");
		ip.queriesRunning++;

		RollupRuleGenerator g = new RollupRuleGenerator(ip);
		g.failure = ip.failure;
		g.success = new Callback1<String>()
		{
			@Override
			public void $invoke(String rr)
			{
				me.log("Generated. Rule is: " + rr);

				RollupRuleProcessor rrp = new RollupRuleProcessor(ip.subject);

				rrp.positive = ip.positive;
				rrp.negative = ip.negative;

				RollupRuleInterface rri = new RollupRuleInterface(rr, rrp);

				rri.logFunction = me.logFunction;
				rri.success = new Callback1<Boolean>()
				{
					@Override
					public void $invoke(Boolean p1)
					{
						me.log("Rollup Rule completed.");
						ip.queriesRunning--;
						ip.status = p1;
						ip.checkedDefaultRuleAboutCompetency = true;
						if (ip.queriesRunning == 0)
						{
							if (!me.step)
								me.continueProcessing(ip);
						}
					}
				};
				rri.failure = ip.failure;
				me.log("Executing Rollup Rule Interpreter.");
				rri.go();
				ip.foundRollupRuleAboutCompetency = true;
			}
		};
		g.go();
	}
}
