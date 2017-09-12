package org.schema;

/**
 * Schema.org/BowlingAlley
 * A bowling alley.
 * @author schema.org
 * @class BowlingAlley
 * @module org.schema
 * @extends SportsActivityLocation
 */
public class BowlingAlley extends SportsActivityLocation
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public BowlingAlley()
	{
		context="http://schema.org/";
		type="BowlingAlley";
	}

}