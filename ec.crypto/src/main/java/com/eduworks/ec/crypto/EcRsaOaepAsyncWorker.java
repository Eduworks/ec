package com.eduworks.ec.crypto;

import com.eduworks.ec.remote.EcRemote;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSGlobal;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;
import org.stjs.javascript.worker.ErrorEvent;
import org.stjs.javascript.worker.MessageEvent;
import org.stjs.javascript.worker.Worker;
import org.stjs.javascript.worker.WorkerGlobalScope;
import window.EcLevrCrypto;

/**
 * Asynchronous implementation of {{#crossLink
 * "EcRsaOaep"}}EcRsaOaep{{/crossLink}}. Uses web workers and assumes 8 workers.
 *
 * @author fritz.ray@eduworks.com
 * @class EcRsaOaepAsyncWorker
 * @module com.eduworks.ec
 */
public class EcRsaOaepAsyncWorker {

	static int rotator;
	static Array<Worker<Object>> w;
	static Array<Array<Callback1>> q1;
	static Array<Array<Callback2>> q2;

	public static void initWorker() {
		if (Global.window == null && (JSGlobal.typeof(WorkerGlobalScope.self).equals("undefined")) || EcLevrCrypto.Worker == JSGlobal.undefined || EcLevrCrypto.Worker == null) {
			return;
		}
		if (!EcRemote.async) {
			return;
		}
		if (w != null) {
			return;
		}
		rotator = 0;
		q1 = new Array<>();
		q2 = new Array<>();
		w = new Array<>();
		for (int index = 0; index < 8; index++) {
			createWorker(index);
		}
	}

	private static void createWorker(final int index) {
		q1.push(new Array<Callback1>());
		q2.push(new Array<Callback2>());
		Worker<Object> wkr;
		if (JSObjectAdapter.$get(Global.window, "scriptPath") != null)
		w.push(wkr = new Worker<Object>(JSObjectAdapter.$get(Global.window, "scriptPath") + "forgeAsync.js"));
		else
			w.push(wkr = new Worker<Object>("forgeAsync.js"));
		wkr.onmessage = new Callback1<MessageEvent<Object>>() {
			@Override
			public void $invoke(MessageEvent<Object> p1) {
				Object o = p1.data;
				Callback1 success = q1.$get(index).shift();
				Callback2 failure = q2.$get(index).shift();
				if (JSObjectAdapter.$get(o, "error") != null) {
					if (failure != null)
						failure.$invoke(JSObjectAdapter.$get(o, "error"), 400);
				} else if (success != null) {
					success.$invoke(JSObjectAdapter.$get(o, "result"));
				}
			}
		};
		wkr.onerror = new Callback1<ErrorEvent>() {
			@Override
			public void $invoke(ErrorEvent p1) {
				Callback1 success = q1.$get(index).shift();
				Callback2 failure = q2.$get(index).shift();
				if (failure != null) {
					failure.$invoke(p1.toString(), 400);
				}
			}
		};
	}

	/**
	 * Asynchronous form of {{#crossLink
	 * "EcRsaOaep/encrypt:method"}}EcRsaOaep.encrypt{{/crossLink}}
	 *
	 * @param {EcPk}             pk Public Key to use to encrypt.
	 * @param {string}           plaintext Plaintext to encrypt.
	 * @param {function(string)} success Success method, result is Base64
	 *                           encoded Ciphertext.
	 * @param {function(string)} failure Failure method, parameter is error
	 *                           message.
	 * @method encrypt
	 * @static
	 */
	public static void encrypt(EcPk pk, String plaintext, Callback1<String> success, Callback2<String, Integer> failure) {
		initWorker();
		if (!EcRemote.async || w == null) {
			success.$invoke(EcRsaOaep.encrypt(pk, plaintext));
		} else {
			int worker = rotator++;
			rotator = rotator % 8;
			Object o = new Object();
			JSObjectAdapter.$put(o, "pk", pk.toPem());
			JSObjectAdapter.$put(o, "text", forge.util.encodeUtf8(plaintext));
			JSObjectAdapter.$put(o, "cmd", "encryptRsaOaep");
			q1.$get(worker).push(success);
			q2.$get(worker).push(failure);
			w.$get(worker).postMessage(o);
		}
	}

