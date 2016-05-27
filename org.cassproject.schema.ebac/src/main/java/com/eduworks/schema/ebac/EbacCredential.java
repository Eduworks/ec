package com.eduworks.schema.ebac;

import org.json.ld.EcLinkedData;

/**
 * AES encrypted private key and display name. Contains Initialization Vectors,
 * but not secrets. Used to encrypt private identities for storage on remote
 * systems.
 * 
 * @author fritz.ray@eduworks.com
 *
 */
public class EbacCredential extends EcLinkedData
{
	public EbacCredential()
	{
		super(Ebac.context, "http://schema.eduworks.com/ebac/0.2/credential");
	}

	/**
	 * AES Initialization Vector used to decode PPK.
	 */
	public String iv;
	/**
	 * AES encrypted Private Key in PEM form.
	 */
	public String ppk;
	/**
	 * AES Initialization Vector used to decode displayName.
	 */
	public String displayNameIv;
	/**
	 * AES encrypted display name for identity.
	 */
	public String displayName;
}
