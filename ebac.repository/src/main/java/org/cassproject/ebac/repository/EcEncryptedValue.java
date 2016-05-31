package org.cassproject.ebac.repository;

import org.cassproject.ebac.identity.EcIdentityManager;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.json.ld.EcLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSGlobal;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;

import com.eduworks.ec.crypto.EcAes;
import com.eduworks.ec.crypto.EcAesCtr;
import com.eduworks.ec.crypto.EcPk;
import com.eduworks.ec.crypto.EcPpk;
import com.eduworks.ec.crypto.EcRsaOaep;
import com.eduworks.schema.ebac.EbacEncryptedSecret;
import com.eduworks.schema.ebac.EbacEncryptedValue;

import forge.pkcs5;
import forge.util;

/**
 * Represents an encrypted piece of data. Provides helper functions for
 * encryption/decryption of JSON-LD objects, and provides some searchability of
 * the data within.
 * 
 * @author fritz.ray@eduworks.com
 *
 */
public class EcEncryptedValue extends EbacEncryptedValue
{
	public EcEncryptedValue()
	{

	}

	public static EcEncryptedValue toEncryptedValue(EcRemoteLinkedData d, boolean hideType)
	{
		d.updateTimestamp();
		
		EcEncryptedValue v = new EcEncryptedValue();

		if (!hideType)
			v.encryptedType = d.type;
		String newIv = EcAes.newIv(32);
		String newSecret = EcAes.newIv(32);
		v.payload = EcAesCtr.encrypt(d.toJson(), newSecret, newIv);
		v.owner = d.owner;
		v.reader = d.reader;
		v.id = d.id;
		if (JSObjectAdapter.$get(d, "name") != null)
			v.name = (String) JSObjectAdapter.$get(d, "name");

		if (d.owner != null)
		for (int i = 0; i < d.owner.$length(); i++)
		{
			EbacEncryptedSecret eSecret = new EbacEncryptedSecret();
			eSecret.iv = newIv;
			eSecret.secret = newSecret;
			if (v.secret == null)
				v.secret = new Array<String>();
			v.secret.push(EcRsaOaep.encrypt(EcPk.fromPem(d.owner.$get(i)), eSecret.toEncryptableJson()));
		}
		
		if (d.reader != null)
		for (int i = 0; i < d.reader.$length(); i++)
		{
			EbacEncryptedSecret eSecret = new EbacEncryptedSecret();
			eSecret.iv = newIv;
			eSecret.secret = newSecret;
			if (v.secret == null)
				v.secret = new Array<String>();
			v.secret.push(EcRsaOaep.encrypt(EcPk.fromPem(d.reader.$get(i)), eSecret.toEncryptableJson()));
		}
		return v;
	}

	@Deprecated
	public static EcEncryptedValue encryptValueOld(String text, String id, String fieldName, EcPk owner)
	{
		EcEncryptedValue v = new EcEncryptedValue();

		String newIv = EcAes.newIv(32);
		String newSecret = EcAes.newIv(32);
		v.payload = EcAesCtr.encrypt(text, newSecret, newIv);
		v.addOwner(owner);

		for (int i = 0; i < v.owner.$length(); i++)
		{
			EbacEncryptedSecret eSecret = new EbacEncryptedSecret();
			eSecret.id = util.encode64(pkcs5.pbkdf2(id, "", 1, 8));
			eSecret.iv = newIv;
			eSecret.secret = newSecret;
			if (v.secret == null)
				v.secret = new Array<String>();
			v.secret.push(EcRsaOaep.encrypt(EcPk.fromPem(v.owner.$get(i)), eSecret.toEncryptableJson()));
		}
		return v;
	}

