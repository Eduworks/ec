package org.schema;

/**
 * Schema.org/TaxiReservation
 * A reservation for a taxi.\n\nNote: This type is for information about actual reservations, e.g. in confirmation emails or HTML pages with individual confirmations of reservations. For offers of tickets, use [[Offer]].
 *
 * @author schema.org
 * @class TaxiReservation
 * @module org.schema
 * @extends Reservation
 */
public class TaxiReservation extends Reservation {
	/**
	 * Schema.org/pickupTime
	 * When a taxi will pickup a passenger or a rental car can be picked up.
	 *
	 * @property pickupTime
	 * @type DateTime
	 */
	public String pickupTime;
	/**
	 * Schema.org/partySize
	 * Number of people the reservation should accommodate.
	 *
	 * @property partySize
	 * @type Integer
	 */
	public Integer partySize;
	/**
	 * Schema.org/pickupLocation
	 * Where a taxi will pick up a passenger or a rental car can be picked up.
	 *
	 * @property pickupLocation
	 * @type Place
	 */
	public Place pickupLocation;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public TaxiReservation() {
		context = "http://schema.org/";
		type = "TaxiReservation";
	}

}