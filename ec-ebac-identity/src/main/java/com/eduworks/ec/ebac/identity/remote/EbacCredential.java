package com.eduworks.ec.ebac.identity.remote;

import com.eduworks.ec.crypto.EcAesCtr;
import com.eduworks.ec.crypto.EcPpk;
import com.eduworks.ec.ebac.identity.EcIdentity;
import com.eduworks.ec.ld.EcLinkedData;

public class EbacCredential extends EcLinkedData
{
	public EbacCredential()
	{
		super(Ebac.schema, "http://schema.eduworks.com/ebac/0.1/credential");
	}

	public String iv;
	public String ppk;
	public EcIdentity toIdentity(String secret,String source)
	{
		EcIdentity i = new EcIdentity();
		i.ppk = EcPpk.fromPem(EcAesCtr.decrypt(ppk, secret, iv));
		i.source = source;
		return i;
	}	
}
