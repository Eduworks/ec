package com.eduworks.ec.random.test;


import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.stjs.testing.annotation.HTMLFixture;
import org.stjs.testing.annotation.ScriptsBefore;
import org.stjs.testing.driver.STJSTestDriverRunner;

import com.eduworks.ec.random.EcRandom;

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
