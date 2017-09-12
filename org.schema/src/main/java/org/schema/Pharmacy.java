package org.schema;

/**
 * Schema.org/Pharmacy
 * A pharmacy or drugstore.
 *
 * @author schema.org
 * @class Pharmacy
 * @module org.schema
 * @extends MedicalOrganization
 */
public class Pharmacy extends MedicalOrganization {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Pharmacy() {
		context = "http://schema.org/";
		type = "Pharmacy";
	}

}