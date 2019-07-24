package org.schema;

/**
 * Schema.org/Florist
 * A florist.
 *
 * @author schema.org
 * @class Florist
 * @module org.schema
 * @extends Store
 */
public class Florist extends Store {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Florist() {
		context = "http://schema.org/";
		type = "Florist";
	}

}