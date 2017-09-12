package org.schema;

/**
 * Schema.org/GolfCourse
 * A golf course.
 * @author schema.org
 * @class GolfCourse
 * @module org.schema
 * @extends SportsActivityLocation
 */
public class GolfCourse extends SportsActivityLocation
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public GolfCourse()
	{
		context="http://schema.org/";
		type="GolfCourse";
	}

}