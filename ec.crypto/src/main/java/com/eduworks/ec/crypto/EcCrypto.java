/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduworks.ec.crypto;

import forge.md5;
import forge.sha256;

/**
 * @author Fritz
 * @class EcCrypto
 */
public class EcCrypto {
	/***
	 * Turn on (defualt off) caching of decrypted data.
	 * @property caching
	 * @type boolean
	 */
	public static boolean caching = false;
	public static Object decryptionCache = new Object();

	/***
	 * Calculate MD5 hash of a string.
	 * @param {String} s String to MD5
	 * @return {String} MD5 hash
	 * @static
	 * @method md5
	 */
	public static String md5(String s){
		md5 m = md5.create();
		m.update(s);
		return m.digest().toHex();
	}

	/***
	 * Calculate SHA-256 hash of a string.
	 * @param {String} s String to SHA-256
	 * @return {String} SHA-256 hash
	 * @static
	 * @method sha256
	 */
	public static String sha256(String s){
		sha256 m = sha256.create();
		m.update(s,"utf8");
		return m.digest().toHex();
	}
}
