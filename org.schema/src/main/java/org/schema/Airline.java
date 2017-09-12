package org.schema;

/**
 * Schema.org/Airline
 * An organization that provides flights for passengers.
 *
 * @author schema.org
 * @class Airline
 * @module org.schema
 * @extends Organization
 */
public class Airline extends Organization {
	/**
	 * Schema.org/iataCode
	 * IATA identifier for an airline or airport.
	 *
	 * @property iataCode
	 * @type Text
	 */
	public String iataCode;
	/**
	 * Schema.org/boardingPolicy
	 * The type of boarding policy used by the airline (e.g. zone-based or group-based).
	 *
	 * @property boardingPolicy
	 * @type BoardingPolicyType
	 */
	public BoardingPolicyType boardingPolicy;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Airline() {
		context = "http://schema.org/";
		type = "Airline";
	}

}