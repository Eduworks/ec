package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Ticket
 * Used to describe a ticket to an event, a flight, a bus ride, etc.
 * @author schema.org
 * @module schema.org
 * @class Ticket
 * @extends Intangible
 */
public class Ticket extends Intangible
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Ticket()
	{
		context="http://schema.org/";
		type="Ticket";
	}

	/**
	 * Schema.org/priceCurrency
	 * The currency (in 3-letter ISO 4217 format) of the price or a price component, when attached to [[PriceSpecification]] and its subtypes.
	 * @property priceCurrency
	 * @type Text
	 */
	public String priceCurrency;

	/**
	 * Schema.org/totalPrice
	 * The total price for the reservation or ticket, including applicable taxes, shipping, etc.
	 * @property totalPrice
	 * @type schema,Text | schema,Number | schema,PriceSpecification	 */
	public Object totalPrice;

	/**
	 * Schema.org/dateIssued
	 * The date the ticket was issued.
	 * @property dateIssued
	 * @type DateTime
	 */
	public String dateIssued;

	/**
	 * Schema.org/ticketToken
	 * Reference to an asset (e.g., Barcode, QR code image or PDF) usable for entrance.
	 * @property ticketToken
	 * @type schema,Text | schema,URL	 */
	public Object ticketToken;

	/**
	 * Schema.org/ticketNumber
	 * The unique identifier for the ticket.
	 * @property ticketNumber
	 * @type Text
	 */
	public String ticketNumber;

	/**
	 * Schema.org/issuedBy
	 * The organization issuing the ticket or permit.
	 * @property issuedBy
	 * @type Organization
	 */
	public Organization issuedBy;

	/**
	 * Schema.org/ticketedSeat
	 * The seat associated with the ticket.
	 * @property ticketedSeat
	 * @type Seat
	 */
	public Seat ticketedSeat;

	/**
	 * Schema.org/underName
	 * The person or organization the reservation or ticket is for.
	 * @property underName
	 * @type schema,Organization | schema,Person	 */
	public Object underName;

}