package com.eduworks.ec.crypto;
import static org.stjs.javascript.Global.*;
import forge.random;
import forge.util;

public class EcAes
{
	//We recommend AES-CTR.
	public static String encrypt(String text, String secret, String iv){alert("Incorrect AES Algorithm. Please pick a specialized algorithm.");return null;}
	public static String decrypt(String text, String secret, String iv){alert("Incorrect AES Algorithm. Please pick a specialized algorithm.");return null;}
	public static String newIv(int i)
	{
		return util.encode64(random.getBytesSync(i));
	}
}
