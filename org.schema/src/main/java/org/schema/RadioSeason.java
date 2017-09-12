package org.schema;

/**
 * Schema.org/RadioSeason
 * Season dedicated to radio broadcast and associated online delivery.
 * @author schema.org
 * @class RadioSeason
 * @module org.schema
 * @extends CreativeWorkSeason
 */
public class RadioSeason extends CreativeWorkSeason
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public RadioSeason()
	{
		context="http://schema.org/";
		type="RadioSeason";
	}

}