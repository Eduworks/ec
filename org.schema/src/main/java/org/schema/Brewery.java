package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Brewery
 * Brewery.
 * @author schema.org
 * @class Brewery
 * @module org.schema
 * @extends FoodEstablishment
 */
public class Brewery extends FoodEstablishment
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Brewery()
	{
		context="http://schema.org/";
		type="Brewery";
	}

}