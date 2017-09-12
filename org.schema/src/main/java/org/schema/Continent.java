package org.schema;

/**
 * Schema.org/Continent
 * One of the continents (for example, Europe or Africa).
 *
 * @author schema.org
 * @class Continent
 * @module org.schema
 * @extends Landform
 */
public class Continent extends Landform {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Continent() {
		context = "http://schema.org/";
		type = "Continent";
	}

}