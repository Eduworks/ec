package org.cassproject.schema.cass.competency;

import org.cassproject.schema.cass.Cass;
import org.schema.EntryPoint;
import org.schema.Thing;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;

public class Source extends Thing
{
	private static final String TYPE_0_1 = "http://schema.eduworks.com/cass/0.1/source";
	private static final String TYPE_0_2 = "http://schema.eduworks.com/cass/0.2/source";
	private static final String TYPE_0_3 = "http://schema.cassproject.org/0.2/Source";
	public static final String myType = TYPE_0_3;

	public Source()
	{
		setContextAndType(Cass.context, myType);
	}

	public EntryPoint target;

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
