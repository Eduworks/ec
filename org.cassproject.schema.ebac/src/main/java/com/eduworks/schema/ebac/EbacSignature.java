package com.eduworks.schema.ebac;

import org.json.ld.EcLinkedData;

public class EbacSignature extends EcLinkedData
{
	public EbacSignature()
	{
		super(Ebac.schema,"http://schema.eduworks.com/ebac/0.1/timeLimitedSignature");
	}

	public String owner;
	public double expiry;
	public String signature;
	public String server;
	
}
