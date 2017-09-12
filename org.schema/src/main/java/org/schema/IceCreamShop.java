package org.schema;

/**
 * Schema.org/IceCreamShop
 * An ice cream shop.
 * @author schema.org
 * @class IceCreamShop
 * @module org.schema
 * @extends FoodEstablishment
 */
public class IceCreamShop extends FoodEstablishment
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public IceCreamShop()
	{
		context="http://schema.org/";
		type="IceCreamShop";
	}

}