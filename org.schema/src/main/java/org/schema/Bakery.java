package org.schema;

/**
 * Schema.org/Bakery
 * A bakery.
 *
 * @author schema.org
 * @class Bakery
 * @module org.schema
 * @extends FoodEstablishment
 */
public class Bakery extends FoodEstablishment {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Bakery() {
		context = "http://schema.org/";
		type = "Bakery";
	}

}