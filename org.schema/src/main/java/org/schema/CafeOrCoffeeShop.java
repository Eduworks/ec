package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/CafeOrCoffeeShop
 * A cafe or coffee shop.
 * @author schema.org
 * @module schema.org
 * @class CafeOrCoffeeShop
 * @extends FoodEstablishment
 */
public class CafeOrCoffeeShop extends FoodEstablishment
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public CafeOrCoffeeShop()
	{
		context="http://schema.org/";
		type="CafeOrCoffeeShop";
	}

}