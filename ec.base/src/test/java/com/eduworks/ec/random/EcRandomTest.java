package com.eduworks.ec.random;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.stjs.javascript.Global.console;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.stjs.testing.annotation.ScriptsBefore;
import org.stjs.testing.driver.STJSTestDriverRunner;

@RunWith(STJSTestDriverRunner.class)
@ScriptsBefore({ "/random.js" })
public class EcRandomTest
{
	@Test
	public void testLength()
	{
		assertTrue(EcRandom.generateUUID().length() == "xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx".length());
	}

}
