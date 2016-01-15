package org.cassproject.ebac.identity;

import com.eduworks.ec.crypto.EcAes;
import com.eduworks.ec.crypto.EcAesCtr;
import com.eduworks.ec.crypto.EcPpk;
import com.eduworks.schema.ebac.EbacCredential;

public class EcIdentity
{
	public EcPpk ppk;
	public String displayName;
	public String source;
	
	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof EcIdentity)
			return ppk.equals(((EcIdentity)obj).ppk);
		return super.equals(obj);
	}

	public EbacCredential toCredential(String secret)
	{
		EbacCredential c = new EbacCredential();
		c.iv = EcAes.newIv(64);
		c.ppk = EcAesCtr.encrypt(ppk.toPem(), secret, c.iv);
		return c;
	}
	public static EcIdentity fromCredential(EbacCredential credential, String secret,String source)
	{
		EcIdentity i = new EcIdentity();
		i.ppk = EcPpk.fromPem(EcAesCtr.decrypt(credential.ppk, secret, credential.iv));
		i.source = source;
		return i;
	}	
}
