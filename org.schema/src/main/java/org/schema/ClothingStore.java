package org.schema;

/**
 * Schema.org/ClothingStore
 * A clothing store.
 * @author schema.org
 * @class ClothingStore
 * @module org.schema
 * @extends Store
 */
public class ClothingStore extends Store
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ClothingStore()
	{
		context="http://schema.org/";
		type="ClothingStore";
	}

}