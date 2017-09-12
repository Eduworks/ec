package org.schema;

/**
 * Schema.org/Church
 * A church.
 *
 * @author schema.org
 * @class Church
 * @module org.schema
 * @extends PlaceOfWorship
 */
public class Church extends PlaceOfWorship {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Church() {
		context = "http://schema.org/";
		type = "Church";
	}

}