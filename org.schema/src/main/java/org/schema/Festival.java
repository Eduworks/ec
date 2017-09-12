package org.schema;

/**
 * Schema.org/Festival
 * Event type: Festival.
 *
 * @author schema.org
 * @class Festival
 * @module org.schema
 * @extends Event
 */
public class Festival extends Event {
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