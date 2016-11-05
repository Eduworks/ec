package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/TheaterEvent
 * Event type: Theater performance.
 * @author schema.org
 * @module schema.org
 * @class TheaterEvent
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