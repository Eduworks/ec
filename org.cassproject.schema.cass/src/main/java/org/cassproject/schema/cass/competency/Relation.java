package org.cassproject.schema.cass.competency;

import org.cassproject.schema.cass.Cass;
import org.schema.Thing;

public class Relation extends Thing
{
	public static final String myType = "http://schema.eduworks.com/cass/0.2/relation";
	public static final String IS_ENABLED_BY = "isEnabledBy";
	public static final String REQUIRES="requires";
	public static final String DESIRES="desires";
	public static final String IS_RELATED_TO="isRelatedTo";
	public static final String IS_EQUIVALENT_TO="isEquivalenTo";
	
	public Relation()
	{
		context = Cass.context;
		type = myType;
	}
	public String source;
	public String target;
	public String relationType;
	public String validFrom;
	public String validThrough;
	public String agent;
}
