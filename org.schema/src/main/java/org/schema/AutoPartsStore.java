package org.schema;

/**
 * Schema.org/AutoPartsStore
 * An auto parts store.
 *
 * @author schema.org
 * @class AutoPartsStore
 * @module org.schema
 * @extends Store
 */
public class AutoPartsStore extends Store {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public AutoPartsStore() {
		context = "http://schema.org/";
		type = "AutoPartsStore";
	}

}