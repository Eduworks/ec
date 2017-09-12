package org.schema;

/**
 * Schema.org/HardwareStore
 * A hardware store.
 *
 * @author schema.org
 * @class HardwareStore
 * @module org.schema
 * @extends Store
 */
public class HardwareStore extends Store {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public HardwareStore() {
		context = "http://schema.org/";
		type = "HardwareStore";
	}

}