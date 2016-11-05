package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/IceCreamShop
 * An ice cream shop.
 * @author schema.org
 * @module schema.org
 * @class IceCreamShop
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