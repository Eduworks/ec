package org.schema;

/**
 * Schema.org/TheaterEvent
 * SchemaEvent type: Theater performance.
 *
 * @author schema.org
 * @class TheaterEvent
 * @module org.schema
 * @extends SchemaEvent
 */
public class TheaterEvent extends SchemaEvent {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public TheaterEvent() {
		context = "http://schema.org/";
		type = "TheaterEvent";
	}

}