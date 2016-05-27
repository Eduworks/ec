package org.cassproject.schema.cass.profile;

import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.schema.cass.Cass;
import org.schema.Thing;
import org.stjs.javascript.Array;

public class Assertion extends Thing
{
	public static final String myType = "http://schema.eduworks.com/cass/0.2/assertion";
	public Assertion()
	{
		context = Cass.context;
		type = myType;
	}
	//URL of the competency.
	public String competency;
	//URL of the framework within which the assertion is restricted.
	public String framework;
	//URL of the level, or null if 'held'. This record will not exist for 'not held'.
	public String level;
	//PK of the recipient of the assertion. This is private.
	protected EcEncryptedValue subject;
	//PK of the person asserting the claim. This is private.
	protected EcEncryptedValue agent;
	//URLs to evidence. This is private.
	protected Array<EcEncryptedValue> evidence;
	//Confidence with which the assertion was made.
	public Double confidence;
	//Time in ms with which the assertion was made.
	protected EcEncryptedValue assertionDate;
	//Time in ms when the assertion expires. This is exposed to the search engine.
	protected EcEncryptedValue expirationDate;
	//
	protected EcEncryptedValue decayFunction;	
}
