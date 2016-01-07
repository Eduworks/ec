package com.eduworks.ec.crypto;

import forge.cipher;
import forge.cipheroutput;
import forge.util;

public class EcAesCtr extends EcAes
{
	@Override
	public String encrypt(String text, String secret, String iv)
	{
		cipher c = cipher.createCipher("AES-CTR",secret);
		c.start(new EcAesParameters(iv));
		c.update(util.createBuffer(text));
		c.finish();
		cipheroutput encrypted = c.output;
		return util.encode64(encrypted.bytes());
	}

	@Override
	public String decrypt(String text, String secret, String iv)
	{
		cipher c = cipher.createDecipher("AES-CTR",secret);
		c.start(new EcAesParameters(iv));
		c.update(forge.util.createBuffer(forge.util.decode64(text)));
		c.finish();
		cipheroutput decrypted = c.output;
		return decrypted.data;
	}

}
