package com.eduworks.ec.crypto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;
import org.stjs.testing.annotation.ScriptsBefore;
import org.stjs.testing.driver.STJSTestDriverRunner;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.stjs.javascript.Global.console;

@RunWith(STJSTestDriverRunner.class)
@ScriptsBefore({"pem-jwk.js", "require.js", "/forge/forge.bundle.js", "ec.base.js", "base64toArrayBuffer.js"})
public class EcAesAsyncTest {
	@Test
	public void aesTest() {
		console.log("-----aesTest-----");
		final String randomString = "foo is bar";
		console.log("Random string: " + randomString);
		final String secret = EcAes.newIv(16);
		console.log("Random secret: " + secret);
		final String iv = EcAes.newIv(16);
		console.log("Random iv:" + iv);
		EcAesCtrAsync.encrypt(randomString, secret, iv, new Callback1<String>() {
			@Override
			public void $invoke(String encrypted) {
				console.log("Encrypted String: " + encrypted);
				console.log("Encrypted String (Proper): " + EcAesCtr.encrypt(randomString, secret, iv));
				EcAesCtrAsync.decrypt(encrypted, secret, iv, new Callback1<String>() {
					@Override
					public void $invoke(String decrypted) {
						console.log("Decrypted String: " + decrypted);

						assertEquals("EcAesAsyncTest:aesTest",randomString,decrypted);
					}
				}, new Callback2<String, Integer>() {
					@Override
					public void $invoke(String p1, Integer i) {
						assertTrue(false);
					}
				});
			}
		}, new Callback2<String, Integer>() {
			@Override
			public void $invoke(String p1, Integer i) {
				assertTrue("EcAesAsyncTest:aesTest"+p1,false);
			}
		});

	}

	@Test
	public void aesCrossTest1() {
		console.log("-----aesCrossTest1-----");
		final String randomString = EcAes.newIv(1024);
		console.log("Random string: " + randomString);
		final String secret = EcAes.newIv(16);
		console.log("Random secret: " + secret);
		final String iv = EcAes.newIv(16);
		console.log("Random iv:" + iv);
		EcAesCtrAsync.encrypt(randomString, secret, iv, new Callback1<String>() {
			@Override
			public void $invoke(String encrypted) {
				console.log("Encrypted String: " + encrypted);
				String decrypted = EcAesCtr.decrypt(encrypted, secret, iv);
				console.log("Decrypted String: " + decrypted);

				assertEquals("EcAesAsyncTest:aesCrossTest1",randomString,decrypted);
			}
		}, new Callback2<String, Integer>() {
			@Override
			public void $invoke(String p1, Integer i) {
				assertTrue("EcAesAsyncTest:aesCrossTest1",false);
			}
		});

	}

	@Test
	public void aesCrossTest1Utf8() {
		console.log("-----aesCrossTest1Utf8-----");
		final String randomString = "ᚠᛇᚻ᛫ᛒᛦᚦ᛫ᚠᚱᚩᚠᚢᚱ᛫ᚠᛁᚱᚪ᛫ᚷᛖᚻᚹᛦᛚᚳᚢᛗ";
		console.log("Random string: " + randomString);
		final String secret = EcAes.newIv(16);
		console.log("Random secret: " + secret);
		final String iv = EcAes.newIv(16);
		console.log("Random iv:" + iv);
		EcAesCtrAsync.encrypt(randomString, secret, iv, new Callback1<String>() {
			@Override
			public void $invoke(String encrypted) {
				console.log("Encrypted String: " + encrypted);
				String decrypted = EcAesCtr.decrypt(encrypted, secret, iv);
				console.log("Decrypted String: " + decrypted);

				assertEquals("EcAesAsyncTest:aesCrossTest1Utf8",randomString,decrypted);
			}
		}, new Callback2<String, Integer>() {
			@Override
			public void $invoke(String p1, Integer i) {
				assertTrue("EcAesAsyncTest:aesCrossTest1Utf8",false);
			}
		});

	}

