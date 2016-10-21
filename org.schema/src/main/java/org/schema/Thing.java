package org.schema;

import org.cassproject.schema.general.EcRemoteLinkedData;

public class Thing extends EcRemoteLinkedData
{
	public static String newThing()
	{
		return new Thing().toJson();
	}

	protected Thing()
	{
		super("http://schema.org/", "Thing");
	}

	public String name;
	public String description;
	public String alternateName;

	public String url;
	public String sameAs;
	public Object mainEntityOfPage;
	public Object image;
	public String additionalType;
}
