package org.schema;

/**
 * Schema.org/SportingGoodsStore
 * A sporting goods store.
 *
 * @author schema.org
 * @class SportingGoodsStore
 * @module org.schema
 * @extends Store
 */
public class SportingGoodsStore extends Store {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public SportingGoodsStore() {
		context = "http://schema.org/";
		type = "SportingGoodsStore";
	}

}