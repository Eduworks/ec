package org.schema;

/**
 * Schema.org/ShoeStore
 * A shoe store.
 *
 * @author schema.org
 * @class ShoeStore
 * @module org.schema
 * @extends Store
 */
public class ShoeStore extends Store {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ShoeStore() {
		context = "http://schema.org/";
		type = "ShoeStore";
	}

}