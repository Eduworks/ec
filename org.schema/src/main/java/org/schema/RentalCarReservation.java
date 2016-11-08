package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/RentalCarReservation
 * A reservation for a rental car.\n\nNote: This type is for information about actual reservations, e.g. in confirmation emails or HTML pages with individual confirmations of reservations.
 * @author schema.org
 * @class RentalCarReservation
 * @module org.schema
 * @extends Reservation
 */
public class RentalCarReservation extends Reservation
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public RentalCarReservation()
	{
		context="http://schema.org/";
		type="RentalCarReservation";
	}

	/**
	 * Schema.org/dropoffLocation
	 * Where a rental car can be dropped off.
	 * @property dropoffLocation
	 * @type Place
	 */
	public Place dropoffLocation;

	/**
	 * Schema.org/pickupLocation
	 * Where a taxi will pick up a passenger or a rental car can be picked up.
	 * @property pickupLocation
	 * @type Place
	 */
	public Place pickupLocation;

	/**
	 * Schema.org/pickupTime
	 * When a taxi will pickup a passenger or a rental car can be picked up.
	 * @property pickupTime
	 * @type DateTime
	 */
	public String pickupTime;

	/**
	 * Schema.org/dropoffTime
	 * When a rental car can be dropped off.
	 * @property dropoffTime
	 * @type DateTime
	 */
	public String dropoffTime;

}