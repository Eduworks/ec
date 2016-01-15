package com.eduworks.schema.ebac;

import org.json.ld.EcLinkedData;

public class EbacCredentialRequest extends EcLinkedData
{
	public EbacCredentialRequest()
	{
		super(Ebac.schema, "http://schema.eduworks.com/ebac/0.1/credentialRequest");
	}

	public String username;
	public String password;	
}
