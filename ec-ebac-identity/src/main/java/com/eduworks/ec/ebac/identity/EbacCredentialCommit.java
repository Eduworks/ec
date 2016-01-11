package com.eduworks.ec.ebac.identity;

import org.stjs.javascript.Array;

import com.eduworks.ec.ld.EcLinkedData;

public class EbacCredentialCommit extends EcLinkedData
{
	public EbacCredentialCommit()
	{
		super(Ebac.schema, "http://schema.eduworks.com/ebac/0.1/credentialCommit");
	}

	public String username;
	public String password;
	public String token;
	public Array<EbacCredential> credentials;
}
