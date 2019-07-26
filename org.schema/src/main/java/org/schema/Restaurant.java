package org.schema;

/**
 * Schema.org/Restaurant
 * A restaurant.
 *
 * @author schema.org
 * @class Restaurant
 * @module org.schema
 * @extends FoodEstablishment
 */
public class Restaurant extends FoodEstablishment {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Restaurant() {
		context = "http://schema.org/";
		type = "Restaurant";
	}

}