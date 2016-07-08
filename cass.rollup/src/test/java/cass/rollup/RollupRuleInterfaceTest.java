package cass.rollup;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.stjs.javascript.Global;
import org.stjs.javascript.functions.Callback1;
import org.stjs.testing.annotation.ScriptsBefore;
import org.stjs.testing.driver.STJSTestDriverRunner;

import com.eduworks.ec.crypto.EcPk;

@RunWith(STJSTestDriverRunner.class)
@ScriptsBefore({ "lib/require.js","rollupInit.js" })
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
		String input = "[competency:http://skyrepo.eduworks.com/service/data/schema.eduworks.com.cass.0.1.competency/d885dcd8-f00b-4ccf-82d8-ee14d6c84ef0 AND confidence>0.6] AND [competency:http://skyrepo.eduworks.com/service/data/schema.eduworks.com.cass.0.1.competency/31971023-5d61-42c0-bc64-ae8e8b7f0d09 AND confidence>0.6 ] AND [competency:http://skyrepo.eduworks.com/service/data/schema.eduworks.com.cass.0.1.competency/625c9e61-2503-401a-8df7-c9f14133ce95 AND confidence>0.6] AND [competency:http://skyrepo.eduworks.com/service/data/schema.eduworks.com.cass.0.1.competency/0a2ea5e4-b5b4-461e-a19c-d17772da4d16 AND confidence>0.6]";
		EcPk pk = EcPk.fromPem("asdf");
		RollupRuleProcessor p = new RollupRuleProcessor(pk);
		RollupRuleInterface rr = new RollupRuleInterface(input,p);
		rr.logFunction = new Callback1<Object>()
		{
			@Override
			public void $invoke(Object p1)
			{
				Global.console.log(p1);
			}
		};
		rr.go();
	}

}
