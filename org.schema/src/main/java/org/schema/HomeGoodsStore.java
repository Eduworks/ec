package org.schema;

/**
 * Schema.org/HomeGoodsStore
 * A home goods store.
 * @author schema.org
 * @class HomeGoodsStore
 * @module org.schema
 * @extends Store
 */
public class HomeGoodsStore extends Store
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public HomeGoodsStore()
	{
		context="http://schema.org/";
		type="HomeGoodsStore";
	}

}