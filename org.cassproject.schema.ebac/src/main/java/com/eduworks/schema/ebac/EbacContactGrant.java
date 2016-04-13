package com.eduworks.schema.ebac;

import org.cassproject.schema.general.EcRemoteLinkedData;
import org.json.ld.EcLinkedData;

/**
 * AES encrypted public key and display name. Contains Initialization Vectors,
 * but not secrets. Used to encrypt public identities for storage on remote
 * systems.
 * 
 * @author fritz.ray@eduworks.com
 *
 */
public class EbacContactGrant extends EcRemoteLinkedData
{
	public EbacContactGrant()
	{
		super(Ebac.schema, "http://schema.eduworks.com/ebac/0.1/contactGrant");
	}

	public String iv;
	public String pk;
	public String displayName;
	public String source;
	public String responseToken;
	public String responseSignature;
}
