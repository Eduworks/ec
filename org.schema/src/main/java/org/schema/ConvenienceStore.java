package org.schema;

/**
 * Schema.org/ConvenienceStore
 * A convenience store.
 *
 * @author schema.org
 * @class ConvenienceStore
 * @module org.schema
 * @extends Store
 */
public class ConvenienceStore extends Store {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ConvenienceStore() {
		context = "http://schema.org/";
		type = "ConvenienceStore";
	}

}