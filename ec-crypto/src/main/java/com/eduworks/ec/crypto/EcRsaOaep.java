package com.eduworks.ec.crypto;

import forge.sha1;
import forge.util;

public class EcRsaOaep extends EcRsa
{
	@Override
	public String encrypt(EcPk pk, String text)
	{
		return forge.util.encode64(pk.pk.encrypt(text,"RSA-OAEP"));
	}

	@Override
	public String decrypt(EcPpk ppk, String text)
	{
		return ppk.ppk.decode(forge.util.decode64(text),"RSA-OAEP");
	}

	@Override
	public String sign(EcPpk ppk, String text)
	{
		sha1 s = sha1.create();
		s.update(text, "utf8");
		return util.encode64(ppk.ppk.sign(s));
	}

	@Override
	public Boolean verify(EcPk pk, String text, String signature)
	{
		sha1 s = sha1.create();
		s.update(text, "utf8");
		return pk.verify(s.digest().bytes(),util.decode64(signature));
	}
}
