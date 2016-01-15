package com.eduworks.schema.ebac;

import org.json.ld.EcLinkedData;

public class EbacEncryptedSecret extends EcLinkedData
{

	public EbacEncryptedSecret()
	{
		super(Ebac.schema, "http://schema.eduworks.com/ebac/0.1/encryptedSecret");
	}
	
	public String iv;
	public String id;
	public String secret;
	public String field;

}
