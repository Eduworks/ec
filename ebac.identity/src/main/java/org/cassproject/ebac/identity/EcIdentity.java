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
 * @author fray
 *
 */
public class EcIdentity
{
	public static int identityCounter = 1;
	public EcPpk ppk;
	public String displayName;
	public String source;

	public EcIdentity()
	{
		displayName = "Alias " + identityCounter++;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof EcIdentity)
			return ppk.equals(((EcIdentity) obj).ppk);
		return super.equals(obj);
	}

	/**
	 * Helper function to encrypt an identity into a credential (storable
	 * version of an identity)
	 * 
	 * @param secret
	 *            AES secret used to encrypt the credential.
	 * @return Encrypted credential object.
	 */
	public EbacCredential toCredential(String secret)
	{
		EbacCredential c = new EbacCredential();
		c.iv = EcAes.newIv(32);
		c.ppk = EcAesCtr.encrypt(ppk.toPem(), secret, c.iv);
		c.displayNameIv = EcAes.newIv(32);
		c.displayName = EcAesCtr.encrypt(displayName, secret, c.iv);
		return c;
	}

	/**
	 * Helper function to decrypt a credential (storable version of an identity)
	 * into an identity)
	 * 
	 * @param credential
	 *            Credential to decrypt.
	 * @param secret
	 *            AES secret used to decrypt the credential.
	 * @param source
	 *            Source of the credential, used to track where a credential
	 *            came from.
	 * @return Decrypted identity object, ready for use.
	 */
	public static EcIdentity fromCredential(EbacCredential credential, String secret, String source)
	{
		EcIdentity i = new EcIdentity();
		i.ppk = EcPpk.fromPem(EcAesCtr.decrypt(credential.ppk, secret, credential.iv));
		i.source = source;
		if (credential.displayName != null && credential.displayNameIv != null)
			i.displayName = EcAesCtr.decrypt(credential.displayName, secret, credential.iv);
		return i;
	}
	
	/**
	 * Converts an identity to a contact.
	 * @return Contact object.
	 */
	public EcContact toContact()
	{
		EcContact c = new EcContact();
		c.displayName = displayName;
		c.pk = ppk.toPk();
		c.source = source;
		return c;
	}
}
