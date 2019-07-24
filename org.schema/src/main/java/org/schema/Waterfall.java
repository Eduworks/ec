package org.schema;

/**
 * Schema.org/Waterfall
 * A waterfall, like Niagara.
 *
 * @author schema.org
 * @class Waterfall
 * @module org.schema
 * @extends BodyOfWater
 */
public class Waterfall extends BodyOfWater {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Waterfall() {
		context = "http://schema.org/";
		type = "Waterfall";
	}

}