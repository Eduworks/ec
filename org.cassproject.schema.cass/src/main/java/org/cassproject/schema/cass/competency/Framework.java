package org.cassproject.schema.cass.competency;

import org.cassproject.schema.cass.Cass;
import org.schema.Thing;
import org.stjs.javascript.Array;

/**
 * A composition of references to competencies, alignments, and levels that
 * embody a competency framework. It is reasonable safe to assume the maker of
 * this framework implicitly accepts all data referred to by this object.
 * 
 * @author fritz.ray@eduworks.com
 *
 */
public class Framework extends Thing
{
	public static final String myType = "http://schema.eduworks.com/cass/0.1/framework";
	public Framework()
	{
		schema = Cass.schema;
		type = myType;
	}
	public Array<String> competency;
	public Array<String> alignment;
	public Array<String> level;
}
