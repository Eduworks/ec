package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Restaurant
 * A restaurant.
 * @author schema.org
 * @module schema.org
 * @class Restaurant
 * @extends FoodEstablishment
 */
public class Restaurant extends FoodEstablishment
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Restaurant()
	{
		context="http://schema.org/";
		type="Restaurant";
	}

}