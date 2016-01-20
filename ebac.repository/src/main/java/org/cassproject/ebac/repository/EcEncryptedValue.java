package org.cassproject.ebac.repository;

import org.cassproject.ebac.identity.EcIdentityManager;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.json.ld.EcLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSGlobal;

import com.eduworks.ec.crypto.EcAes;
import com.eduworks.ec.crypto.EcAesCtr;
import com.eduworks.ec.crypto.EcPk;
import com.eduworks.ec.crypto.EcPpk;
import com.eduworks.ec.crypto.EcRsaOaep;
import com.eduworks.schema.ebac.EbacEncryptedSecret;
import com.eduworks.schema.ebac.EbacEncryptedValue;

public class EcEncryptedValue extends EbacEncryptedValue
{
	public EcEncryptedValue()
	{

	}
	public static EbacEncryptedValue toEncryptedValue(EcRemoteLinkedData d, boolean hideType)
	{
		EbacEncryptedValue v = new EbacEncryptedValue();

		if (!hideType)
			v.encryptedType = v.type;
		String newIv = EcAes.newIv(64);
		String newSecret = EcAes.newIv(64);
		v.payload = EcAesCtr.encrypt(d.toJson(), newSecret, newIv);

		for (int i = 0; i < d.owner.$length(); i++)
		{
			EbacEncryptedSecret eSecret = new EbacEncryptedSecret();
			eSecret.id = d.id;
			eSecret.iv = newIv;
			eSecret.secret = newSecret;
			if (v.secret == null)
				v.secret = new Array<String>();
			v.secret.push(EcRsaOaep.encrypt(EcPk.fromPem(d.owner.$get(i)), eSecret.toJson()));
		}
		return v;
	}

	public EcRemoteLinkedData decrypt()
	{
		EcRemoteLinkedData d = null;
		// See if I am an owner.
		if (owner != null)
			for (int i = 0; i < owner.$length(); i++)
			{
				EcPpk decryptionKey = EcIdentityManager.getPpk(EcPk.fromPem(owner.$get(i)));
				if (decryptionKey == null)
					continue;
				for (int j = 0; j < secret.$length(); j++)
				{
					String decryptedSecret = null;
					decryptedSecret = EcRsaOaep.decrypt(decryptionKey, secret.$get(j));
					if (!EcLinkedData.isProbablyJson(decryptedSecret))
						continue;
					EbacEncryptedSecret secret = (EbacEncryptedSecret) JSGlobal.JSON.parse(decryptedSecret);
					return (EcRemoteLinkedData) JSGlobal.JSON.parse(EcAesCtr.decrypt(payload, secret.secret, secret.iv));
				}
			}
		// See if I have read-only access.
		if (reader != null)
			for (int i = 0; i < reader.$length(); i++)
			{
				EcPpk decryptionKey = EcIdentityManager.getPpk(EcPk.fromPem(reader.$get(i)));
				if (decryptionKey == null)
					continue;
				for (int j = 0; j < secret.$length(); j++)
				{
					String decryptedSecret = null;
					decryptedSecret = EcRsaOaep.decrypt(decryptionKey, secret.$get(j));
					if (!EcLinkedData.isProbablyJson(decryptedSecret))
						continue;
					EbacEncryptedSecret secret = (EbacEncryptedSecret) JSGlobal.JSON.parse(decryptedSecret);
					return (EcRemoteLinkedData) JSGlobal.JSON.parse(EcAesCtr.decrypt(payload, secret.secret, secret.iv));
				}
			}
		// Last resort, try all the keys I have on all the possible locks.
		for (int i = 0; i < EcIdentityManager.ids.$length(); i++)
		{
			EcPpk decryptionKey = EcIdentityManager.ids.$get(i).ppk;
			for (int j = 0; j < secret.$length(); j++)
			{
				String decryptedSecret = null;
				decryptedSecret = EcRsaOaep.decrypt(decryptionKey, secret.$get(j));
				if (!EcLinkedData.isProbablyJson(decryptedSecret))
					continue;
				EbacEncryptedSecret secret = (EbacEncryptedSecret) JSGlobal.JSON.parse(decryptedSecret);
				return (EcRemoteLinkedData) JSGlobal.JSON.parse(EcAesCtr.decrypt(payload, secret.secret, secret.iv));
			}
		}
		return null;
	}
}
