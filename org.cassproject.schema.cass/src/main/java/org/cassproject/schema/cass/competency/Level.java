package org.cassproject.schema.cass.competency;

import org.cassproject.schema.cass.Cass;
import org.schema.AlignmentObject;
import org.schema.Thing;
import org.stjs.javascript.Array;

public class Level extends Thing
{
	public static final String myType = "http://schema.eduworks.com/cass/0.2/level";
	public Level()
	{
		context = Cass.context;
		type = myType;
	}
	public String competency;
	public String title;
	public String performance;
}
