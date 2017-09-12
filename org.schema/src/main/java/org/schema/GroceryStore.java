package org.schema;

/**
 * Schema.org/GroceryStore
 * A grocery store.
 * @author schema.org
 * @class GroceryStore
 * @module org.schema
 * @extends Store
 */
public class GroceryStore extends Store
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public GroceryStore()
	{
		context="http://schema.org/";
		type="GroceryStore";
	}

}