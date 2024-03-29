package org.schema;

/**
 * Schema.org/FastFoodRestaurant
 * A fast-food restaurant.
 *
 * @author schema.org
 * @class FastFoodRestaurant
 * @module org.schema
 * @extends FoodEstablishment
 */
public class FastFoodRestaurant extends FoodEstablishment {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public FastFoodRestaurant() {
		context = "http://schema.org/";
		type = "FastFoodRestaurant";
	}

}