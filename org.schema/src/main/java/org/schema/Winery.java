package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Winery
 * A winery.
 * @author schema.org
 * @module schema.org
 * @class Winery
 * @extends FoodEstablishment
 */
public class Winery extends FoodEstablishment
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Winery()
	{
		context="http://schema.org/";
		type="Winery";
	}

}