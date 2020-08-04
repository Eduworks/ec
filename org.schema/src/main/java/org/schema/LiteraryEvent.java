package org.schema;

/**
 * Schema.org/LiteraryEvent
 * SchemaEvent type: Literary event.
 *
 * @author schema.org
 * @class LiteraryEvent
 * @module org.schema
 * @extends SchemaEvent
 */
public class LiteraryEvent extends SchemaEvent {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public LiteraryEvent() {
		context = "http://schema.org/";
		type = "LiteraryEvent";
	}

}