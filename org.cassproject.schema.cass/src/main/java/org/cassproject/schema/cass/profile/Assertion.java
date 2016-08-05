package org.cassproject.schema.cass.profile;

import org.cassproject.ebac.repository.EcEncryptedValue;
import org.cassproject.schema.cass.Cass;
import org.schema.Thing;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;

public class Assertion extends Thing
{
	private static final String TYPE_0_1 = "http://schema.eduworks.com/cass/0.1/assertion";
	private static final String TYPE_0_2 = "http://schema.eduworks.com/cass/0.2/assertion";
	public static final String myType = TYPE_0_2;

	public Assertion()
	{
		setContextAndType(Cass.context,myType);
	}

	// URL of the competency.
	public String competency;
	// URL of the framework within which the assertion is restricted.
	public String framework;
	// URL of the level, or null if 'held'. This record will not exist for 'not
	// held'.
	public String level;
	// PK of the recipient of the assertion. This is private.
	protected EcEncryptedValue subject;
	// PK of the person asserting the claim. This is private.
	protected EcEncryptedValue agent;
	// URLs to evidence. This is private.
	protected Array<EcEncryptedValue> evidence;
	// Confidence with which the assertion was made.
	public Double confidence;
	// Time in ms with which the assertion was made.
	protected EcEncryptedValue assertionDate;
	// Time in ms when the assertion expires. This is exposed to the search
	// engine.
	protected EcEncryptedValue expirationDate;
	//
	protected EcEncryptedValue decayFunction;
	
	protected EcEncryptedValue negative;

	@Override
	protected void upgrade()
	{
		super.upgrade();
		if (TYPE_0_1.equals(type))
		{
			Map<String, Object> me = JSObjectAdapter.$properties(this);
			// Error in older versions of LD objects: We used @schema instead of
			// @context. Whoops.
			if (me.$get("@context") == null && me.$get("@schema") != null)
				me.$put("@context", me.$get("@schema"));
			setContextAndType(Cass.context_0_2,TYPE_0_2);
		}
	}

	@Override
	public Array<String> getTypes()
	{
		Array<String> a = new Array<String>();
		a.push(TYPE_0_2);
		a.push(TYPE_0_1);
		return a;
	}
}
