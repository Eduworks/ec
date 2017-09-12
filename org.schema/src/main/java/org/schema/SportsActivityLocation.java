package org.schema;

/**
 * Schema.org/SportsActivityLocation
 * A sports location, such as a playing field.
 * @author schema.org
 * @class SportsActivityLocation
 * @module org.schema
 * @extends LocalBusiness
 */
public class SportsActivityLocation extends LocalBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public SportsActivityLocation()
	{
		context="http://schema.org/";
		type="SportsActivityLocation";
	}

}