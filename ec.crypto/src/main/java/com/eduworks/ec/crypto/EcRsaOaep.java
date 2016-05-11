package com.eduworks.ec.crypto;

import forge.sha1;
import forge.sha256;
import forge.util;

public class EcRsaOaep
{
	public static String encrypt(EcPk pk, String text)
	{
		return forge.util.encode64(pk.pk.encrypt(text, "RSA-OAEP"));
	}

	public static String decrypt(EcPpk ppk, String text)
	{
		return ppk.ppk.decrypt(forge.util.decode64(text), "RSA-OAEP");
	}

	public static String sign(EcPpk ppk, String text)
	{
		sha1 s = sha1.create();
		s.update(text, "utf8");
		return util.encode64(ppk.ppk.sign(s));
	}

	public static String signSha256(EcPpk ppk, String text)
	{
		sha256 s = sha256.create();
		s.update(text, "utf8");
		return util.encode64(ppk.ppk.sign(s));
	}

	public static Boolean verify(EcPk pk, String text, String signature)
	{
		sha1 s = sha1.create();
		s.update(text, "utf8");
		try
		{
			return pk.verify(s.digest().bytes(), util.decode64(signature));
		}
		catch (Exception ex)
		{
			return false;
		}
	}
}
