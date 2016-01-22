package org.cassproject.schema.cass.competency;

import org.cassproject.schema.cass.Cass;
import org.schema.Thing;
import org.stjs.javascript.Array;

public class Framework extends Thing
{
	public Framework()
	{
		schema = Cass.schema;
		type = "http://schema.eduworks.com/cass/0.1/framework";
	}
	public Array<CompetencyReference> competency;
}
