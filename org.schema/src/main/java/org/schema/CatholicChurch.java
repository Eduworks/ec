package org.schema;

/**
 * Schema.org/CatholicChurch
 * A Catholic church.
 *
 * @author schema.org
 * @class CatholicChurch
 * @module org.schema
 * @extends PlaceOfWorship
 */
public class CatholicChurch extends PlaceOfWorship {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public CatholicChurch() {
		context = "http://schema.org/";
		type = "CatholicChurch";
	}

}