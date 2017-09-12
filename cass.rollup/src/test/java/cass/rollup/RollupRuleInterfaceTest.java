package cass.rollup;

import cass.rollup.InquiryPacket.IPType;
import cass.rollup.rule.RollupRuleInterface;
import cass.rollup.rule.RollupRuleProcessor;
import org.cass.competency.EcCompetency;
import org.cass.competency.EcFramework;
import org.cass.competency.EcRollupRule;
import org.cass.profile.EcAssertion;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.stjs.javascript.Global;
import org.stjs.javascript.functions.Callback1;
import org.stjs.testing.annotation.ScriptsBefore;
import org.stjs.testing.driver.STJSTestDriverRunner;

@RunWith(STJSTestDriverRunner.class)
@ScriptsBefore({ "lib/require.js", "rollupInit.js" })
public class RollupRuleInterfaceTest extends EvidenceProcessingTestBase
{

	@Before
	public void setup()
	{
		Global.console.log("setup");

	}

	@After
	public void breakdown()
	{

	}

	String input = "[competency:http://skyrepo.eduworks.com/service/data/schema.eduworks.com.cass.0.1.competency/d885dcd8-f00b-4ccf-82d8-ee14d6c84ef0 AND confidence:>0.6]"
			+ " AND [competency:http://skyrepo.eduworks.com/service/data/schema.eduworks.com.cass.0.1.competency/31971023-5d61-42c0-bc64-ae8e8b7f0d09 AND confidence:>0.6 ]"
			+ " AND [competency:http://skyrepo.eduworks.com/service/data/schema.eduworks.com.cass.0.1.competency/625c9e61-2503-401a-8df7-c9f14133ce95 AND confidence:>0.6]"
			+ " AND [competency:http://skyrepo.eduworks.com/service/data/schema.eduworks.com.cass.0.1.competency/0a2ea5e4-b5b4-461e-a19c-d17772da4d16 AND confidence:>0.6]";

	@Test
	public void basicTrueTest()
	{
		EcFramework f = newFramework("Woodworking");

		EcCompetency cx = newCompetency("Basic Woodworking");

		EcCompetency c = newCompetency("Lathing");
		EcCompetency c2 = newCompetency("Whittling");
		EcCompetency c3 = newCompetency("Hammering");
		EcCompetency c4 = newCompetency("Sawing");

		f.addCompetency(c.shortId());
		f.addCompetency(c2.shortId());
		f.addCompetency(c3.shortId());
		f.addCompetency(c4.shortId());
		f.addCompetency(cx.shortId());

		String input = "[competency:<C> AND confidence:>0.6] AND [competency:<C2> AND confidence:>0.6] AND [competency:<C3> AND confidence:>0.6] AND [competency:<C4> AND confidence:>0.6]";
		input = input.replace("<C>",c.shortId());
		input = input.replace("<C2>",c2.shortId());
		input = input.replace("<C3>",c3.shortId());
		input = input.replace("<C4>",c4.shortId());

		EcRollupRule rr = newRollupRule(c,input);

		c.save(null,failure);
		c2.save(null,failure);
		c3.save(null,failure);
		c4.save(null,failure);
		cx.save(null,failure);

		rr.save(null,failure);

		f.addRollupRule(rr.shortId());

		f.save(null, failure);

		EcAssertion a = newAssertion(c);
		EcAssertion a2 = newAssertion(c2);
		EcAssertion a3 = newAssertion(c3);

		a.save(null,failure);
		a2.save(null,failure);
		a3.save(null,failure);

		performTest(f,cx,new Callback1<InquiryPacket>()
		{
			@Override
			public void $invoke(InquiryPacket p1)
			{
				Global.console.log(p1.result.name());
				Global.console.log(p1);
				Assert.assertSame(InquiryPacket.ResultType.TRUE, p1.result);
			}
		});

		deleteById(f.shortId());
		deleteById(c.shortId());
		deleteById(c2.shortId());
		deleteById(c3.shortId());
		deleteById(c4.shortId());
		deleteById(cx.shortId());
		deleteById(a.shortId());
		deleteById(a2.shortId());
		deleteById(a3.shortId());
		deleteById(rr.shortId());
	}
	@Test
	public void basicTest()
	{
		String input = "[competency:http://skyrepo.eduworks.com/service/data/schema.eduworks.com.cass.0.1.competency/d885dcd8-f00b-4ccf-82d8-ee14d6c84ef0 AND confidence:>0.6]"
				+ " AND [competency:http://skyrepo.eduworks.com/service/data/schema.eduworks.com.cass.0.1.competency/31971023-5d61-42c0-bc64-ae8e8b7f0d09 AND confidence:>0.6 ]"
				+ " AND [competency:http://skyrepo.eduworks.com/service/data/schema.eduworks.com.cass.0.1.competency/625c9e61-2503-401a-8df7-c9f14133ce95 AND confidence:>0.6]"
				+ " AND [competency:http://skyrepo.eduworks.com/service/data/schema.eduworks.com.cass.0.1.competency/0a2ea5e4-b5b4-461e-a19c-d17772da4d16 AND confidence:>0.6]";
		// EcPk pk = EcPk.fromPem("asdf");
		// String input = "[competency:http://Addition AND confidence>0.6] AND "
		// +
		// "[competency:http://Subtraction AND confidence>0.6] AND " +
		// "[competency:http://Multiplication AND confidence>0.6] OR " +
		// "[competency:http://Division AND confidence>0.6]";
		// String input = "[competency:http://Addition AND confidence>0.6] AND "
		// +
		// "[competency:http://Subtraction AND confidence>0.6] AND " +
		// "[(competency:http://Algebra OR competency:http://Calculus) AND
		// confidence>0.0] AND " +
		// "[competency:http://Multiplication AND confidence>0.6] OR " +
		// "[competency:http://Division AND confidence>0.6]";
		final InquiryPacket ip = new InquiryPacket(null, null, null, null, null, null, null, null);
		RollupRuleProcessor rrp = new RollupRuleProcessor(ip, null);
		RollupRuleInterface rri = new RollupRuleInterface(input, rrp);
		rri.logFunction = new Callback1<Object>()
		{
			@Override
			public void $invoke(Object p1)
			{
				Global.console.log(p1);
			}
		};
		rri.success = new Callback1<Boolean>()
		{
			@Override
			public void $invoke(Boolean p1)
			{
				if (ip.subPackets == null || ip.subPackets.$length() <= 0)
					Global.console.log("NO SUB PACKET GENERATED!!!");
				else
				{
					Global.console.log("SUB PACKET WAS GENERATED!!!");
					InquiryPacket rip = ip.subPackets.$get(0);
					Global.console.log(" " + rip.type);
					InquiryPacket sp;
					for (int i = 0; i < rip.subPackets.$length(); i++)
					{
						sp = rip.subPackets.$get(i);
						if (sp.type.equals(IPType.ROLLUPRULE))
							Global.console.log("    " + sp.type + " - " + sp.rule);
						else
						{
							Global.console.log("   " + sp.type);
							for (int j = 0; j < sp.subPackets.$length(); j++)
							{
								Global.console.log("       " + sp.subPackets.$get(j).type + " - " + sp.subPackets.$get(j).rule);
							}
						}
					}
				}
			}
		};

		rri.go();
	}

}
