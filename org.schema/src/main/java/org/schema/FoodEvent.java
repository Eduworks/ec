package org.schema;

/**
 * Schema.org/FoodEvent
 * SchemaEvent type: Food event.
 *
 * @author schema.org
 * @class FoodEvent
 * @module org.schema
 * @extends SchemaEvent
 */
public class FoodEvent extends SchemaEvent {
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