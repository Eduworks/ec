package org.schema;

/**
 * Schema.org/MobilePhoneStore
 * A store that sells mobile phones and related accessories.
 *
 * @author schema.org
 * @class MobilePhoneStore
 * @module org.schema
 * @extends Store
 */
public class MobilePhoneStore extends Store {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public MobilePhoneStore() {
		context = "http://schema.org/";
		type = "MobilePhoneStore";
	}

}