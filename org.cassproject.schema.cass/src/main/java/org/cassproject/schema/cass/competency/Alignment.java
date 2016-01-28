package org.cassproject.schema.cass.competency;

import org.cassproject.schema.cass.Cass;
import org.schema.Thing;

public class Alignment extends Thing
{
	public static final String myType = "http://schema.eduworks.com/cass/0.1/alignment";
	public Alignment()
	{
		schema = Cass.schema;
		type = myType;
	}
	public String source;
	public String destination;
	public String alignmentType;
}
