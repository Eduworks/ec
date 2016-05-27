package org.cassproject.schema.cass.profile;

import org.cassproject.schema.cass.Cass;
import org.schema.Thing;
import org.stjs.javascript.Array;

/**
 * A composition of references to assertions and acceptances that embody a
 * person's profile. It is reasonably safe to assume the maker of this framework
 * implicitly accepts all data referred to by this object.
 * 
 * @author fritz.ray@eduworks.com
 *
 */
public class Profile extends Thing
{
	public static final String myType = "http://schema.eduworks.com/cass/0.2/profile";
	public Profile()
	{
		context = Cass.context;
		type = myType;
	}
	String person;
	Array<String> assertion;
	Array<String> acceptance;
}
