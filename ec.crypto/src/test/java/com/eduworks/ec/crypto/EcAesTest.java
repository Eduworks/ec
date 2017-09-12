package com.eduworks.ec.crypto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.stjs.testing.annotation.ScriptsBefore;
import org.stjs.testing.driver.STJSTestDriverRunner;

import static org.junit.Assert.assertTrue;
import static org.stjs.javascript.Global.console;

@RunWith(STJSTestDriverRunner.class)
@ScriptsBefore({"/forge/forge.bundle.js", "ec.base.js"})
public class EcAesTest {
	@Test
	public void aesTest() {
		String randomString = EcAes.newIv(1024);
		console.log("Random string: " + randomString);
		String secret = EcAes.newIv(32);
		console.log("Random secret: " + secret);
		String iv = EcAes.newIv(32);
		console.log("Random iv:" + iv);
		String encrypted = EcAesCtr.encrypt(randomString, secret, iv);
		console.log("Encrypted String: " + encrypted);
		String decrypted = EcAesCtr.decrypt(encrypted, secret, iv);
		console.log("Decrypted String: " + decrypted);

		assertTrue(randomString.equals(decrypted));

	}
}
