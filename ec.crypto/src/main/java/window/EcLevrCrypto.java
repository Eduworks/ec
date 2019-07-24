/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window;

import org.stjs.javascript.annotation.GlobalScope;
import org.stjs.javascript.annotation.STJSBridge;

@GlobalScope
@STJSBridge()
public class EcLevrCrypto {

	public static Object Worker;

	public static String aesEncrypt(String obj, String iv, String secret) {
		return null;
	}

	public static String aesDecrypt(String obj, String iv, String secret) {
		return null;
	}

	public static String rsaEncrypt(String obj, String ppk) {
		return null;
	}

	public static String rsaDecrypt(String obj, String ppk) {
		return null;
	}

	public static String rsaSign(String obj, String ppk) {
		return null;
	}

	public static Boolean rsaVerify(String obj, String ppk, String against) {
		return null;
	}
}
