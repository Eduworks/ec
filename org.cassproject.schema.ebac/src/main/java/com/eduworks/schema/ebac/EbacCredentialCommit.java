package com.eduworks.schema.ebac;

import org.json.ld.EcLinkedData;

/**
 * Message used to commit credentials to a remote login server.
 * 
 * TODO: Semi-vulnerable to replay attacks. Token field prevents some replay
 * attacks.
 * 
 * @author fritz.ray@eduworks.com
 *
 */
public class EbacCredentialCommit extends EcLinkedData
{
	public EbacCredentialCommit()
	{
		super(Ebac.context, "http://schema.eduworks.com/ebac/0.1/credentialCommit");
		credentials = new EbacCredentials();
	}

	/**
	 * Hashed username.
	 */
	public String username;
	/**
	 * Hashed password to authorize commit.
	 */
	public String password;
	/**
	 * Token provided to client when previously executed Request was done. May
	 * be empty if this is used as part of Create action.
	 */
	public String token;
	/**
	 * List of credentials to commit to the login server storage.
	 */
	public EbacCredentials credentials;
}
