package org.schema;

/**
 * Schema.org/Festival
 * SchemaEvent type: Festival.
 *
 * @author schema.org
 * @class Festival
 * @module org.schema
 * @extends SchemaEvent
 */
public class Festival extends SchemaEvent {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Festival() {
		context = "http://schema.org/";
		type = "Festival";
	}

}