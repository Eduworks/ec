package com.eduworks.schema.ebac;

import org.stjs.javascript.Array;

public class EbacEncryptedValue extends EcRemoteLinkedData
{
	public EbacEncryptedValue()
	{
		super(Ebac.schema, "http://schema.eduworks.com/ebac/0.1/encryptedValue");
	}

	public String encryptedType;
	public String payload;
	public Array<String> reader;
	public Array<String> secret;

}
