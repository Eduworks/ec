package org.schema;

/**
 * Schema.org/FoodEvent
 * Event type: Food event.
 *
 * @author schema.org
 * @class FoodEvent
 * @module org.schema
 * @extends Event
 */
public class FoodEvent extends Event {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public FoodEvent() {
		context = "http://schema.org/";
		type = "FoodEvent";
	}

}