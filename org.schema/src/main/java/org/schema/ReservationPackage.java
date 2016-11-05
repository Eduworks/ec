package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/ReservationPackage
 * A group of multiple reservations with common values for all sub-reservations.
 * @author schema.org
 * @module schema.org
 * @class ReservationPackage
 * @extends Reservation
 */
public class ReservationPackage extends Reservation
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ReservationPackage()
	{
		context="http://schema.org/";
		type="ReservationPackage";
	}

	/**
	 * Schema.org/subReservation
	 * The individual reservations included in the package. Typically a repeated property.
	 * @property subReservation
	 * @type Reservation
	 */
	public Reservation subReservation;

}