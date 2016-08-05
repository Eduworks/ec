package org.cassproject.schema.cass.competency;

import org.cassproject.schema.cass.Cass;
import org.schema.Thing;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;

/**
 * A composition of references to competencies, alignments, and levels that
 * embody a competency framework. It is reasonable safe to assume the maker of
 * this framework implicitly accepts all data referred to by this object.
 * 
 * @author fritz.ray@eduworks.com
 *
 */
public class Framework extends Thing
{
	private static final String TYPE_0_1 = "http://schema.eduworks.com/cass/0.1/framework";
	private static final String TYPE_0_2 = "http://schema.eduworks.com/cass/0.2/framework";
	public static final String myType = TYPE_0_2;

	public Framework()
	{
		setContextAndType(Cass.context,myType);
	}

	public Array<String> competency;
	public Array<String> relation;
	public Array<String> level;
	public Array<String> rollupRule;
	public Source source;

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
