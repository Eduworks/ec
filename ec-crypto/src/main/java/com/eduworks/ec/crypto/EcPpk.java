package com.eduworks.ec.crypto;
import forge.ppk;

public class EcPpk
{
	public static EcPpk fromPem(String pem)
	{
		EcPpk pk = new EcPpk();
		pk.ppk = forge.pki.privateKeyFromPem(pem);
		return pk;
	}

	protected ppk ppk;

	protected EcPpk()
	{
	}

	protected String toPem()
	{
		return forge.pki.privateKeyToPem(ppk);
	}
	
	protected EcPk toPk()
	{
		EcPk pk = new EcPk();
		pk.pk = forge.rsa.setPublicKey(ppk.n,ppk.e);
		return pk;
	}
}
