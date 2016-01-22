package org.schema;

public class AlignmentObject extends Thing
{
	protected AlignmentObject()
	{
		schema = "http://schema.org/";
		type = "http://schema.org/Thing";
	}
	public String alignmentType;
	public String educationalFramework;
	public String targetDescription;
	public String targetName;
	public String targetUrl;
}
