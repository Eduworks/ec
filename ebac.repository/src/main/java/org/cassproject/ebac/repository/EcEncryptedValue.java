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
 * @module com.eduworks.ec
 * @class EcEncryptedValue
 * @extends EbacEncryptedValue
 * 
 * @author fritz.ray@eduworks.com
 */
public class EcEncryptedValue extends EbacEncryptedValue
{
	
	
	
	public EcEncryptedValue()
	{

	}
	
	public static EcEncryptedValue revive(EcEncryptedValue partiallyRehydratedObject)
	{
		EcEncryptedValue v = new EcEncryptedValue();
		v.copyFrom(partiallyRehydratedObject);
		return v;
	}

	/**
	 * Converts a piece of remote linked data to an encrypted value
	 * 
	 * @memberOf EcEncryptedValue
	 * @method toEncryptedValue
	 * @static
	 * @param {EcRemoteLinkedData} d
	 * 			Data to encrypt
	 * @param {boolean} hideType
	 * 			Flag to hide the type of the encrypted value when encrypting
	 * @return {EcEncryptedValue}
	 * 			Encrypted value
	 */
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

	/**
	 * Converts a piece of remote linked data to an encrypted value, asynchronously
	 * 
	 * @memberOf EcEncryptedValue
	 * @method toEncryptedValueAsync
	 * @static
	 * @param {EcRemoteLinkedData} d
	 * 			Data to encrypt
	 * @param {boolean} hideType
	 * 			Flag to hide the type of the encrypted value when encrypting
	 * @param {Callback1<EcEncryptedValue>} success
	 * 			Callback triggered with successfully encrypted,
	 * 			returns the encrypted value
	 * @param {Callback1<String>} failure
	 * 			Callback triggered on error during encryption
	 */
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

