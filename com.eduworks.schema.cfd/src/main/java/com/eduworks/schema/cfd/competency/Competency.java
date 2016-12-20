package com.eduworks.schema.cfd.competency;

import org.cassproject.schema.cass.competency.Competency;
import org.stjs.javascript.Array;
import org.stjs.javascript.JSObjectAdapter;
import org.stjs.javascript.Map;

/**
 * Competency is Under construction.
 * 
 * Working model of competency with CFD extensions.
 * Competencies include skills, knowledge, abilities, traits, and combinations thereof that are needed to perform a task or job. In CASS, competencies are identified and located using a globally unique ID. Competencies can be further described using titles, descriptions, levels, indicators (coming soon), roll-up rules, and relationships to other competencies.
 * 
 * @author debbie.brown@eduworks.com
 * @class Competency
 * @module com.eduworks
 * @extends org.cassproject.schema.cass.competency.Competency
 */
public class Competency extends org.cassproject.schema.cass.competency.Competency
{
	private static final String TYPE_0_1 = "http://schema.eduworks.com/cass/0.1/competency";
	private static final String TYPE_0_2 = "http://schema.eduworks.com/cass/0.2/competency";
	private static final String TYPE_0_3 = "http://schema.cassproject.org/0.2/Competency";
	private static final String TYPE_0_4 = "http://schema.eduworks.com/cfd/0.1/skill";
	private static final String TYPE_0_5 = "http://schema.eduworks.com/cfd/0.1/knowledge";
	private static final String TYPE_0_6 = "http://schema.eduworks.com/cfd/0.1/attitude";
	private static final String TYPE_0_7 = "http://schema.eduworks.com/cfd/0.1/belief";
	private static final String TYPE_0_8 = "http://schema.eduworks.com/cfd/0.1/assessment";
	public static final String myType = TYPE_0_3;

	public Competency()
	{
		setContextAndType(Cass.context,myType);
	}

	/**
	 * Scope in which the competency may be applied. e.g. Underwater.
	 * @property scope
	 * @type string
	 */
	public String scope;

	@Override
	protected void upgrade()
	{
		super.upgrade();
		if (TYPE_0_1.equals(type))
		{
			// url was erroneously used instead of sameAs
			if (url != null && sameAs == null)
			{
				sameAs = url;
				url = null;
			}
			Map<String, Object> me = JSObjectAdapter.$properties(this);
			// Error in older versions of LD objects: We used @schema instead of
			// @context. Whoops.
			if (me.$get("@context") == null && me.$get("@schema") != null)
				me.$put("@context", me.$get("@schema"));
			setContextAndType(Cass.context_0_2,TYPE_0_2);
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
		a.push(TYPE_0_8);
		a.push(TYPE_0_7);
		a.push(TYPE_0_6);
		a.push(TYPE_0_5);
		a.push(TYPE_0_4);
		a.push(TYPE_0_3);
		a.push(TYPE_0_2);
		a.push(TYPE_0_1);
		return a;
	}
}
