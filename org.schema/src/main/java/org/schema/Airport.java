package org.schema;

/**
 * Schema.org/Airport
 * An airport.
 *
 * @author schema.org
 * @class Airport
 * @module org.schema
 * @extends CivicStructure
 */
public class Airport extends CivicStructure {
	/**
	 * Schema.org/iataCode
	 * IATA identifier for an airline or airport.
	 *
	 * @property iataCode
	 * @type Text
	 */
	public String iataCode;
	/**
	 * Schema.org/icaoCode
	 * ICAO identifier for an airport.
	 *
	 * @property icaoCode
	 * @type Text
	 */
	public String icaoCode;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Airport() {
		context = "http://schema.org/";
		type = "Airport";
	}

}