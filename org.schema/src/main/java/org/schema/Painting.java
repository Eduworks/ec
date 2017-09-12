package org.schema;

/**
 * Schema.org/Painting
 * A painting.
 *
 * @author schema.org
 * @class Painting
 * @module org.schema
 * @extends CreativeWork
 */
public class Painting extends CreativeWork {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Painting() {
		context = "http://schema.org/";
		type = "Painting";
	}

}