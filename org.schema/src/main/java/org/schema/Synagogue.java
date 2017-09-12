package org.schema;

/**
 * Schema.org/Synagogue
 * A synagogue.
 *
 * @author schema.org
 * @class Synagogue
 * @module org.schema
 * @extends PlaceOfWorship
 */
public class Synagogue extends PlaceOfWorship {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Synagogue() {
		context = "http://schema.org/";
		type = "Synagogue";
	}

}