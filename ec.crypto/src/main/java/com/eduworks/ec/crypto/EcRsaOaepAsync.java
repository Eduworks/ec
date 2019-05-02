package com.eduworks.ec.crypto;

import com.eduworks.ec.blob.ArrayBuffer;
import com.eduworks.ec.blob.BlobHelper;
import com.eduworks.ec.browser.EcBrowserDetection;
import com.eduworks.ec.remote.EcRemote;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;
import window.*;

/**
 * Async version of EcRsaOaep that uses browser extensions (window.crypto) to accomplish cryptography much faster.
 * Falls back to EcRsaOaepAsyncWorker, if window.crypto is not available.
 * @class EcRsaOaepAsync
 */
public class EcRsaOaepAsync {

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
	public static void encrypt(final EcPk pk, final String text, final Callback1<String> success, final Callback1<String> failure) {
		if (EcRemote.async == false) {
			success.$invoke(EcRsaOaep.encrypt(pk, text));
			return;
		}

		if (EcBrowserDetection.isIeOrEdge() || Global.window == null || window.crypto == null || crypto.subtle == null) {
			EcRsaOaepAsyncWorker.encrypt(pk, text, success, failure);
			return;
		}
		Array<String> keyUsages = new Array<>();
		keyUsages.push("encrypt");
		final AlgorithmIdentifier algorithm = (AlgorithmIdentifier)new Object();
		algorithm.name = "RSA-OAEP";
		algorithm.hash = "SHA-1";

		if (pk.key == null)
			crypto.subtle.importKey("jwk", pk.toJwk(), algorithm, false, keyUsages).then(new Callback1<CryptoKey>() {
				@Override
				public void $invoke(CryptoKey key) {
					pk.key = key;
					crypto.subtle.encrypt(algorithm, key, BlobHelper.str2ab(text)).then(new Callback1<ArrayBuffer>() {
						@Override
						public void $invoke(ArrayBuffer p1) {
							success.$invoke(base64.encode(p1));
						}
					}, failure);
				}
			}, failure);
		else
			crypto.subtle.encrypt(algorithm, pk.key, BlobHelper.str2ab(text)).then(new Callback1<ArrayBuffer>() {
				@Override
				public void $invoke(ArrayBuffer p1) {
					success.$invoke(base64.encode(p1));
				}
			}, failure);
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
	public static void decrypt(final EcPpk ppk, final String text, final Callback1<String> success, final Callback1<String> failure) {

		if (EcCrypto.caching) {
			Object cacheGet = null;
			cacheGet = JSObjectAdapter.$get(EcCrypto.decryptionCache, ppk.toPem() + text);
			if (cacheGet != null) {
				success.$invoke((String) cacheGet);
				return;
			}
		}
		if (EcRemote.async == false) {
			success.$invoke(EcRsaOaep.decrypt(ppk, text));
			return;
		}
		if (EcBrowserDetection.isIeOrEdge() || Global.window == null || window.crypto == null || crypto.subtle == null) {
			EcRsaOaepAsyncWorker.decrypt(ppk, text, success, failure);
			return;
		}
		Array<String> keyUsages = new Array<>();
		keyUsages.push("decrypt");
		final AlgorithmIdentifier algorithm = (AlgorithmIdentifier)new Object();
		algorithm.name = "RSA-OAEP";
		algorithm.hash = "SHA-1";

		if (ppk.key == null)
			crypto.subtle.importKey("jwk", ppk.toJwk(), algorithm, false, keyUsages).then(new Callback1<CryptoKey>() {
				@Override
				public void $invoke(CryptoKey key) {
					ppk.key = key;
					crypto.subtle.decrypt(algorithm, key, base64.decode(text)).then(new Callback1<ArrayBuffer>() {
						@Override
						public void $invoke(ArrayBuffer p1) {
							success.$invoke(BlobHelper.ab2str(p1));
						}
					}, failure);
				}
			}, failure);
		else
			crypto.subtle.decrypt(algorithm, ppk.key, base64.decode(text)).then(new Callback1<ArrayBuffer>() {
				@Override
				public void $invoke(ArrayBuffer p1) {
					success.$invoke(BlobHelper.ab2str(p1));
				}
			}, failure);
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
	public static void sign(final EcPpk ppk, final String text, final Callback1<String> success, final Callback1<String> failure) {
		if (EcRemote.async == false) {
			success.$invoke(EcRsaOaep.sign(ppk, text));
			return;
		}
		if (EcBrowserDetection.isIeOrEdge() || Global.window == null || window.crypto == null || crypto.subtle == null) {
			EcRsaOaepAsyncWorker.sign(ppk, text, success, failure);
			return;
		}
		Array<String> keyUsages = new Array<>();
		keyUsages.push("sign");
		final AlgorithmIdentifier algorithm = (AlgorithmIdentifier)new Object();
		algorithm.name = "RSASSA-PKCS1-v1_5";
		algorithm.hash = "SHA-1";

		if (ppk.signKey == null)
			crypto.subtle.importKey("jwk", ppk.toJwk(), algorithm, false, keyUsages).then(new Callback1<CryptoKey>() {
				@Override
				public void $invoke(CryptoKey key) {
					ppk.signKey = key;
					crypto.subtle.sign(algorithm, key, BlobHelper.str2ab(text)).then(new Callback1<ArrayBuffer>() {
						@Override
						public void $invoke(ArrayBuffer p1) {
							success.$invoke(base64.encode(p1));
						}
					}, failure);
				}
			}, failure);
		else
			crypto.subtle.sign(algorithm, ppk.signKey, BlobHelper.str2ab(text)).then(new Callback1<ArrayBuffer>() {
				@Override
				public void $invoke(ArrayBuffer p1) {
					success.$invoke(base64.encode(p1));
				}
			}, failure);
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
	public static void signSha256(final EcPpk ppk, final String text, final Callback1<String> success, final Callback1<String> failure) {
		if (EcRemote.async == false) {
			success.$invoke(EcRsaOaep.signSha256(ppk, text));
			return;
		}
		if (EcBrowserDetection.isIeOrEdge() || Global.window == null || window.crypto == null || crypto.subtle == null) {
			EcRsaOaepAsyncWorker.sign(ppk, text, success, failure);
			return;
		}
		Array<String> keyUsages = new Array<>();
		keyUsages.push("sign");
		final AlgorithmIdentifier algorithm = (AlgorithmIdentifier)new Object();
		algorithm.name = "RSASSA-PKCS1-v1_5";
		algorithm.hash = "SHA-256";

		if (ppk.signKey == null)
			crypto.subtle.importKey("jwk", ppk.toJwk(), algorithm, false, keyUsages).then(new Callback1<CryptoKey>() {
				@Override
				public void $invoke(CryptoKey key) {
					ppk.signKey = key;
					crypto.subtle.sign(algorithm, key, BlobHelper.str2ab(text)).then(new Callback1<ArrayBuffer>() {
						@Override
						public void $invoke(ArrayBuffer p1) {
							success.$invoke(base64.encode(p1));
						}
					}, failure);
				}
			}, failure);
		else
			crypto.subtle.sign(algorithm, ppk.signKey, BlobHelper.str2ab(text)).then(new Callback1<ArrayBuffer>() {
				@Override
				public void $invoke(ArrayBuffer p1) {
					success.$invoke(base64.encode(p1));
				}
			}, failure);
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
	public static void verify(final EcPk pk, final String text, final String signature, final Callback1<Boolean> success, final Callback1<String> failure) {
		if (EcRemote.async == false) {
			success.$invoke(EcRsaOaep.verify(pk, text, signature));
			return;
		}
		if (EcBrowserDetection.isIeOrEdge() || Global.window == null || window.crypto == null || crypto.subtle == null) {
			EcRsaOaepAsyncWorker.verify(pk, text, signature, success, failure);
			return;
		}
		Array<String> keyUsages = new Array<>();
		keyUsages.push("verify");
		final AlgorithmIdentifier algorithm = (AlgorithmIdentifier)new Object();
		algorithm.name = "RSASSA-PKCS1-v1_5";
		algorithm.hash = "SHA-1";

		if (pk.signKey == null)
			crypto.subtle.importKey("jwk", pk.toJwk(), algorithm, false, keyUsages).then(new Callback1<CryptoKey>() {
				@Override
				public void $invoke(CryptoKey key) {
					pk.signKey = key;
					crypto.subtle.verify(algorithm, key, base64.decode(signature), BlobHelper.str2ab(text)).then(new Callback1<Boolean>() {
						@Override
						public void $invoke(Boolean p1) {
							success.$invoke(p1);
						}
					}, failure);
				}
			}, failure);
		else
			crypto.subtle.verify(algorithm, pk.signKey, base64.decode(signature), BlobHelper.str2ab(text)).then(new Callback1<Boolean>() {
				@Override
				public void $invoke(Boolean p1) {
					success.$invoke(p1);
				}
			}, failure);
	}
}
