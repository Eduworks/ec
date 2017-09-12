package org.schema;

/**
 * Schema.org/Country
 * A country.
 *
 * @author schema.org
 * @class Country
 * @module org.schema
 * @extends AdministrativeArea
 */
public class Country extends AdministrativeArea {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Country() {
		context = "http://schema.org/";
		type = "Country";
	}

}