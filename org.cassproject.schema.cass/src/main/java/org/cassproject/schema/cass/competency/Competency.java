package org.cassproject.schema.cass.competency;

import org.cassproject.schema.cass.Cass;
import org.schema.AlignmentObject;
import org.schema.Thing;
import org.stjs.javascript.Array;

/**
 * Under construction.
 * 
 * Working model of a CASS competency.
 * @author fritz.ray@eduworks.com
 */
public class Competency extends Thing
{
	public static final String myType = "http://schema.eduworks.com/cass/0.2/competency";
	public Competency()
	{
		context = Cass.context;
		type = myType;
	}
	public String scope;
}
