package com.eduworks.ec.ebac.repository;

import com.eduworks.ec.ebac.identity.remote.Ebac;
import com.eduworks.ec.ld.EcLinkedData;

public class EcEncryptedSecret extends EcLinkedData
{

	public EcEncryptedSecret()
	{
		super(Ebac.schema, "http://schema.eduworks.com/ebac/0.1/encryptedSecret");
	}
	
	public String iv;
	public String id;
	public String secret;
	public String field;

}
