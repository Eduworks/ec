package org.schema;

/**
 * Schema.org/EventReservation
 * A reservation for an event like a concert, sporting event, or lecture.\n\nNote: This type is for information about actual reservations, e.g. in confirmation emails or HTML pages with individual confirmations of reservations. For offers of tickets, use [[Offer]].
 * @author schema.org
 * @class EventReservation
 * @module org.schema
 * @extends Reservation
 */
public class EventReservation extends Reservation
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public EventReservation()
	{
		context="http://schema.org/";
		type="EventReservation";
	}

}