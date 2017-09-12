package org.schema;

/**
 * Schema.org/OutletStore
 * An outlet store.
 *
 * @author schema.org
 * @class OutletStore
 * @module org.schema
 * @extends Store
 */
public class OutletStore extends Store {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public OutletStore() {
		context = "http://schema.org/";
		type = "OutletStore";
	}

}