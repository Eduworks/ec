package org.schema;

/**
 * Schema.org/ComedyEvent
 * SchemaEvent type: Comedy event.
 *
 * @author schema.org
 * @class ComedyEvent
 * @module org.schema
 * @extends SchemaEvent
 */
public class ComedyEvent extends SchemaEvent {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ComedyEvent() {
		context = "http://schema.org/";
		type = "ComedyEvent";
	}

}