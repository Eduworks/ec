package org.cassproject.schema.cass.profile;

import org.cassproject.schema.cass.Cass;
import org.schema.Thing;
import org.stjs.javascript.Array;

public class Assertion extends Thing
{
	public static final String myType = "http://schema.eduworks.com/cass/0.1/assertion";
	public Assertion()
	{
		schema = Cass.schema;
		type = myType;
	}
	String competency;
	String level;
	String subject;
	String agent;
	Array<String> evidence;
	Double confidence;
	String assertionDate;
	String expirationDate;
	String decayFunction;	
}