	/**
	 * Encrypts a text value with the key provided
	 * 
	 * @memberOf EcEncryptedValue
	 * @method encryptValueOld
	 * @static
	 * @deprecated
	 * @param {String} text
	 * 			Text to encrypt
	 * @param {String} id
	 * 			ID of the encrypted value
	 * @param {EcPk} owner
	 * 			Key to Encrypt
	 * @return {EcEncryptedValue}
	 * 			Encrypted value
	 */
	@Deprecated
	public static EcEncryptedValue encryptValueOld(String text, String id, EcPk owner)
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
			v.secret.push(
				EcRsaOaep.encrypt(
					EcPk.fromPem(v.owner.$get(i)), 
					eSecret.toEncryptableJson()
				)
			);
		}
		return v;
	}

	/**
	 * Encrypts a text value with the owners and readers provided
	 *
	 * @memberOf EcEncryptedValue
	 * @method encryptValue
	 * @static
	 * @param {String} text
	 * 			Text to encrypt
	 * @param {String} id
	 * 			ID of the value to encrypt
	 * @param {String[]} owners
	 * 			Owner keys to encrypt value with
	 * @param {String[]} readers
	 * 			Reader keys to encrypt value with
	 * @return {EcEncryptedValue}
	 * 			Encrypted value
	 */
	public static EcEncryptedValue encryptValue(String text, String id, Array<String> owners, Array<String> readers)
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

	/**
	 * Encrypt a value with a specific IV and secret
	 * 
	 * @memberOf EcEncryptedValue
	 * @method encryptValueUsingIvAndSecret
	 * @static 
	 * @param {String} iv
	 * 			Initialization Vector for encryption
	 * @param {String} secret
	 * 			Encryption secret
	 * @param {String} text
	 * 			Text to encrypt
	 * @param {String} id
	 * 			ID of value to encrypt
	 * @param {String[]} owners
	 * 			Owners keys to encrypt with
	 * @param {String[]} readers
	 * 			Reader Keys to encrypt with
	 * @return {EcEncryptedValue}
	 */
	public static EcEncryptedValue encryptValueUsingIvAndSecret(String iv, String secret, String text, String id, Array<String> owners, Array<String> readers)
	{
		EcEncryptedValue v = new EcEncryptedValue();

		v.payload = EcAesCtr.encrypt(text, secret, iv);
		if (owners != null)
			for (int i = 0; i < owners.$length(); i++)
				v.addOwner(EcPk.fromPem(owners.$get(i)));

		if (owners != null)
			for (int i = 0; i < v.owner.$length(); i++)
			{
				EbacEncryptedSecret eSecret = new EbacEncryptedSecret();
				eSecret.id = util.encode64(pkcs5.pbkdf2(id, "", 1, 8));
				eSecret.iv = iv;
				eSecret.secret = secret;
				if (v.secret == null)
					v.secret = new Array<String>();
				v.secret.push(EcRsaOaep.encrypt(EcPk.fromPem(v.owner.$get(i)), eSecret.toEncryptableJson()));
			}

		if (readers != null)
			for (int i = 0; i < readers.$length(); i++)
				v.addReader(EcPk.fromPem(readers.$get(i)));
		return v;
	}

	/**
	 * Decrypts this encrypted value into an object
	 * 
	 * @memberOf EcEncryptedValue
	 * @method decryptIntoObject
	 * @return
	 * 			The Decrypted Object
	 */
	public EcRemoteLinkedData decryptIntoObject()
	{
		String decryptRaw = decryptIntoString();
		if (decryptRaw == null)
			return null;
		if (!EcLinkedData.isProbablyJson(decryptRaw))
			return null;
		EcRemoteLinkedData decrypted = new EcRemoteLinkedData("", "");
		decrypted.copyFrom((EcRemoteLinkedData) JSGlobal.JSON.parse(decryptRaw));
		encryptOnSave(decrypted.id, true);
		decrypted.id = this.id;
		return (EcRemoteLinkedData) decrypted.deAtify();
	}

	/**
	 * Asynchronously decrypts this encrypted value into an object 
	 * 
	 * @memberOf EcEncryptedValue
	 * @method decryptIntoObjectAsync
	 * @param {Callback1<EcRemoteLinkedDat>} success
	 * 			Callback triggered on successful encryption,
	 * 			returns the decrypted object
	 * @param {Callback1<String>} failure
	 * 			Callback triggered if error during encryption
	 */
	public void decryptIntoObjectAsync(final Callback1<EcRemoteLinkedData> success, final Callback1<String> failure)
	{
		final String id = this.id;
		decryptIntoStringAsync(new Callback1<String>()
		{
			@Override
			public void $invoke(String decryptRaw)
			{
				if (decryptRaw == null)
					failure.$invoke("Could not decrypt data.");
				if (!EcLinkedData.isProbablyJson(decryptRaw))
					failure.$invoke("Could not decrypt data.");
				EcRemoteLinkedData decrypted = new EcRemoteLinkedData("", "");
				decrypted.copyFrom((EcRemoteLinkedData) JSGlobal.JSON.parse(decryptRaw));
				encryptOnSave(decrypted.id, true);
				decrypted.id = id;
				success.$invoke((EcRemoteLinkedData) decrypted.deAtify());
			}
		}, failure);
	}

	/**
	 * Asynchronously decrypts this encrypted value into an object with a IV and secret provided
	 * 
	 * @memberOf EcEncryptedValue
	 * @method decryptIntoObjectUsingIvAndSecretAsync
	 * @param {String} iv
	 * 			Initialization Vector for decryption
	 * @param {String} secret
	 * 			Secret for decryption
	 * @param {Callback1<EcRemoteLinkedData>} success
	 * 			Callback triggered after successful decryption
	 * @param {Callback1<String>} failure
	 * 			Callback triggered if error during decryption
	 */
	public void decryptIntoObjectUsingIvAndSecretAsync(String iv, String secret, final Callback1<EcRemoteLinkedData> success, final Callback1<String> failure)
	{
		decryptIntoStringUsingIvAndSecretAsync(iv,secret,new Callback1<String>()
		{
			@Override
			public void $invoke(String decryptRaw)
			{
				if (decryptRaw == null)
					failure.$invoke("Could not decrypt data.");
				if (!EcLinkedData.isProbablyJson(decryptRaw))
					failure.$invoke("Could not decrypt data.");
				EcRemoteLinkedData decrypted = new EcRemoteLinkedData("", "");
				decrypted.copyFrom((EcRemoteLinkedData) JSGlobal.JSON.parse(decryptRaw));
				encryptOnSave(decrypted.id, true);
				success.$invoke((EcRemoteLinkedData) decrypted.deAtify());
			}
		}, failure);
	}

	/**
	 * Decrypts an encrypted value into a string
	 * 
	 * @memberOf EcEncryptedValue
	 * @method decryptIntoString
	 * @return {String}
	 * 			Decrypted string value
	 */
	public String decryptIntoString()
	{
		EbacEncryptedSecret decryptSecret = decryptSecret();
		if (decryptSecret != null)
			return EcAesCtr.decrypt(payload, decryptSecret.secret, decryptSecret.iv);
		return null;
	}

	/**
	 * Asynchronously decrypts an encrypted value into a string 
	 * 
	 * @memberOf EcEncryptedValue
	 * @method decryptIntoStringAsync
	 * @param {Callback1<String>} success
	 * 			Callback triggered after successfully decrypted,
	 * 			returns decrypted string
	 * @param {Callback1<String>} failure
	 * 			Callback triggered if error during decryption
	 */
	public void decryptIntoStringAsync(final Callback1<String> success, final Callback1<String> failure)
	{
		final EcEncryptedValue me = this;
		decryptSecretAsync(new Callback1<EbacEncryptedSecret>()
		{
			@Override
			public void $invoke(EbacEncryptedSecret decryptSecret)
			{
				if (decryptSecret != null)
					EcAesCtrAsync.decrypt(me.payload, decryptSecret.secret, decryptSecret.iv, success, failure);
			}
		}, failure);
	}

	/**
	 * Asynchronously decrypts an encrypted value into a string with an IV and secrete provided
	 * 
	 * @memberOf EcEncryptedValue
	 * @method decryptIntoStringUsingIvAndSecretAsync
	 * @param {String} iv
	 * 			Initialization Vector for decryption
	 * @param {String} secret
	 * 			Secret for decryption
	 * @param {Callback1<String>} success
	 * 			Callback triggered on successful decryption
	 * @param {Callback1<String>} failure
	 * 			Callback triggered if error during decryption
	 */
	public void decryptIntoStringUsingIvAndSecretAsync(final String iv, final String secret, final Callback1<String> success, final Callback1<String> failure)
	{
		EcAesCtrAsync.decrypt(payload, secret, iv, success, failure);
	}

	/**
	 * Attempts to decrypt the secret by using all Identities in the Identity Manager
	 * 
	 * @memberOf EcEncryptedValue
	 * @method decryptSecret
	 * @return {EbacEncryptedSecret}
	 * 			Secret after decrypted
	 */
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

	/**
	 * Asynchronously attempts to decrypt secret using all identities in Identity Manager
	 * 
	 * @memberOf EcEncryptedValue
	 * @method decryptSecretAsync
	 * @param {Callback1<EbacEncryptedSecret>} success
	 * 			Callback triggered after successfully decrypting secret,
	 * 			returns the decrypted secret
	 * @param {Callback1<String>} failure
	 * 			Callback triggered if error decrypting secret
	 */
	public void decryptSecretAsync(final Callback1<EbacEncryptedSecret> success, final Callback1<String> failure)
	{
		Array<EcPpk> ppks = new Array<>();

		// See if I am an owner.
		if (owner != null)
			for (int i = 0; i < owner.$length(); i++)
			{
				EcPpk decryptionKey = EcIdentityManager.getPpk(EcPk.fromPem(owner.$get(i)));
				if (decryptionKey != null)
					if (!decryptionKey.inArray(ppks))
						ppks.push(decryptionKey);
			}
		// See if I have read-only access.
		if (reader != null)
			for (int i = 0; i < reader.$length(); i++)
			{
				EcPpk decryptionKey = EcIdentityManager.getPpk(EcPk.fromPem(reader.$get(i)));
				if (decryptionKey != null)
					if (!decryptionKey.inArray(ppks))
						ppks.push(decryptionKey);
			}
		// Last resort, try all the keys I have on all the possible locks.
		for (int i = 0; i < EcIdentityManager.ids.$length(); i++)
		{
			EcPpk decryptionKey = EcIdentityManager.ids.$get(i).ppk;
			if (decryptionKey != null)
				if (!decryptionKey.inArray(ppks))
					ppks.push(decryptionKey);
		}
		final EcEncryptedValue me = this;
		new EcAsyncHelper<EcPpk>().each(ppks, new Callback2<EcPpk, Callback0>()
		{
			@Override
			public void $invoke(EcPpk decryptionKey, final Callback0 countdown)
			{
				me.decryptSecretByKeyAsync(decryptionKey, success, new Callback1<String>()
				{
					@Override
					public void $invoke(String arg0)
					{
						countdown.$invoke();
					}
				});
			}
		}, new Callback1<Array<EcPpk>>()
		{
			@Override
			public void $invoke(Array<EcPpk> arg0)
			{
				failure.$invoke("Could not decrypt secret.");
			}
		});
	}

	/**
	 * Attempts to decrypt secret with a specific key
	 * 
	 * @memberOf EcEncryptedValue
	 * @method decryptSecretByKey
	 * @param {EcPpk} decryptionKey
	 * 			Key to attempt secret decryption
	 * @return {EbacEncryptedSecret}
	 * 			Decrypted Secret
	 */
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

	/**
	 * Asynchronously attempts to decrypt secret with a specific key
	 * 
	 * @memberOf EcEncryptedValue
	 * @method decryptSecretByKeyAsync
	 * @param {EcPpk} decryptionKey
	 * 			Key to attempt secret decryption
	 * @param {Callback1<EbacEncryptedSecret>} success
	 * 			Callback triggered after successful decryption of secret,
	 * 			returns decrypted secret
	 * @param {Callback1<String>} failure
	 * 			Callback triggered if error during secret decryption
	 */
	private void decryptSecretByKeyAsync(final EcPpk decryptionKey, final Callback1<EbacEncryptedSecret> success, final Callback1<String> failure)
	{
		EbacEncryptedSecret encryptedSecret = null;
		if (this.secret != null)
		{
			final EcAsyncHelper<String> helper = new EcAsyncHelper<String>();
			helper.each(secret, new Callback2<String, Callback0>()
			{
				@Override
				public void $invoke(String decryptionSecret, final Callback0 decrement)
				{
					EcRsaOaepAsync.decrypt(decryptionKey, decryptionSecret, new Callback1<String>()
					{
						@Override
						public void $invoke(String decryptedSecret)
						{
							if (helper.counter == -1) 
								return;
							if (!EcLinkedData.isProbablyJson(decryptedSecret))
								decrement.$invoke();
							else
							{
								helper.stop();
								success.$invoke(EbacEncryptedSecret.fromEncryptableJson(JSGlobal.JSON.parse(decryptedSecret)));
							}
						}
					}, new Callback1<String>()
					{
						@Override
						public void $invoke(String arg0)
						{
							decrement.$invoke();
						}
					});
				}
			}, new Callback1<Array<String>>()
			{

				@Override
				public void $invoke(Array<String> arg0)
				{
					failure.$invoke("Could not find decryption key.");
				}
			});
		}
	}

	/**
	 * Checks if this encrypted value is an encrypted version of a specific type, 
	 * only works if the type wasn't hidden during encryption
	 * 
	 * @memberOf EcEncryptedValue
	 * @method isAnEncrypted
	 * @param {String} type
	 * 			Type to compare if an encrypted type
	 * @return {boolean}
	 * 			True if encrypted version of type, false if not or can't tell
	 */
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
	 * @memberOf EcEncryptedValue
	 * @method addReader
	 * @param {EcPk} newReader
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
	 * @memberOf EcEncryptedValue
	 * @method removeReader
	 * @param {EcPk} oldReader
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
	
	private static Map<String, Boolean> encryptOnSaveMap;
	
	/**
	 * Setter and getter function for encryptOnSave of an identifier,
	 * encryptOnSave is used by the static save functions of a class to 
	 * determine whether or not to encrypt something when it is saved.
	 * This value is usually set when an object is decrypted using one
	 * of the decrypt functions above.
	 * 
	 * @memberOf EcEncryptedValue
	 * @method encryptOnSave
	 * @static
	 * @param {String} id 
	 * 			ID of the data to get/set encryptOnSave for
	 * @param {boolean} [val]
	 * 			If passed in, sets the value, if null this function gets the encryptOnSave value
	 * @return {boolean}
	 * 			if val is null/ignored returns value in the map, if val is passed in returns val
	 */
	public static boolean encryptOnSave(String id, Boolean val){
		if(encryptOnSaveMap == null)
			encryptOnSaveMap = JSCollections.$map();
		
		if(val == null){
			if(encryptOnSaveMap.$get(id) != null)
				return encryptOnSaveMap.$get(id);
			else
				return false;
		}else{
			encryptOnSaveMap.$put(id, val);
			
			return val;
		}
	}
}
