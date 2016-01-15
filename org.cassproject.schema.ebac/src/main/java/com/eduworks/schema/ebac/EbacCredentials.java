package com.eduworks.schema.ebac;

import org.json.ld.EcLinkedData;
import org.stjs.javascript.Array;

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
