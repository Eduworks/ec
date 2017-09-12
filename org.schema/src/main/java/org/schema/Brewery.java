package org.schema;

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