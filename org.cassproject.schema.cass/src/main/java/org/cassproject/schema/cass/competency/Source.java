package org.cassproject.schema.cass.competency;

import org.cassproject.schema.cass.Cass;
import org.schema.EntryPoint;
import org.schema.Thing;

public class Source extends Thing
{
	public static final String myType = "http://schema.eduworks.com/cass/0.1/source";
	public Source()
	{
		context = Cass.context;
		type = myType;
	}
	public EntryPoint target;
}
