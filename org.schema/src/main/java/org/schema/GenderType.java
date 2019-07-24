package org.schema;

/**
 * Schema.org/GenderType
 * An enumeration of genders.
 *
 * @author schema.org
 * @class GenderType
 * @module org.schema
 * @extends Enumeration
 */
public class GenderType extends Enumeration {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public GenderType() {
		context = "http://schema.org/";
		type = "GenderType";
	}

}