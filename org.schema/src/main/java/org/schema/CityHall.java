package org.schema;

/**
 * Schema.org/CityHall
 * A city hall.
 *
 * @author schema.org
 * @class CityHall
 * @module org.schema
 * @extends GovernmentBuilding
 */
public class CityHall extends GovernmentBuilding {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public CityHall() {
		context = "http://schema.org/";
		type = "CityHall";
	}

}