package org.schema;

/**
 * Schema.org/Playground
 * A playground.
 *
 * @author schema.org
 * @class Playground
 * @module org.schema
 * @extends CivicStructure
 */
public class Playground extends CivicStructure {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Playground() {
		context = "http://schema.org/";
		type = "Playground";
	}

}