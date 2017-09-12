package com.eduworks.ec.crypto;

import forge.random;
import forge.util;

/***
 * AES encryption tasks common across all variants of AES.
 * @class EcAes
 * @module com.eduworks.ec
 * @author fritz.ray@eduworks.com
 */
public class EcAes {
	/***
	 * Generates a random secret of length @i
	 * @method newSecret
	 * @static
	 * @param {integer} i Length of secret
	 * @return {string} String representing the new secret, encoded using Base64.
	 */
	public static String newSecret(int i) {
		return util.encode64(random.getBytesSync(i));
	}

	/***
	 * Generates a random Initialization Vector of length @i
	 * @method newIv
	 * @static
	 * @param {integer} i Length of initialization Vector
	 * @return {string} String representing the new Initialization Vector, encoded using Base64.
	 */
	public static String newIv(int i) {
		return util.encode64(random.getBytesSync(i));
	}
}
