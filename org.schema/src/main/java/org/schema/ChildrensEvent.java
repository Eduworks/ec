package org.schema;

/**
 * Schema.org/ChildrensEvent
 * SchemaEvent type: Children's event.
 *
 * @author schema.org
 * @class ChildrensEvent
 * @module org.schema
 * @extends SchemaEvent
 */
public class ChildrensEvent extends SchemaEvent {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ChildrensEvent() {
		context = "http://schema.org/";
		type = "ChildrensEvent";
	}

}