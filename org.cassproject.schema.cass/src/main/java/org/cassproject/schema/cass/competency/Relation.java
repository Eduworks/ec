package org.cassproject.schema.cass.competency;

import org.cassproject.schema.cass.Cass;
import org.schema.Thing;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;

public class Relation extends Thing
{
	private static final String TYPE_0_1 = "http://schema.eduworks.com/cass/0.1/relation";
	private static final String TYPE_0_2 = "http://schema.eduworks.com/cass/0.2/relation";
	public static final String myType = TYPE_0_2;
	public static final String IS_ENABLED_BY = "isEnabledBy";
	public static final String REQUIRES = "requires";
	public static final String DESIRES = "desires";
	public static final String NARROWS = "narrows";
	public static final String IS_RELATED_TO = "isRelatedTo";
	public static final String IS_EQUIVALENT_TO = "isEquivalenTo";

	public Relation()
	{
		setContextAndType(Cass.context,myType);
	}

	public String source;
	public String target;
	public String relationType;
	public String validFrom;
	public String validThrough;
	public String agent;

	@Override
	protected void upgrade()
	{
		super.upgrade();
		if (type.equals(TYPE_0_1))
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
