package org.schema;

/**
 * Schema.org/ComedyClub
 * A comedy club.
 * @author schema.org
 * @class ComedyClub
 * @module org.schema
 * @extends EntertainmentBusiness
 */
public class ComedyClub extends EntertainmentBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ComedyClub()
	{
		context="http://schema.org/";
		type="ComedyClub";
	}

}