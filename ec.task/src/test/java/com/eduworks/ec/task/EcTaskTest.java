package com.eduworks.ec.task;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.stjs.javascript.Global;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Function1;
import org.stjs.testing.annotation.ScriptsBefore;
import org.stjs.testing.driver.STJSTestDriverRunner;

@RunWith(STJSTestDriverRunner.class)
@ScriptsBefore({"ec.task.js"})
public class EcTaskTest {
	@Test
	public void createTest() throws InterruptedException {
		final EcAsyncTask task = new EcAsyncTask(new Function1<String, String>() {

			@Override
			public String $invoke(String p1) {
				return "Hello " + p1;
			}

		}, null, null, null, null);

		org.stjs.javascript.Global.setTimeout(new Callback0() {

			@Override
			public void $invoke() {
				String val = "World";

				Object ret = task.doTask(val);

				Global.console.log(ret);

				Assert.assertTrue(ret == "Hello " + val);
			}
		}, 200);

	}
}
