package org.schema;

/**
 * Schema.org/ApartmentComplex
 * Residence type: Apartment complex.
 *
 * @author schema.org
 * @class ApartmentComplex
 * @module org.schema
 * @extends Residence
 */
public class ApartmentComplex extends Residence {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ApartmentComplex() {
		context = "http://schema.org/";
		type = "ApartmentComplex";
	}

}