	@Test
	public void aesCrossTest2Utf8() {
		console.log("-----aesCrossTest2Utf8-----");
		final String randomString = "ᚠᛇᚻ᛫ᛒᛦᚦ᛫ᚠᚱᚩᚠᚢᚱ᛫ᚠᛁᚱᚪ᛫ᚷᛖᚻᚹᛦᛚᚳᚢᛗ";
		console.log("Random string: " + randomString);
		final String secret = EcAes.newIv(16);
		console.log("Random secret: " + secret);
		final String iv = EcAes.newIv(16);
		console.log("Random iv:" + iv);
		String encrypted = EcAesCtr.encrypt(randomString, secret, iv);
		console.log("Encrypted String: " + encrypted);
		EcAesCtrAsync.decrypt(encrypted, secret, iv, new Callback1<String>() {
			@Override
			public void $invoke(String decrypted) {
				console.log("Decrypted String: " + decrypted);

				assertEquals("EcAesAsyncTest:aesCrossTest2Utf8",randomString,decrypted);
			}
		}, new Callback2<String, Integer>() {
			@Override
			public void $invoke(String p1, Integer i) {
				assertTrue("EcAesAsyncTest:aesCrossTest2Utf8",false);
			}
		});

	}
	@Test
	public void aesTestWorker() {
		console.log("-----aesTestWorker-----");
		final String randomString = "foo is bar";
		console.log("Random string: " + randomString);
		final String secret = EcAes.newIv(16);
		console.log("Random secret: " + secret);
		final String iv = EcAes.newIv(16);
		console.log("Random iv:" + iv);
		EcAesCtrAsyncWorker.encrypt(randomString, secret, iv, new Callback1<String>() {
			@Override
			public void $invoke(String encrypted) {
				console.log("Encrypted String: " + encrypted);
				console.log("Encrypted String (Proper): " + EcAesCtr.encrypt(randomString, secret, iv));
				EcAesCtrAsyncWorker.decrypt(encrypted, secret, iv, new Callback1<String>() {
					@Override
					public void $invoke(String decrypted) {
						console.log("Decrypted String: " + decrypted);

						assertEquals("EcAesAsyncTest:aesTestWorker",randomString,decrypted);
					}
				}, new Callback2<String, Integer>() {
					@Override
					public void $invoke(String p1, Integer i) {
						assertTrue(false);
					}
				});
			}
		}, new Callback2<String, Integer>() {
			@Override
			public void $invoke(String p1, Integer i) {
				assertTrue("EcAesAsyncTest:aesTestWorker",false);
			}
		});

	}

	@Test
	public void aesCrossTest1Worker() {
		console.log("-----aesCrossTest1Worker-----");
		final String randomString = EcAes.newIv(1024);
		console.log("Random string: " + randomString);
		final String secret = EcAes.newIv(16);
		console.log("Random secret: " + secret);
		final String iv = EcAes.newIv(16);
		console.log("Random iv:" + iv);
		EcAesCtrAsyncWorker.encrypt(randomString, secret, iv, new Callback1<String>() {
			@Override
			public void $invoke(String encrypted) {
				console.log("Encrypted String: " + encrypted);
				String decrypted = EcAesCtr.decrypt(encrypted, secret, iv);
				console.log("Decrypted String: " + decrypted);

				assertEquals("EcAesAsyncTest:aesCrossTest1Worker",randomString,decrypted);
			}
		}, new Callback2<String, Integer>() {
			@Override
			public void $invoke(String p1, Integer i) {
				assertTrue("EcAesAsyncTest:aesCrossTest1Worker",false);
			}
		});

	}

	@Test
	public void aesCrossTest1Utf8Worker() {
		console.log("-----aesCrossTest1Utf8Worker-----");
		final String randomString = "ᚠᛇᚻ᛫ᛒᛦᚦ᛫ᚠᚱᚩᚠᚢᚱ᛫ᚠᛁᚱᚪ᛫ᚷᛖᚻᚹᛦᛚᚳᚢᛗ";
		console.log("Random string: " + randomString);
		final String secret = EcAes.newIv(16);
		console.log("Random secret: " + secret);
		final String iv = EcAes.newIv(16);
		console.log("Random iv:" + iv);
		EcAesCtrAsyncWorker.encrypt(randomString, secret, iv, new Callback1<String>() {
			@Override
			public void $invoke(String encrypted) {
				console.log("Encrypted String: " + encrypted);
				String decrypted = EcAesCtr.decrypt(encrypted, secret, iv);
				console.log("Decrypted String: " + decrypted);

				assertEquals("EcAesAsyncTest:aesCrossTest1Utf8Worker",randomString,decrypted);
			}
		}, new Callback2<String, Integer>() {
			@Override
			public void $invoke(String p1, Integer i) {
				assertTrue("EcAesAsyncTest:aesCrossTest1Utf8Worker",false);
			}
		});

	}

	@Test
	public void aesCrossTest2Utf8Worker() {
		console.log("-----aesCrossTest2Utf8Worker-----");
		final String randomString = "ᚠᛇᚻ᛫ᛒᛦᚦ᛫ᚠᚱᚩᚠᚢᚱ᛫ᚠᛁᚱᚪ᛫ᚷᛖᚻᚹᛦᛚᚳᚢᛗ";
		console.log("Random string: " + randomString);
		final String secret = EcAes.newIv(16);
		console.log("Random secret: " + secret);
		final String iv = EcAes.newIv(16);
		console.log("Random iv:" + iv);
		String encrypted = EcAesCtr.encrypt(randomString, secret, iv);
		console.log("Encrypted String: " + encrypted);
		EcAesCtrAsyncWorker.decrypt(encrypted, secret, iv, new Callback1<String>() {
			@Override
			public void $invoke(String decrypted) {
				console.log("Decrypted String: " + decrypted);

				assertEquals("EcAesAsyncTest:aesCrossTest2Utf8Worker",randomString,decrypted);
			}
		}, new Callback2<String, Integer>() {
			@Override
			public void $invoke(String p1, Integer i) {
				assertTrue("EcAesAsyncTest:aesCrossTest2Utf8Worker",false);
			}
		});

	}
}
