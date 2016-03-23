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
	//URL of the competency.
	String competency;
	//URL of the level, or null if 'held'. This record will not exist for 'not held'.
	String level;
	//PK of the recipient of the assertion. This is private.
	String subject;
	//PK of the person asserting the claim. This is private.
	String agent;
	//URLs to evidence. This is private.
	Array<String> evidence;
	//Confidence with which the assertion was made.
	Double confidence;
	//Time in ms with which the assertion was made.
	Long assertionDate;
	//Time in ms when the assertion expires. This is exposed to the search engine.
	Long expirationDate;
	//
	String decayFunction;	
}
