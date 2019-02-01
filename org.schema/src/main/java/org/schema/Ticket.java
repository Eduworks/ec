package org.schema;

/**
 * Schema.org/Ticket
 * Used to describe a ticket to an event, a flight, a bus ride, etc.
 *
 * @author schema.org
 * @class Ticket
 * @module org.schema
 * @extends Intangible
 */
public class Ticket extends Intangible {
	/**
	 * Schema.org/underName
	 * The person or organization the reservation or ticket is for.
	 *
	 * @property underName
	 * @type Organization
	 */
	public Organization underName;
	/**
	 * Schema.org/totalPrice
	 * The total price for the reservation or ticket, including applicable taxes, shipping, etc.
	 *
	 * @property totalPrice
	 * @type Number
	 */
	public Double totalPrice;
	/**
	 * Schema.org/priceCurrency
	 * The currency (in 3-letter ISO 4217 format) of the price or a price component, when attached to [[PriceSpecification]] and its subtypes.
	 *
	 * @property priceCurrency
	 * @type Text
	 */
	public String priceCurrency;
	/**
	 * Schema.org/ticketNumber
	 * The unique identifier for the ticket.
	 *
	 * @property ticketNumber
	 * @type Text
	 */
	public String ticketNumber;
	/**
	 * Schema.org/issuedBy
	 * The organization issuing the ticket or permit.
	 *
	 * @property issuedBy
	 * @type Organization
	 */
	public Organization issuedBy;
	/**
	 * Schema.org/ticketToken
	 * Reference to an asset (e.g., Barcode, QR code image or PDF) usable for entrance.
	 *
	 * @property ticketToken
	 * @type URL
	 */
	public String ticketToken;
	/**
	 * Schema.org/ticketedSeat
	 * The seat associated with the ticket.
	 *
	 * @property ticketedSeat
	 * @type Seat
	 */
	public Seat ticketedSeat;
	/**
	 * Schema.org/dateIssued
	 * The date the ticket was issued.
	 *
	 * @property dateIssued
	 * @type DateTime
	 */
	public String dateIssued;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Ticket() {
		context = "http://schema.org/";
		type = "Ticket";
	}

}