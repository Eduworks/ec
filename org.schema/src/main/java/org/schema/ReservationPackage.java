package org.schema;

/**
 * Schema.org/ReservationPackage
 * A group of multiple reservations with common values for all sub-reservations.
 *
 * @author schema.org
 * @class ReservationPackage
 * @module org.schema
 * @extends Reservation
 */
public class ReservationPackage extends Reservation {
	/**
	 * Schema.org/subReservation
	 * The individual reservations included in the package. Typically a repeated property.
	 *
	 * @property subReservation
	 * @type Reservation
	 */
	public Reservation subReservation;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ReservationPackage() {
		context = "http://schema.org/";
		type = "ReservationPackage";
	}

}