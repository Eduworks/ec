package org.schema;

/**
 * Schema.org/SportsClub
 * A sports club.
 * @author schema.org
 * @class SportsClub
 * @module org.schema
 * @extends SportsActivityLocation
 */
public class SportsClub extends SportsActivityLocation
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public SportsClub()
	{
		context="http://schema.org/";
		type="SportsClub";
	}

}