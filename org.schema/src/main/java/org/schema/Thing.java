package org.schema;

import org.json.ld.EcLinkedData;
import org.stjs.javascript.annotation.Namespace;

@Namespace("org.schema")
public class Thing extends EcLinkedData
{
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
