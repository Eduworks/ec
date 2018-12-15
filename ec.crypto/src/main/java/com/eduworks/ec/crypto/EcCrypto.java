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
 */
public class EcCrypto {
	public static boolean caching = false;
	public static Object decryptionCache = new Object();

	public static String md5(String s){
		md5 m = md5.create();
		m.update(s);
		return m.digest().toHex();
	}
	public static String sha256(String s){
		sha256 m = sha256.create();
		m.update(s,"utf8");
		return m.digest().toHex();
	}
}
