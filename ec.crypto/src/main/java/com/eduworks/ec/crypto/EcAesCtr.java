package com.eduworks.ec.crypto;

import forge.cipher;
import forge.cipheroutput;
import forge.util;

/**
 * Encrypts data synchronously using AES-256-CTR. Requires secret and iv to be 32 bytes.
 * Output is encoded in base64 for easier handling.
 * @author fritz.ray@eduworks.com
 * @module com.eduworks.ec
 * @class EcAesCtr
 */
public class EcAesCtr
{
	/**
	 * Encrypts plaintext using AES-256-CTR. 
	 * Plaintext is treated as as a sequence of bytes, does not perform UTF8 decoding.
	 * Returns base64 encoded ciphertext.
	 * @method encrypt
	 * @static
	 * @param {string} plaintext Text to encrypt.
	 * @param {string} secret Secret to use to encrypt.
	 * @param {string} iv Initialization Vector to use to encrypt.
	 * @return {string} Ciphertext encoded using base64.
	 */
	public static String encrypt(String plaintext, String secret, String iv)
	{
		cipher c = cipher.createCipher("AES-CTR", util.decode64(secret));
		c.start(new EcAesParameters(iv));
		c.update(util.createBuffer(plaintext));
		c.finish();
		cipheroutput encrypted = c.output;
		return util.encode64(encrypted.bytes());
	}

	/**
	 * Decrypts ciphertext using AES-256-CTR. 
	 * Ciphertext must be base64 encoded ciphertext.
	 * Returns plaintext as a string (Sequence of bytes, no encoding).
	 * @method decrypt
	 * @static
	 * @param {string} ciphertext Ciphertext to decrypt.
	 * @param {string} secret Secret to use to decrypt.
	 * @param {string} iv Initialization Vector to use to decrypt.
	 * @return {string} Plaintext with no encoding.
	 */
	public static String decrypt(String ciphertext, String secret, String iv)
	{
		cipher c = cipher.createDecipher("AES-CTR", util.decode64(secret));
		c.start(new EcAesParameters(iv));
		c.update(forge.util.createBuffer(forge.util.decode64(ciphertext)));
		c.finish();
		cipheroutput decrypted = c.output;
		return decrypted.data;
	}
}
