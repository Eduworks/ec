package org.cassproject.ebac.identity;

import com.eduworks.ec.crypto.EcAes;
import com.eduworks.ec.crypto.EcAesCtr;
import com.eduworks.ec.crypto.EcPpk;
import com.eduworks.schema.ebac.EbacCredential;

/**
 * An identity is an alias that a person or system may own. It consists of a
 * private key and a display name. Using the private key we may: 1. Perform all
 * operations of a EcContact. 2. Decrypt messages using our private key. 3. Sign
 * messages, ensuring the recipient knows that we sent the message and it was
 * not altered.
 *
 * @author fritz.ray@eduworks.com
 * @module com.eduworks.ec
 * @class EcIdentity
 * @constructor
 */
public class EcIdentity {
	private static int identityCounter = 1;

	/**
	 * Private Key of this identity
	 *
	 * @property ppk
	 * @type EcPpk
	 */
	public EcPpk ppk;

	/**
	 * Display name of this identity
	 *
	 * @property displayName
	 * @type String
	 */
	public String displayName;

	/**
	 * String identifying where this identity came from
	 *
	 * @property displayName
	 * @type String
	 */
	public String source;

	public EcIdentity() {
		displayName = "Alias " + identityCounter++;
	}

	/**
	 * Helper function to decrypt a credential (storable version of an identity)
	 * into an identity)
	 *
	 * @param {EbacCredential} credential
	 *                         Credential to decrypt.
	 * @param {String}         secret
	 *                         AES secret used to decrypt the credential.
	 * @param {String}         source
	 *                         Source of the credential, used to track where a credential
	 *                         came from.
	 * @return {EcIdentity}
	 * Decrypted identity object, ready for use.
	 * @memberOf EcIdentity
	 * @method fromCredential
	 * @static
	 */
	public static EcIdentity fromCredential(EbacCredential credential, String secret, String source) {
		EcIdentity i = new EcIdentity();
		i.ppk = EcPpk.fromPem(EcAesCtr.decrypt(credential.ppk, secret, credential.iv));
		i.source = source;
		if (credential.displayName != null && credential.displayNameIv != null)
			i.displayName = EcAesCtr.decrypt(credential.displayName, secret, credential.iv);
		return i;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof EcIdentity) {
			if (ppk == null)
				return false;
			if (((EcIdentity) obj).ppk == null)
				return false;
			return ppk.toPem().equals(((EcIdentity) obj).ppk.toPem());
		}
		return super.equals(obj);
	}

	/**
	 * Helper function to encrypt an identity into a credential (storable
	 * version of an identity)
	 *
	 * @param {String} secret
	 *                 AES secret used to encrypt the credential.
	 * @return {EbacCredential}
	 * Encrypted credential object.
	 * @memberOf EcIdentity
	 * @method toCredential
	 */
	public EbacCredential toCredential(String secret) {
		EbacCredential c = new EbacCredential();
		c.iv = EcAes.newIv(16);
		c.ppk = EcAesCtr.encrypt(ppk.toPem(), secret, c.iv);
		c.displayNameIv = EcAes.newIv(16);
		c.displayName = EcAesCtr.encrypt(displayName, secret, c.iv);
		return c;
	}

	/**
	 * Converts an identity to a contact.
	 *
	 * @return {EcContact}
	 * Contact object.
	 * @memberOf EcIdentity
	 * @method toContact
	 */
	public EcContact toContact() {
		EcContact c = new EcContact();
		c.displayName = displayName;
		c.pk = ppk.toPk();
		c.source = source;
		return c;
	}
}
