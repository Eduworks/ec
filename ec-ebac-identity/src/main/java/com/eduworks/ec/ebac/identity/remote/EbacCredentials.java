package com.eduworks.ec.ebac.identity.remote;

import org.stjs.javascript.Array;

import com.eduworks.ec.ld.EcLinkedData;

public class EbacCredentials extends EcLinkedData
{
	public EbacCredentials()
	{
		super(Ebac.schema, "http://schema.eduworks.com/ebac/0.1/credentials");
	}

	public String pad;
	public String token;
	public Array<EbacCredential> credentials;
}
