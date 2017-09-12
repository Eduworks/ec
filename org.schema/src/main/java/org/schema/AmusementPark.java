package org.schema;

/**
 * Schema.org/AmusementPark
 * An amusement park.
 *
 * @author schema.org
 * @class AmusementPark
 * @module org.schema
 * @extends EntertainmentBusiness
 */
public class AmusementPark extends EntertainmentBusiness {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public AmusementPark() {
		context = "http://schema.org/";
		type = "AmusementPark";
	}

}