package org.schema;

/**
 * Schema.org/Library
 * A library.
 *
 * @author schema.org
 * @class Library
 * @module org.schema
 * @extends LocalBusiness
 */
public class Library extends LocalBusiness {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Library() {
		context = "http://schema.org/";
		type = "Library";
	}

}