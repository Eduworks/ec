package org.cassproject.schema.cass.competency;

import org.cassproject.schema.cass.Cass;
import org.schema.CreativeWork;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;

/**
 * A relation between two objects.
 * @author fritz.ray@eduworks.com
 * @class Relation
 * @module org.cassproject
 * @extends CreativeWork
 *
 */
public class Relation extends CreativeWork
{
	private static final String TYPE_0_1 = "http://schema.eduworks.com/cass/0.1/relation";
	private static final String TYPE_0_2 = "http://schema.eduworks.com/cass/0.2/relation";
	private static final String TYPE_0_3 = "http://schema.cassproject.org/0.2/Relation";
	private static final String TYPE_0_4 = "http://schema.cassproject.org/0.3/Relation";
	public static final String myType = TYPE_0_4;
	/**
	 * Relation type when one object enables the capability to obtain another.
	 * Enabling relations do not imply a requirement, but makes the acquisition of the source much easier.
	 * @property IS_ENABLED_BY
	 * @static
	 * @type string
	 */
	public static final String IS_ENABLED_BY = "isEnabledBy";
	/**
	 * Relation type when one object requires another.
	 * Requiring relations are strict.
	 * @property REQUIRES
	 * @static
	 * @type string
	 */
	public static final String REQUIRES = "requires";
	/**
	 * Relation type when one object desires another.
	 * Desire relations improve the range of applicability or improve performance of the source.
	 * @property DESIRES
	 * @static
	 * @type string
	 */
	public static final String DESIRES = "desires";
	/**
	 * Relation type when one object is a subset of another.
	 * Narrows relations are strict, and represent a super/sub relation.
	 * @property NARROWS
	 * @static
	 * @type string
	 */
	public static final String NARROWS = "narrows";
	/**
	 * Relation type when one object is related to another.
	 * Related relations provide linkages that do not necessarily carry information.
	 * Related relations are bidirectional.
	 * @property IS_RELATED_TO
	 * @static
	 * @type string
	 */
	public static final String IS_RELATED_TO = "isRelatedTo";
	/**
	 * Relation type when one object is equivalent to another.
	 * Equivalent relations define two objects that are effectively equivalent.
	 * Equivalent relations are bidirectional.
	 * @property IS_RELATED_TO
	 * @static
	 * @type string
	 */
	public static final String IS_EQUIVALENT_TO = "isEquivalentTo";

	public Relation()
	{
		setContextAndType(Cass.context, myType);
	}

	/**
	 * URL of the object at the beginning of the relation.
	 * A <relation> B, this is A.
	 * @property source
	 * @type string(url)
	 */
	public String source;
	/**
	 * URL of the object at the end of the relation.
	 * A <relation> B, this is B.
	 * @property target
	 * @type string(url)
	 */
	public String target;
	/**
	 * URL or controlled vocabulary of the relation.
	 * A <relation> B, this is <relation>.
	 * @property relationType
	 * @type string | URL
	 */
	public String relationType;
	/**
	 * Date time in ISO 8601 format at which the relation may be observed.
	 * @property validFrom
	 * @type string
	 */
	public String validFrom;
	/**
	 * Date time in ISO 8601 format at which the relation may no longer be observed.
	 * @property validThrough
	 * @type string
	 */
	public String validThrough;

	@Override
	protected void upgrade()
	{
		super.upgrade();
		if ("isEquivalenTo".equals(relationType))
			relationType = IS_EQUIVALENT_TO;
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
