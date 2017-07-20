package org.cassproject.schema.cass.competency;

import org.cassproject.schema.cass.Cass;
import org.schema.CreativeWork;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;

/**
 * When an individual's performance in a competency can be measured, a level specifies milestones that an individual can reach, creating fine-grained distinction between the proficient and the adept.
 * @author fritz.ray@eduworks.com
 * @class Level
 * @module org.cassproject
 * @extends CreativeWork
 */
public class Level extends CreativeWork
{
	private static final String TYPE_0_1 = "http://schema.eduworks.com/cass/0.1/level";
	private static final String TYPE_0_2 = "http://schema.eduworks.com/cass/0.2/level";
	private static final String TYPE_0_3 = "http://schema.cassproject.org/0.2/Level";
	private static final String TYPE_0_4 = "http://schema.cassproject.org/0.3/Level";
	public static final String myType = TYPE_0_4;

	public Level()
	{
		setContextAndType(Cass.context, myType);
	}

	/**
	 * Specifies the URL of the competency this level relates to.
	 * @property competency
	 * @type string(URL) 
	 */
	public String competency;
	/**
	 * The title that one who holds this performance level may assume.
	 * @property title
	 * @type string
	 */
	public String title;
	/**
	 * The performance characteristics required by this level in text form.
	 * TBD: Isn't this what description represents?
	 * @property performance
	 * @type string
	 */
	public String performance;

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