	public static EcEncryptedValue encryptValue(String text, String id, String fieldName, Array<String> owners, Array<String> readers)
	{
		EcEncryptedValue v = new EcEncryptedValue();

		String newIv = EcAes.newIv(32);
		String newSecret = EcAes.newIv(32);
		v.payload = EcAesCtr.encrypt(text, newSecret, newIv);
		if (owners != null)
			for (int i = 0; i < owners.$length(); i++)
				v.addOwner(EcPk.fromPem(owners.$get(i)));

		if (owners != null)
		for (int i = 0; i < v.owner.$length(); i++)
		{
			EbacEncryptedSecret eSecret = new EbacEncryptedSecret();
			eSecret.id = util.encode64(pkcs5.pbkdf2(id, "", 1, 8));
			eSecret.iv = newIv;
			eSecret.secret = newSecret;
			if (v.secret == null)
				v.secret = new Array<String>();
			v.secret.push(EcRsaOaep.encrypt(EcPk.fromPem(v.owner.$get(i)), eSecret.toEncryptableJson()));
		}
		
		if (readers != null)
			for (int i = 0; i < readers.$length(); i++)
				v.addReader(EcPk.fromPem(readers.$get(i)));
//		if (readers != null)
//		for (int i = 0; i < v.reader.$length(); i++)
//		{
//			EbacEncryptedSecret eSecret = new EbacEncryptedSecret();
//			eSecret.id = util.encode64(pkcs5.pbkdf2(id, "", 1, 8));
//			eSecret.iv = newIv;
//			eSecret.secret = newSecret;
//			if (v.secret == null)
//				v.secret = new Array<String>();
//			v.secret.push(EcRsaOaep.encrypt(EcPk.fromPem(v.reader.$get(i)), eSecret.toEncryptableJson()));
//		}
		return v;
	}

	public EcRemoteLinkedData decryptIntoObject()
	{
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
		if (secret != null)
		for (int j = 0; j < secret.$length(); j++)
		{
			try
			{
				String decryptedSecret = null;
				decryptedSecret = EcRsaOaep.decrypt(decryptionKey, secret.$get(j));
				if (!EcLinkedData.isProbablyJson(decryptedSecret))
					continue;
				EbacEncryptedSecret secret = EbacEncryptedSecret.fromEncryptableJson(JSGlobal.JSON.parse(decryptedSecret));
				return EcAesCtr.decrypt(payload, secret.secret, secret.iv);
			}
			catch (Exception ex)
			{

			}
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
			EcRemoteLinkedData decrypted = new EcRemoteLinkedData("", "");
			decrypted.copyFrom((EcRemoteLinkedData) JSGlobal.JSON.parse(decryptRaw));
			decrypted.privateEncrypted = true;
			return (EcRemoteLinkedData) decrypted.deAtify();
		}
		return null;
	}
	
	
	public boolean isAnEncrypted(String type){
		if(this.encryptedType == null)
			return false;
		return this.encryptedType.equals(type);
	}
	
	/**
	 * Adds a reader to the object, if the reader does not exist.
	 * 
	 * @param newReader
	 *            PK of the new reader.
	 */
	public void addReader(EcPk newReader)
	{	
		EbacEncryptedSecret payloadSecret = null;
		for(int i = 0; i < EcIdentityManager.ids.$length(); i++){
			EcPpk decryptionKey = EcIdentityManager.ids.$get(i).ppk;
			
			if (secret != null)
			for (int j = 0; j < secret.$length(); j++)
			{
				try
				{
					String decryptedSecret = null;
					decryptedSecret = EcRsaOaep.decrypt(decryptionKey, secret.$get(j));
					if (!EcLinkedData.isProbablyJson(decryptedSecret))
						continue;
					payloadSecret = EbacEncryptedSecret.fromEncryptableJson(JSGlobal.JSON.parse(decryptedSecret));
					break;
				}
				catch (Exception ex)
				{
					Global.console.log("fail  "+secret.$get(j));
				}
			}
			
			if(payloadSecret != null)
				break;
		}
		if(payloadSecret == null){
			Global.console.error("Cannot add a Reader if you don't know the secret");
			return;
		}
		
		String pem = newReader.toPem();
		if (reader == null)
			reader = new Array<String>();
		for (int i = 0; i < reader.$length(); i++)
			if (reader.$get(i).equals(pem))
				return;
		reader.push(pem);
		
		secret.push(EcRsaOaep.encrypt(newReader, payloadSecret.toEncryptableJson()));
	}

	/**
	 * Removes a reader from the object, if the reader does exist.
	 * 
	 * @param oldReader
	 *            PK of the old reader.
	 */
	public void removeReader(EcPk oldReader)
	{	

		String pem = oldReader.toPem();
		if (reader == null)
			reader = new Array<String>();
		for (int i = 0; i < reader.$length(); i++)
			if (reader.$get(i).equals(pem))
				reader.splice(i, 1);
	}
}
