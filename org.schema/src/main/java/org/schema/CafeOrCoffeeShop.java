package org.schema;

/**
 * Schema.org/CafeOrCoffeeShop
 * A cafe or coffee shop.
 *
 * @author schema.org
 * @class CafeOrCoffeeShop
 * @module org.schema
 * @extends FoodEstablishment
 */
public class CafeOrCoffeeShop extends FoodEstablishment {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public CafeOrCoffeeShop() {
		context = "http://schema.org/";
		type = "CafeOrCoffeeShop";
	}

}