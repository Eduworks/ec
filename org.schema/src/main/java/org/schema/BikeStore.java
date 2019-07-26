package org.schema;

/**
 * Schema.org/BikeStore
 * A bike store.
 *
 * @author schema.org
 * @class BikeStore
 * @module org.schema
 * @extends Store
 */
public class BikeStore extends Store {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public BikeStore() {
		context = "http://schema.org/";
		type = "BikeStore";
	}

}