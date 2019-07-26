package org.schema;

/**
 * Schema.org/JewelryStore
 * A jewelry store.
 *
 * @author schema.org
 * @class JewelryStore
 * @module org.schema
 * @extends Store
 */
public class JewelryStore extends Store {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public JewelryStore() {
		context = "http://schema.org/";
		type = "JewelryStore";
	}

}