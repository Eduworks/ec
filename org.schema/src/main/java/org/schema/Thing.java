package org.schema;

import org.cassproject.schema.general.EcRemoteLinkedData;

public class Thing extends EcRemoteLinkedData
{
	public static String newThing(){
		return new Thing().toJson();
	}
	protected Thing()
	{
		super("http://schema.org/", "http://schema.org/Thing");
	}
	String name;
	String description;
	String alternateName;
	
	String url;
	String sameAs;
	Object mainEntityOfPage;
	Object image;
	String additionalType;
}
