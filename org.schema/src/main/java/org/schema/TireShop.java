package org.schema;

/**
 * Schema.org/TireShop
 * A tire shop.
 *
 * @author schema.org
 * @class TireShop
 * @module org.schema
 * @extends Store
 */
public class TireShop extends Store {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public TireShop() {
		context = "http://schema.org/";
		type = "TireShop";
	}

}