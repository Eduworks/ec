package org.schema;

/**
 * Schema.org/Sculpture
 * A piece of sculpture.
 *
 * @author schema.org
 * @class Sculpture
 * @module org.schema
 * @extends CreativeWork
 */
public class Sculpture extends CreativeWork {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Sculpture() {
		context = "http://schema.org/";
		type = "Sculpture";
	}

}