	/**
	 * Asynchronous form of {{#crossLink
	 * "EcRsaOaep/decrypt:method"}}EcRsaOaep.decrypt{{/crossLink}}
	 *
	 * @param {EcPpk}            ppk Public private keypair to use to decrypt.
	 * @param {string}           ciphertext Ciphertext to decrypt.
	 * @param {function(string)} success Success method, result is unencoded
	 *                           plaintext.
	 * @param {function(string)} failure Failure method, parameter is error
	 *                           message.
	 * @method decrypt
	 * @static
	 */
	public static void decrypt(final EcPpk ppk, final String ciphertext, final Callback1<String> success, final Callback2<String, Integer> failure) {
		if (EcCrypto.caching) {
			Object cacheGet = null;
			cacheGet = JSObjectAdapter.$get(EcCrypto.decryptionCache, ppk.toPem() + ciphertext);
			if (cacheGet != null) {
				success.$invoke((String) cacheGet);
				return;
			}
		}
		initWorker();
		if (!EcRemote.async || w == null) {
			success.$invoke(EcRsaOaep.decrypt(ppk, ciphertext));
		} else {
			int worker = rotator++;
			rotator = rotator % 8;
			Object o = new Object();
			JSObjectAdapter.$put(o, "ppk", ppk.toPem());
			JSObjectAdapter.$put(o, "text", ciphertext);
			JSObjectAdapter.$put(o, "cmd", "decryptRsaOaep");
			if (EcCrypto.caching) {
				q1.$get(worker).push(new Callback1<String>() {
					@Override
					public void $invoke(String p1) {
						JSObjectAdapter.$put(EcCrypto.decryptionCache, ppk.toPem() + ciphertext, forge.util.decodeUtf8(p1));
						success.$invoke(forge.util.decodeUtf8(p1));
					}
				});
			} else {
				q1.$get(worker).push(new Callback1<String>() {
					@Override
					public void $invoke(String p1) {
						success.$invoke(forge.util.decodeUtf8(p1));
					}
				});
			}
			q2.$get(worker).push(failure);
			w.$get(worker).postMessage(o);
		}
	}

	/**
	 * Asynchronous form of {{#crossLink
	 * "EcRsaOaep/sign:method"}}EcRsaOaep.sign{{/crossLink}}
	 *
	 * @param {EcPpk}            ppk Public private keypair to use to sign message.
	 * @param {string}           text Text to sign.
	 * @param {function(string)} success Success method, result is Base64
	 *                           encoded signature.
	 * @param {function(string)} failure Failure method, parameter is error
	 *                           message.
	 * @method sign
	 * @static
	 */
	public static void sign(EcPpk ppk, String text, Callback1<String> success, Callback2<String, Integer> failure) {
		initWorker();
		if (!EcRemote.async || w == null) {
			success.$invoke(EcRsaOaep.sign(ppk, text));
		} else {
			int worker = rotator++;
			rotator = rotator % 8;
			Object o = new Object();
			JSObjectAdapter.$put(o, "ppk", ppk.toPem());
			JSObjectAdapter.$put(o, "text", forge.util.encodeUtf8(text));
			JSObjectAdapter.$put(o, "cmd", "signRsaOaep");
			q1.$get(worker).push(success);
			q2.$get(worker).push(failure);
			w.$get(worker).postMessage(o);
		}
	}

	/**
	 * Asynchronous form of {{#crossLink
	 * "EcRsaOaep/signSha256:method"}}EcRsaOaep.signSha256{{/crossLink}}
	 *
	 * @param {EcPpk}            ppk Public private keypair to use to sign message.
	 * @param {string}           text Text to sign.
	 * @param {function(string)} success Success method, result is Base64
	 *                           encoded signature.
	 * @param {function(string)} failure Failure method, parameter is error
	 *                           message.
	 * @method signSha256
	 * @static
	 */
	public static void signSha256(EcPpk ppk, String text, Callback1<String> success, Callback2<String, Integer> failure) {
		initWorker();
		if (!EcRemote.async || w == null) {
			success.$invoke(EcRsaOaep.signSha256(ppk, text));
		} else {
			int worker = rotator++;
			rotator = rotator % 8;
			Object o = new Object();
			JSObjectAdapter.$put(o, "ppk", ppk.toPem());
			JSObjectAdapter.$put(o, "text", forge.util.encodeUtf8(text));
			JSObjectAdapter.$put(o, "cmd", "signSha256RsaOaep");
			q1.$get(worker).push(success);
			q2.$get(worker).push(failure);
			w.$get(worker).postMessage(o);
		}
	}

	/**
	 * Asynchronous form of {{#crossLink
	 * "EcRsaOaep/verify:method"}}EcRsaOaep.verify{{/crossLink}}
	 *
	 * @param {EcPk}              pk Public key to use to verify message.
	 * @param {string}            text Text to use in verification.
	 * @param {string}            signature Signature to use in verification.
	 * @param {function(boolean)} success Success method, result is whether
	 *                            signature is valid.
	 * @param {function(string)}  failure Failure method, parameter is error
	 *                            message.
	 * @method verify
	 * @static
	 */
	public static void verify(EcPk pk, String text, String signature, Callback1<Boolean> success, Callback2<String, Integer> failure) {
		initWorker();
		if (!EcRemote.async || w == null) {
			success.$invoke(EcRsaOaep.verify(pk, text, signature));
		} else {
			int worker = rotator++;
			rotator = rotator % 8;
			Object o = new Object();
			JSObjectAdapter.$put(o, "pk", pk.toPem());
			JSObjectAdapter.$put(o, "text", forge.util.encodeUtf8(text));
			JSObjectAdapter.$put(o, "signature", signature);
			JSObjectAdapter.$put(o, "cmd", "verifyRsaOaep");
			q1.$get(worker).push(success);
			q2.$get(worker).push(failure);
			w.$get(worker).postMessage(o);
		}
	}
}
