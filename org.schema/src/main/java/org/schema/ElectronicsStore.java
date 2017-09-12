package org.schema;

/**
 * Schema.org/ElectronicsStore
 * An electronics store.
 *
 * @author schema.org
 * @class ElectronicsStore
 * @module org.schema
 * @extends Store
 */
public class ElectronicsStore extends Store {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ElectronicsStore() {
		context = "http://schema.org/";
		type = "ElectronicsStore";
	}

}