package org.cassproject.ebac.repository;

import org.cassproject.ebac.identity.EcIdentityManager;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.json.ld.EcLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSGlobal;
import org.stjs.javascript.JSObjectAdapter;

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
			v.encryptedType = d.type;
		String newIv = EcAes.newIv(32);
		String newSecret = EcAes.newIv(32);
		v.payload = EcAesCtr.encrypt(d.toJson(), newSecret, newIv);
		v.owner = d.owner;
		if (JSObjectAdapter.$get(d, "name") != null)
			v.name = (String) JSObjectAdapter.$get(d, "name");

		for (int i = 0; i < d.owner.$length(); i++)
		{
			EbacEncryptedSecret eSecret = new EbacEncryptedSecret();
			eSecret.id = d.id;
			eSecret.iv = newIv;
			eSecret.secret = newSecret;
			if (v.secret == null)
				v.secret = new Array<String>();
			v.secret.push(EcRsaOaep.encrypt(EcPk.fromPem(d.owner.$get(i)), eSecret.toEncryptableJson()));
		}
		return v;
	}

	public static EbacEncryptedValue encryptValue(String text, String id, String fieldName, EcPk owner)
	{
		EbacEncryptedValue v = new EbacEncryptedValue();

		String newIv = EcAes.newIv(32);
		String newSecret = EcAes.newIv(32);
		v.payload = EcAesCtr.encrypt(text, newSecret, newIv);
		v.addOwner(owner);

		for (int i = 0; i < v.owner.$length(); i++)
		{
			EbacEncryptedSecret eSecret = new EbacEncryptedSecret();
			eSecret.id = id;
			eSecret.iv = newIv;
			eSecret.secret = newSecret;
			if (v.secret == null)
				v.secret = new Array<String>();
			v.secret.push(EcRsaOaep.encrypt(EcPk.fromPem(v.owner.$get(i)), eSecret.toEncryptableJson()));
		}
		return v;
	}

	public EcRemoteLinkedData decryptIntoObject()
	{
		EcRemoteLinkedData d = null;
		// See if I am an owner.
		if (owner != null)
			for (int i = 0; i < owner.$length(); i++)
			{
				EcPpk decryptionKey = EcIdentityManager.getPpk(EcPk.fromPem(owner.$get(i)));
				if (decryptionKey == null)
					continue;
				EcRemoteLinkedData decrypted = decryptToObject(decryptionKey);
				if (decrypted != null)
					return decrypted;

			}
		// See if I have read-only access.
		if (reader != null)
			for (int i = 0; i < reader.$length(); i++)
			{
				EcPpk decryptionKey = EcIdentityManager.getPpk(EcPk.fromPem(reader.$get(i)));
				if (decryptionKey == null)
					continue;
				EcRemoteLinkedData decrypted = decryptToObject(decryptionKey);
				if (decrypted != null)
					return decrypted;
			}
		// Last resort, try all the keys I have on all the possible locks.
		for (int i = 0; i < EcIdentityManager.ids.$length(); i++)
		{
			EcPpk decryptionKey = EcIdentityManager.ids.$get(i).ppk;
			EcRemoteLinkedData decrypted = decryptToObject(decryptionKey);
			if (decrypted != null)
				return decrypted;
		}
		return null;
	}

	public String decryptIntoString()
	{
		EcRemoteLinkedData d = null;
		// See if I am an owner.
		if (owner != null)
			for (int i = 0; i < owner.$length(); i++)
			{
				EcPpk decryptionKey = EcIdentityManager.getPpk(EcPk.fromPem(owner.$get(i)));
				if (decryptionKey == null)
					continue;
				String decrypted = decryptRaw(decryptionKey);
				if (decrypted != null)
					return decrypted;

			}
		// See if I have read-only access.
		if (reader != null)
			for (int i = 0; i < reader.$length(); i++)
			{
				EcPpk decryptionKey = EcIdentityManager.getPpk(EcPk.fromPem(reader.$get(i)));
				if (decryptionKey == null)
					continue;
				String decrypted = decryptRaw(decryptionKey);
				if (decrypted != null)
					return decrypted;
			}
		// Last resort, try all the keys I have on all the possible locks.
		for (int i = 0; i < EcIdentityManager.ids.$length(); i++)
		{
			EcPpk decryptionKey = EcIdentityManager.ids.$get(i).ppk;
			String decrypted = decryptRaw(decryptionKey);
			if (decrypted != null)
				return decrypted;
		}
		return null;
	}

	private String decryptRaw(EcPpk decryptionKey)
	{
		for (int j = 0; j < secret.$length(); j++)
		{
			String decryptedSecret = null;
			decryptedSecret = EcRsaOaep.decrypt(decryptionKey, secret.$get(j));
			if (!EcLinkedData.isProbablyJson(decryptedSecret))
				continue;
			EbacEncryptedSecret secret = EbacEncryptedSecret.fromEncryptableJson(JSGlobal.JSON.parse(decryptedSecret));
			return EcAesCtr.decrypt(payload, secret.secret, secret.iv);
		}
		return null;
	}

	private EcRemoteLinkedData decryptToObject(EcPpk decryptionKey)
	{
		for (int j = 0; j < secret.$length(); j++)
		{
			String decryptRaw = decryptRaw(decryptionKey);
			if (decryptRaw == null)
				continue;
			if (!EcLinkedData.isProbablyJson(decryptRaw))
				continue;
			EcRemoteLinkedData decrypted = new EcRemoteLinkedData("","");
			decrypted.copyFrom((EcRemoteLinkedData) JSGlobal.JSON.parse(decryptRaw));
			return (EcRemoteLinkedData) decrypted.deAtify();
		}
		return null;
	}
}
