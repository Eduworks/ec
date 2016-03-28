package com.eduworks.ec.crypto;

import forge.bytes;
import forge.payload;
import forge.pk;
import forge.pki;

public class EcPk
{
	public static EcPk fromPem(String pem)
	{
		EcPk pk = new EcPk();
		pk.pk = pki.publicKeyFromPem(pem);
		return pk;
	}

	public pk pk;
	
	protected EcPk()
	{
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof EcPk)
			return toPem().equals(((EcPk) obj).toPem());
		return super.equals(obj);
	}
	
	public String toPem()
	{
		return pki.publicKeyToPem(pk).replaceAll("\r?\n", "");
	}

	public Boolean verify(bytes bytes, payload decode64)
	{ 
	    return pk.verify(bytes,decode64);
	}
}
