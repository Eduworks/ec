package com.eduworks.ec.ebac.repository;

import org.stjs.javascript.Array;
import org.stjs.javascript.JSGlobal;

import com.eduworks.ec.crypto.EcAes;
import com.eduworks.ec.crypto.EcAesCtr;
import com.eduworks.ec.crypto.EcPk;
import com.eduworks.ec.crypto.EcPpk;
import com.eduworks.ec.crypto.EcRsaOaep;
import com.eduworks.ec.ebac.identity.EcIdentityManager;
import com.eduworks.ec.ebac.identity.remote.Ebac;
import com.eduworks.ec.ld.EcLinkedData;

public class EcEncryptedValue extends EcRemoteLinkedData
{
	public EcEncryptedValue()
	{
		super(Ebac.schema, "http://schema.eduworks.com/ebac/0.1/encryptedValue");
	}

	String encryptedType;
	String payload;
	Array<String> reader;
	Array<String> secret;

	public static EcEncryptedValue toEncryptedValue(EcRemoteLinkedData d, boolean hideType)
	{
		EcEncryptedValue v = new EcEncryptedValue();

		if (!hideType)
			v.encryptedType = v.type;
		String newIv = EcAes.newIv(64);
		String newSecret = EcAes.newIv(64);
		v.payload = EcAesCtr.encrypt(d.toJson(), newSecret, newIv);

		for (int i = 0; i < d.owner.$length(); i++)
		{
			EcEncryptedSecret eSecret = new EcEncryptedSecret();
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
		//See if I am an owner.
		if (owner != null)
		for (int i = 0;i < owner.$length();i++)
		{
			EcPpk decryptionKey = EcIdentityManager.getPpk(EcPk.fromPem(owner.$get(i)));
			if (decryptionKey == null) 
				continue;
			for (int j = 0;j < secret.$length();j++)
			{
				String decryptedSecret = null;
				decryptedSecret = EcRsaOaep.decrypt(decryptionKey, secret.$get(j));
				if (!EcLinkedData.isProbablyJson(decryptedSecret))
					continue;
				EcEncryptedSecret secret = (EcEncryptedSecret) JSGlobal.JSON.parse(decryptedSecret);
				return (EcRemoteLinkedData) JSGlobal.JSON.parse(EcAesCtr.decrypt(payload, secret.secret, secret.iv));
			}
		}
		//See if I have read-only access.
		if (reader != null)
		for (int i = 0;i < reader.$length();i++)
		{
			EcPpk decryptionKey = EcIdentityManager.getPpk(EcPk.fromPem(reader.$get(i)));
			if (decryptionKey == null) 
				continue;
			for (int j = 0;j < secret.$length();j++)
			{
				String decryptedSecret = null;
				decryptedSecret = EcRsaOaep.decrypt(decryptionKey, secret.$get(j));
				if (!EcLinkedData.isProbablyJson(decryptedSecret))
					continue;
				EcEncryptedSecret secret = (EcEncryptedSecret) JSGlobal.JSON.parse(decryptedSecret);
				return (EcRemoteLinkedData) JSGlobal.JSON.parse(EcAesCtr.decrypt(payload, secret.secret, secret.iv));
			}
		}
		//Last resort, try all the keys I have on all the possible locks.
		for (int i = 0;i < EcIdentityManager.ids.$length();i++)
		{
			EcPpk decryptionKey = EcIdentityManager.ids.$get(i).ppk;
			for (int j = 0;j < secret.$length();j++)
			{
				String decryptedSecret = null;
				decryptedSecret = EcRsaOaep.decrypt(decryptionKey, secret.$get(j));
				if (!EcLinkedData.isProbablyJson(decryptedSecret))
					continue;
				EcEncryptedSecret secret = (EcEncryptedSecret) JSGlobal.JSON.parse(decryptedSecret);
				return (EcRemoteLinkedData) JSGlobal.JSON.parse(EcAesCtr.decrypt(payload, secret.secret, secret.iv));
			}
		}
		return null;
	}
}
