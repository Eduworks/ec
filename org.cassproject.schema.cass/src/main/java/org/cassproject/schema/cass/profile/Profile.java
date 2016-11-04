package org.cassproject.schema.cass.profile;

import org.cassproject.schema.cass.Cass;
import org.schema.Thing;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;

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
	private static final String TYPE_0_1 = "http://schema.eduworks.com/cass/0.1/profile";
	private static final String TYPE_0_2 = "http://schema.eduworks.com/cass/0.2/profile";
	private static final String TYPE_0_3 = "http://schema.cassproject.org/0.2/Profile";
	public static final String myType = TYPE_0_3;

	public Profile()
	{
		setContextAndType(Cass.context, myType);
	}

	String person;
	Array<String> assertion;
	Array<String> acceptance;

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
			setContextAndType(Cass.context_0_2, TYPE_0_2);
		}
		if (TYPE_0_2.equals(getFullType()))
		{
			setContextAndType(Cass.context_0_3, TYPE_0_3);
		}
	}

	@Override
	public Array<String> getTypes()
	{
		Array<String> a = new Array<String>();
		a.push(TYPE_0_3);
		a.push(TYPE_0_2);
		a.push(TYPE_0_1);
		return a;
	}
}
