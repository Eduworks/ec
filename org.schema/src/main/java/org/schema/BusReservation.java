package org.schema;

/**
 * Schema.org/BusReservation
 * A reservation for bus travel. \n\nNote: This type is for information about actual reservations, e.g. in confirmation emails or HTML pages with individual confirmations of reservations. For offers of tickets, use [[Offer]].
 *
 * @author schema.org
 * @class BusReservation
 * @module org.schema
 * @extends Reservation
 */
public class BusReservation extends Reservation {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public BusReservation() {
		context = "http://schema.org/";
		type = "BusReservation";
	}

}