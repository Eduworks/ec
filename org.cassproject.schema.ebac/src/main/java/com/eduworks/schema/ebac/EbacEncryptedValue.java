package com.eduworks.schema.ebac;

import org.cassproject.schema.general.EcRemoteLinkedData;
import org.stjs.javascript.Array;

public class EbacEncryptedValue extends EcRemoteLinkedData
{
	public static final String type = "http://schema.eduworks.com/ebac/0.1/encryptedValue";
	
	public EbacEncryptedValue()
	{
		super(Ebac.schema, type);
	}

	public String encryptedType;
	public String payload;
	public Array<String> reader;
	public Array<String> secret;

}
