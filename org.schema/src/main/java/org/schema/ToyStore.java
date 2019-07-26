package org.schema;

/**
 * Schema.org/ToyStore
 * A toy store.
 *
 * @author schema.org
 * @class ToyStore
 * @module org.schema
 * @extends Store
 */
public class ToyStore extends Store {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ToyStore() {
		context = "http://schema.org/";
		type = "ToyStore";
	}

}