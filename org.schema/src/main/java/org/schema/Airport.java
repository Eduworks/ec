package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Airport
 * An airport.
 * @author schema.org
 * @module schema.org
 * @class Airport
 * @extends CivicStructure
 */
public class Airport extends CivicStructure
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Airport()
	{
		context="http://schema.org/";
		type="Airport";
	}

	/**
	 * Schema.org/iataCode
	 * IATA identifier for an airline or airport.
	 * @property iataCode
	 * @type Text
	 */
	public String iataCode;

	/**
	 * Schema.org/icaoCode
	 * ICAO identifier for an airport.
	 * @property icaoCode
	 * @type Text
	 */
	public String icaoCode;

}