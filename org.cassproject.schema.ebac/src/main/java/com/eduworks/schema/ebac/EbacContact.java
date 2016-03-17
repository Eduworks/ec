package com.eduworks.schema.ebac;

import org.json.ld.EcLinkedData;

/**
 * AES encrypted public key and display name. Contains Initialization Vectors,
 * but not secrets. Used to encrypt public identities for storage on remote
 * systems.
 * 
 * @author fritz.ray@eduworks.com
 *
 */
public class EbacContact extends EcLinkedData
{
	public EbacContact()
	{
		super(Ebac.schema, "http://schema.eduworks.com/ebac/0.1/contact");
	}

	/**
	 * AES Initialization Vector used to decode PPK.
	 */
	public String iv;
	/**
	 * AES encrypted Private Key in PEM form.
	 */
	public String pk;
	/**
	 * AES Initialization Vector used to decode displayName.
	 */
	public String displayNameIv;
	/**
	 * AES encrypted display name for identity.
	 */
	public String displayName;
	
	public String sourceIv;
	public String source;
}
