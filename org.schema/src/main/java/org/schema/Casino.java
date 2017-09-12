package org.schema;

/**
 * Schema.org/Casino
 * A casino.
 * @author schema.org
 * @class Casino
 * @module org.schema
 * @extends EntertainmentBusiness
 */
public class Casino extends EntertainmentBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Casino()
	{
		context="http://schema.org/";
		type="Casino";
	}

}