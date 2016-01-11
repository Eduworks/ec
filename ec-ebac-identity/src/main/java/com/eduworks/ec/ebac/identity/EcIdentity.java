package com.eduworks.ec.ebac.identity;

import com.eduworks.ec.crypto.EcAes;
import com.eduworks.ec.crypto.EcAesCtr;
import com.eduworks.ec.crypto.EcPpk;

public class EcIdentity
{
	public EcPpk ppk;
	public String displayName;
	public String source;
	public EbacCredential toCredential(String secret)
	{
		EbacCredential c = new EbacCredential();
		c.iv = EcAes.newIv(64);
		c.ppk = EcAesCtr.encrypt(ppk.toPem(), secret, c.iv);
		return c;
	}
}
