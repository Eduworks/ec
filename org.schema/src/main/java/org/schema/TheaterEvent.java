package org.schema;

/**
 * Schema.org/TheaterEvent
 * Event type: Theater performance.
 * @author schema.org
 * @class TheaterEvent
 * @module org.schema
 * @extends Event
 */
public class TheaterEvent extends Event
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public TheaterEvent()
	{
		context="http://schema.org/";
		type="TheaterEvent";
	}

}