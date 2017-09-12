package org.schema;

/**
 * Schema.org/Hospital
 * A hospital.
 *
 * @author schema.org
 * @class Hospital
 * @module org.schema
 * @extends CivicStructure
 */
public class Hospital extends CivicStructure {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Hospital() {
		context = "http://schema.org/";
		type = "Hospital";
	}

}