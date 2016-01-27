package com.eduworks.schema.ebac;

import org.json.ld.EcLinkedData;
import org.stjs.javascript.Array;

/**
 * Credential list along with one time pad and session-based token for use in
 * commit actions.
 * 
 * @author fritz.ray@eduworks.com
 *
 */
public class EbacCredentials extends EcLinkedData
{
	public EbacCredentials()
	{
		super(Ebac.schema, "http://schema.eduworks.com/ebac/0.1/credentials");
	}

	/**
	 * One time pad (aka perfect cipher)
	 */
	public String pad;
	/**
	 * Token provided by server to use in commit actions.
	 */
	public String token;
	/**
	 * Credential array.
	 */
	public Array<EbacCredential> credentials;
}
