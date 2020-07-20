package org.schema;

/**
 * Schema.org/DanceEvent
 * SchemaEvent type: A social dance.
 *
 * @author schema.org
 * @class DanceEvent
 * @module org.schema
 * @extends SchemaEvent
 */
public class DanceEvent extends SchemaEvent {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public DanceEvent() {
		context = "http://schema.org/";
		type = "DanceEvent";
	}

}