package org.cassproject.schema.cass.competency;

import org.cassproject.schema.cass.Cass;
import org.schema.AlignmentObject;
import org.schema.Thing;
import org.stjs.javascript.Array;

public class Level extends Thing
{
	public Level()
	{
		schema = Cass.schema;
		type = "http://schema.eduworks.com/cass/0.1/level";
	}
	public Array<AlignmentObject> relation;
	public String performance;
}
