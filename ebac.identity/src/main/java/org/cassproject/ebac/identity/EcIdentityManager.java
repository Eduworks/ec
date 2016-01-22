package org.cassproject.ebac.identity;

import org.stjs.javascript.Array;
import org.stjs.javascript.Date;
import org.stjs.javascript.JSGlobal;
import org.stjs.javascript.functions.Callback1;

import com.eduworks.ec.crypto.EcPk;
import com.eduworks.ec.crypto.EcPpk;
import com.eduworks.ec.crypto.EcRsaOaep;
import com.eduworks.schema.ebac.EbacSignature;

public class EcIdentityManager
{
	public static Array<EcIdentity> ids = new Array<EcIdentity>();
	public static Array<EcContact> contacts = new Array<EcContact>();
	public static Callback1<EcIdentity> onKeyAdded = null;

	public static void keyAdded(EcIdentity ppk)
	{
		if (onKeyAdded != null)
			onKeyAdded.$invoke(ppk);
	}

	public static void add(EcIdentity identity)
	{
		for (int i = 0; i < ids.$length(); i++)
			if (ids.$get(i).equals(identity))
				return;
		ids.push(identity);
		keyAdded(identity);
	}

	public static String signatureSheetFor(Array<String> owners, long duration, String server)
	{
		Array<Object> signatures = new Array<Object>();
		EcRsaOaep crypto = new EcRsaOaep();
		for (int j = 0; j < ids.$length(); j++)
		{
			EcPpk ppk = ids.$get(j).ppk;
			String ourPem = ppk.toPk().toPem();
			if (owners != null)
				for (int i = 0; i < owners.$length(); i++)
				{
					String ownerPem = owners.$get(i);
					if (ourPem.equals(ownerPem))
					{
						signatures.push(createSignature(duration, server, crypto, ppk).atIfy());
					}
				}
		}
		return JSGlobal.JSON.stringify(signatures);
	}

	public static String signatureSheet(long duration, String server)
	{
		Array<Object> signatures = new Array<Object>();
		EcRsaOaep crypto = new EcRsaOaep();
		for (int j = 0; j < ids.$length(); j++)
		{
			EcPpk ppk = ids.$get(j).ppk;
			signatures.push(createSignature(duration, server, crypto, ppk).atIfy());
		}
		return JSGlobal.JSON.stringify(signatures);
	}

	private static EbacSignature createSignature(long duration, String server, EcRsaOaep crypto, EcPpk ppk)
	{
		EbacSignature s = new EbacSignature();
		s.owner = ppk.toPk().toPem();
		s.expiry = new Date().getTime() + duration;
		s.server = server;
		s.signature = EcRsaOaep.sign(ppk, s.toJson());
		return s;
	}

	public static EcPpk getPpk(EcPk fromPem)
	{
		String pem = fromPem.toPem();
		for (int i = 0; i < ids.$length(); i++)
		{
			if (pem.equals(ids.$get(i).ppk.toPk().toPem()))
				return ids.$get(i).ppk;
		}
		return null;
	}
}
