package com.eduworks.ec.ebac.identity.remote;

import com.eduworks.ec.ld.EcLinkedData;

public class EbacCredentialRequest extends EcLinkedData
{
	public EbacCredentialRequest()
	{
		super(Ebac.schema, "http://schema.eduworks.com/ebac/0.1/credentialRequest");
	}

	public String username;
	public String password;	
}
