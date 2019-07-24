package org.schema;

/**
 * Schema.org/Dentist
 * A dentist.
 *
 * @author schema.org
 * @class Dentist
 * @module org.schema
 * @extends MedicalOrganization
 */
public class Dentist extends MedicalOrganization {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Dentist() {
		context = "http://schema.org/";
		type = "Dentist";
	}

}