package cass.rollup;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.stjs.javascript.Global;
import org.stjs.javascript.functions.Callback1;
import org.stjs.testing.annotation.ScriptsBefore;
import org.stjs.testing.driver.STJSTestDriverRunner;

import cass.rollup.InquiryPacket.IPType;
import cass.rollup.rule.RollupRuleInterface;
import cass.rollup.rule.RollupRuleProcessor;

@RunWith(STJSTestDriverRunner.class)
@ScriptsBefore({ "lib/require.js", "rollupInit.js" })
public class RollupRuleInterfaceTest
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
