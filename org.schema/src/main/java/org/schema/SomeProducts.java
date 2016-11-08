package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/SomeProducts
 * A placeholder for multiple similar products of the same kind.
 * @author schema.org
 * @class SomeProducts
 * @module org.schema
 * @extends Product
 */
public class SomeProducts extends Product
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public SomeProducts()
	{
		context="http://schema.org/";
		type="SomeProducts";
	}

	/**
	 * Schema.org/inventoryLevel
	 * The current approximate inventory level for the item or items.
	 * @property inventoryLevel
	 * @type QuantitativeValue
	 */
	public QuantitativeValue inventoryLevel;

}