package com.eduworks.schema.cfd.competency;

import org.cassproject.schema.cass.Cass;
import org.cassproject.schema.cass.competency.Competency;
import org.stjs.javascript.Array;

/**
 * Competency is Under construction.
 * 
 * Working model of competency with CFD Attitude extension.
 * 
 * @author debbie.brown@eduworks.com
 * @author devlin.junker@eduworks.com
 * @class Attitude
 * @module com.eduworks
 * @extends org.cassproject.schema.cass.competency.Competency
 */
public class Attitude extends org.cassproject.schema.cass.competency.Competency
{
	private static final String TYPE_0_1 = "http://schema.cassproject.org/0.2/Competency";

	public static final String myType = TYPE_0_1;

	public Attitude()
	{
		setContextAndType(Cass.context,TYPE_0_1);
	}
	
	/**
	 * Sub-type of Competency that this is (Will be replaced later)
	 * @property subtype
	 * @type string
	 */
	public static String _subtype = "Attitude"; 
	public String subtype = Attitude._subtype;

	@Override
	protected void upgrade()
	{
		super.upgrade();
	}

	@Override
	public Array<String> getTypes()
	{
		Array<String> a = new Array<String>();
		a.push(TYPE_0_1);
		return a;
	}
}
