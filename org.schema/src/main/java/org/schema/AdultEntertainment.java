package org.schema;

/**
 * Schema.org/AdultEntertainment
 * An adult entertainment establishment.
 *
 * @author schema.org
 * @class AdultEntertainment
 * @module org.schema
 * @extends EntertainmentBusiness
 */
public class AdultEntertainment extends EntertainmentBusiness {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public AdultEntertainment() {
		context = "http://schema.org/";
		type = "AdultEntertainment";
	}

}