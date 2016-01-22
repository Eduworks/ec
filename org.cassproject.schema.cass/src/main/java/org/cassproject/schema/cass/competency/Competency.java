package org.cassproject.schema.cass.competency;

import org.cassproject.schema.cass.Cass;
import org.schema.AlignmentObject;
import org.schema.Thing;
import org.stjs.javascript.Array;

public class Competency extends Thing
{
	public static final String myType = "http://schema.eduworks.com/cass/0.1/competency";
	public Competency()
	{
		schema = Cass.schema;
		type = myType;
	}
	public Array<Level> level;
	public String scope;
	public Array<AlignmentObject> relation;
}
