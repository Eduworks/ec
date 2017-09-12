package org.schema;

/**
 * Schema.org/ShoppingCenter
 * A shopping center or mall.
 *
 * @author schema.org
 * @class ShoppingCenter
 * @module org.schema
 * @extends LocalBusiness
 */
public class ShoppingCenter extends LocalBusiness {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ShoppingCenter() {
		context = "http://schema.org/";
		type = "ShoppingCenter";
	}

}