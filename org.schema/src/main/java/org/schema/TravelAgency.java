package org.schema;

/**
 * Schema.org/TravelAgency
 * A travel agency.
 *
 * @author schema.org
 * @class TravelAgency
 * @module org.schema
 * @extends LocalBusiness
 */
public class TravelAgency extends LocalBusiness {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public TravelAgency() {
		context = "http://schema.org/";
		type = "TravelAgency";
	}

}