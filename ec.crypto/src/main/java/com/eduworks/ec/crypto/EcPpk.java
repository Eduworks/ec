package com.eduworks.ec.crypto;

import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;

import forge.keypair;
import forge.ppk;
import forge.rsa;

public class EcPpk
{
	public static EcPpk fromPem(String pem)
	{
		EcPpk pk = new EcPpk();
		pk.ppk = forge.pki.privateKeyFromPem(pem);
		return pk;
	}

	public static void generateKeyAsync(final Callback1<EcPpk> callback)
	{
		Object o = new Object();
		JSObjectAdapter.$properties(o).$put("workers", -1);
		rsa.generateKeyPair(o, new Callback2<String, keypair>()
		{
			public void $invoke(String err, keypair keypair)
			{
				EcPpk ppk = new EcPpk();
				ppk.ppk = keypair.privateKey;
				callback.$invoke(ppk);
			}
		});
	}
	
	public static EcPpk generateKey()
	{
		Object o = new Object();
		keypair keypair = rsa.generateKeyPair(o,null);
		EcPpk ppk = new EcPpk();
		ppk.ppk = keypair.privateKey;
		return ppk;
	}

	protected ppk ppk;
	
	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof EcPpk)
			return toPem().equals(((EcPpk) obj).toPem());
		return super.equals(obj);
	}

	protected EcPpk()
	{
	}

	public String toPem()
	{
		return forge.pki.privateKeyToPem(ppk);
	}

	public EcPk toPk()
	{
		EcPk pk = new EcPk();
		pk.pk = forge.rsa.setPublicKey(ppk.n, ppk.e);
		return pk;
	}
}
