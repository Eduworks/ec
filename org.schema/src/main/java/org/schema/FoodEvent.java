package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/FoodEvent
 * Event type: Food event.
 * @author schema.org
 * @module schema.org
 * @class FoodEvent
 * @extends Event
 */
public class FoodEvent extends Event
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public FoodEvent()
	{
		context="http://schema.org/";
		type="FoodEvent";
	}

}