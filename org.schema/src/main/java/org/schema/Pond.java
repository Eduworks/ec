package org.schema;

/**
 * Schema.org/Pond
 * A pond.
 *
 * @author schema.org
 * @class Pond
 * @module org.schema
 * @extends BodyOfWater
 */
public class Pond extends BodyOfWater {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Pond() {
		context = "http://schema.org/";
		type = "Pond";
	}

}