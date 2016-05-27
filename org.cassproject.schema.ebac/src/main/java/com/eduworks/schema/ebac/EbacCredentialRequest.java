package com.eduworks.schema.ebac;

import org.json.ld.EcLinkedData;

/**
 * Message used to retrieve credentials from a remote system.
 * 
 * TODO: Vulnerable to replay attacks.
 * 
 * @author fritz.ray@eduworks.com
 *
 */
public class EbacCredentialRequest extends EcLinkedData
{
	public EbacCredentialRequest()
	{
		super(Ebac.context, "http://schema.eduworks.com/ebac/0.2/credentialRequest");
	}

	/**
	 * Hashed username.
	 */
	public String username;
	/**
	 * Hashed password to authorize request.
	 */
	public String password;
}
