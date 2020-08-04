package org.schema;

/**
 * Schema.org/BusinessEvent
 * SchemaEvent type: Business event.
 *
 * @author schema.org
 * @class BusinessEvent
 * @module org.schema
 * @extends SchemaEvent
 */
public class BusinessEvent extends SchemaEvent {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public BusinessEvent() {
		context = "http://schema.org/";
		type = "BusinessEvent";
	}

}