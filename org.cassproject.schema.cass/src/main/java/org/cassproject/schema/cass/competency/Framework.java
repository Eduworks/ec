package org.cassproject.schema.cass.competency;

import org.cassproject.schema.cass.Cass;
import org.schema.CreativeWork;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;

/**
 * A Competency Framework or simply Framework is a collection of competencies and relations between competencies in the framework and potentially between competencies in the framework and competencies in other frameworks. In practice, a Framework represents competencies related to a specific job, task, organization, career, knowledge domain, etc.
 * 
 * @author fritz.ray@eduworks.com
 * @class Framework
 * @module org.cassproject
 * @extends CreativeWork
 */
public class Framework extends CreativeWork
{
	private static final String TYPE_0_1 = "http://schema.eduworks.com/cass/0.1/framework";
	private static final String TYPE_0_2 = "http://schema.eduworks.com/cass/0.2/framework";
	private static final String TYPE_0_3 = "http://schema.cassproject.org/0.2/Framework";
	private static final String TYPE_0_4 = "http://schema.cassproject.org/0.3/Framework";
	public static final String myType = TYPE_0_4;

	public Framework()
	{
		setContextAndType(Cass.context, myType);
	}

	/**
	 * URLs of competencies included in this framework.
	 * @property competency
	 * @type string[]
	 */
	public Array<String> competency;
	/**
	 * URLs of relations included in this framework.
	 * @property relation
	 * @type string[]
	 */
	public Array<String> relation;
	/**
	 * URLs of levels included in this framework.
	 * @property level
	 * @type string[]
	 */
	public Array<String> level;
	/**
	 * URLs of RollupRules included in this framework.
	 * @property rollupRule
	 * @type string[]
	 */
	public Array<String> rollupRule;

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
		if (TYPE_0_3.equals(getFullType()))
		{
			setContextAndType(Cass.context_0_4, TYPE_0_4);
		}
	}

	@Override
	public Array<String> getTypes()
	{
		Array<String> a = new Array<String>();
		a.push(TYPE_0_4);
		a.push(TYPE_0_3);
		a.push(TYPE_0_2);
		a.push(TYPE_0_1);
		return a;
	}
}
