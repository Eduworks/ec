package com.eduworks.schema.ebac;

import org.json.ld.EcLinkedData;

public class EbacCredential extends EcLinkedData
{
	public EbacCredential()
	{
		super(Ebac.schema, "http://schema.eduworks.com/ebac/0.1/credential");
	}

	public String iv;
	public String ppk;
}
