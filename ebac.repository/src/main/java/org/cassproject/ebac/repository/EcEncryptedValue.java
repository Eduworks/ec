package org.cassproject.ebac.repository;

import org.cassproject.ebac.identity.EcIdentityManager;
import org.cassproject.schema.general.EcRemoteLinkedData;
import org.json.ld.EcLinkedData;
import org.stjs.javascript.Array;
import org.stjs.javascript.Global;
import org.stjs.javascript.JSCollections;
import org.stjs.javascript.JSGlobal;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;
import org.stjs.javascript.functions.Callback0;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Callback2;

import com.eduworks.ec.array.EcAsyncHelper;
import com.eduworks.ec.crypto.EcAes;
import com.eduworks.ec.crypto.EcAesCtr;
import com.eduworks.ec.crypto.EcAesCtrAsync;
import com.eduworks.ec.crypto.EcPk;
import com.eduworks.ec.crypto.EcPpk;
import com.eduworks.ec.crypto.EcRsaOaep;
import com.eduworks.ec.crypto.EcRsaOaepAsync;
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

	public static void toEncryptedValueAsync(final EcRemoteLinkedData d, boolean hideType, final Callback1<EcEncryptedValue> success,
			final Callback1<String> failure)
	{
		d.updateTimestamp();

		final EcEncryptedValue v = new EcEncryptedValue();

		if (!hideType)
			v.encryptedType = d.type;
		final String newIv = EcAes.newIv(32);
		final String newSecret = EcAes.newIv(32);
		EcAesCtrAsync.encrypt(d.toJson(), newSecret, newIv, new Callback1<String>()
		{
			@Override
			public void $invoke(String encryptedText)
			{
				v.payload = encryptedText;
				v.owner = d.owner;
				v.reader = d.reader;
				v.id = d.id;
				if (JSObjectAdapter.$get(d, "name") != null)
					v.name = (String) JSObjectAdapter.$get(d, "name");

				if (d.owner != null)
					new EcAsyncHelper<String>().each(d.owner, new Callback2<String, Callback0>()
					{
						@Override
						public void $invoke(String pk, final Callback0 arg1)
						{
							EbacEncryptedSecret eSecret = new EbacEncryptedSecret();
							eSecret.iv = newIv;
							eSecret.secret = newSecret;
							if (v.secret == null)
								v.secret = new Array<String>();
							EcRsaOaepAsync.encrypt(EcPk.fromPem(pk), eSecret.toEncryptableJson(), new Callback1<String>()
							{
								@Override
								public void $invoke(String encryptedSecret)
								{
									v.secret.push(encryptedSecret);
									arg1.$invoke();
								}
							}, failure);
						}
					}, new Callback1<Array<String>>()
					{
						@Override
						public void $invoke(Array<String> arg0)
						{
							if (d.reader != null)
								new EcAsyncHelper<String>().each(d.reader, new Callback2<String, Callback0>()
								{
									@Override
									public void $invoke(String pk, final Callback0 arg1)
									{
										EbacEncryptedSecret eSecret = new EbacEncryptedSecret();
										eSecret.iv = newIv;
										eSecret.secret = newSecret;
										if (v.secret == null)
											v.secret = new Array<String>();
										EcRsaOaepAsync.encrypt(EcPk.fromPem(pk), eSecret.toEncryptableJson(), new Callback1<String>()
										{
											@Override
											public void $invoke(String encryptedSecret)
											{
												v.secret.push(encryptedSecret);
												arg1.$invoke();
											}
										}, failure);
									}
								}, new Callback1<Array<String>>()
								{
									@Override
									public void $invoke(Array<String> arg0)
									{
										success.$invoke(v);
									}
								});
						}
					});
			}
		}, failure);
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
				{
					decrypted.id = this.id;
					return decrypted;
				}
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
				{
					decrypted.id = this.id;
					return decrypted;
				}
			}
		// Last resort, try all the keys I have on all the possible locks.
		for (int i = 0; i < EcIdentityManager.ids.$length(); i++)
		{
			EcPpk decryptionKey = EcIdentityManager.ids.$get(i).ppk;
			EcRemoteLinkedData decrypted = decryptToObject(decryptionKey);
			if (decrypted != null)
			{
				decrypted.id = this.id;
				return decrypted;
			}
		}
		return null;
	}

	public String decryptIntoString()
	{
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

	public EbacEncryptedSecret decryptSecret()
	{
		// See if I am an owner.
		if (owner != null)
			for (int i = 0; i < owner.$length(); i++)
			{
				EcPpk decryptionKey = EcIdentityManager.getPpk(EcPk.fromPem(owner.$get(i)));
				if (decryptionKey == null)
					continue;
				EbacEncryptedSecret decrypted = decryptSecretByKey(decryptionKey);
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
				EbacEncryptedSecret decrypted = decryptSecretByKey(decryptionKey);
				if (decrypted != null)
					return decrypted;
			}
		// Last resort, try all the keys I have on all the possible locks.
		for (int i = 0; i < EcIdentityManager.ids.$length(); i++)
		{
			EcPpk decryptionKey = EcIdentityManager.ids.$get(i).ppk;
			EbacEncryptedSecret decrypted = decryptSecretByKey(decryptionKey);
			if (decrypted != null)
				return decrypted;
		}
		return null;
	}

	private String decryptRaw(EcPpk decryptionKey)
	{
		EbacEncryptedSecret encryptedSecret = decryptSecretByKey(decryptionKey);
		if (encryptedSecret != null)
			return EcAesCtr.decrypt(payload, encryptedSecret.secret, encryptedSecret.iv);
		return null;
	}

	private EbacEncryptedSecret decryptSecretByKey(EcPpk decryptionKey)
	{
		EbacEncryptedSecret encryptedSecret = null;
		if (this.secret != null)
			for (int j = 0; j < this.secret.$length(); j++)
			{
				try
				{
					String decryptedSecret = null;
					decryptedSecret = EcRsaOaep.decrypt(decryptionKey, this.secret.$get(j));
					if (!EcLinkedData.isProbablyJson(decryptedSecret))
						continue;
					encryptedSecret = EbacEncryptedSecret.fromEncryptableJson(JSGlobal.JSON.parse(decryptedSecret));
				} catch (Exception ex)
				{

				}
			}
		return encryptedSecret;
	}

	private EcRemoteLinkedData decryptToObject(EcPpk decryptionKey)
	{
		String decryptRaw = decryptRaw(decryptionKey);
		if (decryptRaw == null)
			return null;
		if (!EcLinkedData.isProbablyJson(decryptRaw))
			return null;
		EcRemoteLinkedData decrypted = new EcRemoteLinkedData("", "");
		decrypted.copyFrom((EcRemoteLinkedData) JSGlobal.JSON.parse(decryptRaw));
		decrypted.privateEncrypted = true;
		return (EcRemoteLinkedData) decrypted.deAtify();
	}

	public boolean isAnEncrypted(String type)
	{
		if (this.encryptedType == null)
			return false;

		Array<String> typeSplit = JSCollections.$castArray(type.split("/"));

		return this.encryptedType.equals(type) || this.encryptedType.equals(typeSplit.$get(typeSplit.$length() - 1));
	}

	/**
	 * Adds a reader to the object, if the reader does not exist.
	 * 
	 * @param newReader
	 *            PK of the new reader.
	 */
	public void addReader(EcPk newReader)
	{
		EbacEncryptedSecret payloadSecret = decryptSecret();

		if (payloadSecret == null)
		{
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
