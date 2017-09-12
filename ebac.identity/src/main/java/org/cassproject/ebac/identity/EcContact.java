package org.cassproject.ebac.identity;

import com.eduworks.ec.crypto.EcAes;
import com.eduworks.ec.crypto.EcAesCtr;
import com.eduworks.ec.crypto.EcPk;
import com.eduworks.schema.ebac.EbacContact;

/**
 * A contact is an identity that we do not own. Using the public key we may: 1.
 * Send them information (by encrypting data with their public key) 2. Verify a
 * signed message that was sent (by using the verify function of the public key)
 * 3. Distinguish between this identity and other identities through the
 * displayName.
 * 
 * @module com.eduworks.ec
 * @class EcContact
 * @constructor
 *
 * @author fritz.ray@eduworks.com
 */
public class EcContact
{
	/**
	 * Public Key of the contact
	 * 
	 * @property pk
	 * @type EcPk
	 */
	public EcPk pk;
	
	/**
	 * Display Name of the contact
	 * 
	 * @property displayName
	 * @type String
	 */
	public String displayName;
	
	/**
	 * URL to the home server of the contact
	 * 
	 * @property source
	 * @type String
	 */
	public String source;

	/**
	 * Comparison method that checks if the key is the same as another EcContact
	 * 
	 * @memberOf EcContact
	 * @method equals
	 * @param {Object} obj
	 * 			Contact to compare if same key
	 * @return {boolean}
	 * 			true if the key is the same, false if not
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof EcContact)
			return pk.equals(((EcContact) obj).pk);
		return super.equals(obj);
	}

	/**
	 * Returns the URL to generic image that should be displayed for the contact
	 * 
	 * @memberOf EcContact
	 * @method getImageUrl
	 * @return {String}
	 * 			URL of generic image file
	 */
	public String getImageUrl()
	{
		return "https://upload.wikimedia.org/wikipedia/commons/thumb/1/12/User_icon_2.svg/48px-User_icon_2.svg.png";
	}
	
	/**
	 * Helper function to encrypt a contact into an encrypted contact (storable
	 * version of a contact)
	 * 
	 * @memberOf EcContact
	 * @method toEncryptedContact
	 * @param {String} secret
	 *           AES secret used to encrypt the contact.
	 * @return {EbacContact}
	 * 			Encrypted contact object.
	 */
	public EbacContact toEncryptedContact(String secret)
	{
		EbacContact c = new EbacContact();
		c.iv = EcAes.newIv(32);
		c.pk = EcAesCtr.encrypt(pk.toPem(), secret, c.iv);
		c.displayNameIv = EcAes.newIv(16);
		c.displayName = EcAesCtr.encrypt(displayName, secret, c.iv);
		c.sourceIv = EcAes.newIv(16);
		c.source = EcAesCtr.encrypt(source, secret, c.iv);
		return c;
	}
	
	/**
	 * Helper function to decrypt an encrypted contact (storable version of an contact)
	 * into an contact
	 * 
	 * @memberOf EcContact
	 * @method fromEncryptedContact
	 * @static
	 * @param {EbacContact} contact
	 *          Contact to decrypt.
	 * @param {String} secret
	 *          AES secret used to decrypt the credential.
	 * @param {String} source
	 *          Source of the credential, used to track where a contact
	 *          came from.
	 * @return {EcContact}
	 * 			Decrypted identity object, ready for use.
	 */
	public static EcContact fromEncryptedContact(EbacContact contact, String secret, String source)
	{
		EcContact i = new EcContact();
		i.pk = EcPk.fromPem(EcAesCtr.decrypt(contact.pk, secret, contact.iv));
		i.source = source;
		if (contact.displayName != null && contact.displayNameIv != null)
			i.displayName = EcAesCtr.decrypt(contact.displayName, secret, contact.iv);
		return i;
	}
}
