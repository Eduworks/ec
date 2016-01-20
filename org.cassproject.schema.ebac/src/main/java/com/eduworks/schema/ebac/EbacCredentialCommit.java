package com.eduworks.schema.ebac;

import org.json.ld.EcLinkedData;
import org.stjs.javascript.Array;

public class EbacCredentialCommit extends EcLinkedData
{
	public EbacCredentialCommit()
	{
		super(Ebac.schema, "http://schema.eduworks.com/ebac/0.1/credentialCommit");
		credentials = new EbacCredentials();
	}

	public String username;
	public String password;
	public String token;
	public EbacCredentials credentials;
}
