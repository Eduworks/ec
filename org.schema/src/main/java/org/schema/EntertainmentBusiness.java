package org.schema;

/**
 * Schema.org/EntertainmentBusiness
 * A business providing entertainment.
 *
 * @author schema.org
 * @class EntertainmentBusiness
 * @module org.schema
 * @extends LocalBusiness
 */
public class EntertainmentBusiness extends LocalBusiness {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public EntertainmentBusiness() {
		context = "http://schema.org/";
		type = "EntertainmentBusiness";
	}

}