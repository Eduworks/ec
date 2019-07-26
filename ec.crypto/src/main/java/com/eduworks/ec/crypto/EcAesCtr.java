package com.eduworks.ec.crypto;

import com.eduworks.ec.remote.EcLevrHttp;
import forge.cipher;
import forge.cipheroutput;
import forge.util;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSObjectAdapter;
import window.EcLevrCrypto;

/**
 * Encrypts data synchronously using AES-256-CTR. Requires secret and iv to be 32 bytes.
 * Output is encoded in base64 for easier handling.
 *
 * @author fritz.ray@eduworks.com
 * @module com.eduworks.ec
 * @class EcAesCtr
 */
public class EcAesCtr {
	/**
	 * Encrypts plaintext using AES-256-CTR.
	 * Plaintext is treated as as a sequence of bytes, does not perform UTF8 decoding.
	 * Returns base64 encoded ciphertext.
	 *
	 * @param {string} plaintext Text to encrypt.
	 * @param {string} secret Secret to use to encrypt.
	 * @param {string} iv Initialization Vector to use to encrypt.
	 * @return {string} Ciphertext encoded using base64.
	 * @method encrypt
	 * @static
	 */
	public static String encrypt(String plaintext, String secret, String iv) {
		//Key creation was 32 byte at some point instead of 16 byte. Whoops.
		if (Global.typeof(EcLevrHttp.httpStatus) != "undefined" && util.decode64(secret).length == 16 && util.decode64(iv).length == 16)
			return EcLevrCrypto.aesEncrypt(plaintext, iv, secret);

		cipher c = cipher.createCipher("AES-CTR", util.decode64(secret));
		c.start(new EcAesParameters(iv));
		c.update(util.createBuffer(util.encodeUtf8(plaintext)));
		c.finish();
		cipheroutput encrypted = c.output;
		return util.encode64(encrypted.bytes());
	}

	/**
	 * Decrypts ciphertext using AES-256-CTR.
	 * Ciphertext must be base64 encoded ciphertext.
	 * Returns plaintext as a string (Sequence of bytes, no encoding).
	 *
	 * @param {string} ciphertext Ciphertext to decrypt.
	 * @param {string} secret Secret to use to decrypt.
	 * @param {string} iv Initialization Vector to use to decrypt.
	 * @return {string} Plaintext with no encoding.
	 * @method decrypt
	 * @static
	 */
	public static String decrypt(String ciphertext, String secret, String iv) {
		if (EcCrypto.caching) {
			final Object cacheGet = JSObjectAdapter.$get(EcCrypto.decryptionCache, secret + iv + ciphertext);
			if (cacheGet != null)
				return (String) cacheGet;
		}
		//Key creation was 32 byte at some point instead of 16 byte. Whoops.
		if (Global.typeof(EcLevrHttp.httpStatus) != "undefined" && util.decode64(secret).length == 16 && util.decode64(iv).length == 16) {
			String result = EcLevrCrypto.aesDecrypt(ciphertext, iv, secret);
			if (EcCrypto.caching)
				JSObjectAdapter.$put(EcCrypto.decryptionCache, secret + iv + ciphertext, result);
			return result;
		}
		cipher c = cipher.createDecipher("AES-CTR", util.decode64(secret));
		c.start(new EcAesParameters(iv));
		c.update(forge.util.createBuffer(forge.util.decode64(ciphertext)));
		c.finish();
		cipheroutput decrypted = c.output;
		if (EcCrypto.caching)
			JSObjectAdapter.$put(EcCrypto.decryptionCache, secret + iv + ciphertext, util.decodeUtf8(decrypted.data));
		return util.decodeUtf8(decrypted.data);
	}
}
