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

	protected String toPem()
	{
		return pki.publicKeyToPem(pk);
	}

	public Boolean verify(bytes bytes, payload decode64)
	{
		return null;
	}
}
