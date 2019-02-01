package org.schema;

/**
 * Schema.org/Reservation
 * Describes a reservation for travel, dining or an event. Some reservations require tickets. \n\nNote: This type is for information about actual reservations, e.g. in confirmation emails or HTML pages with individual confirmations of reservations. For offers of tickets, restaurant reservations, flights, or rental cars, use [[Offer]].
 *
 * @author schema.org
 * @class Reservation
 * @module org.schema
 * @extends Intangible
 */
public class Reservation extends Intangible {
	/**
	 * Schema.org/provider
	 * The service provider, service operator, or service performer; the goods producer. Another party (a seller) may offer those services or goods on behalf of the provider. A provider may also serve as the seller.
	 *
	 * @property provider
	 * @type Person
	 */
	public Person provider;
	/**
	 * Schema.org/programMembershipUsed
	 * Any membership in a frequent flyer, hotel loyalty program, etc. being applied to the reservation.
	 *
	 * @property programMembershipUsed
	 * @type ProgramMembership
	 */
	public ProgramMembership programMembershipUsed;
	/**
	 * Schema.org/reservationStatus
	 * The current status of the reservation.
	 *
	 * @property reservationStatus
	 * @type ReservationStatusType
	 */
	public ReservationStatusType reservationStatus;
	/**
	 * Schema.org/underName
	 * The person or organization the reservation or ticket is for.
	 *
	 * @property underName
	 * @type Organization
	 */
	public Organization underName;
	/**
	 * Schema.org/bookingAgent
	 * 'bookingAgent' is an out-dated term indicating a 'broker' that serves as a booking agent.
	 *
	 * @property bookingAgent
	 * @type Organization
	 */
	public Organization bookingAgent;
	/**
	 * Schema.org/totalPrice
	 * The total price for the reservation or ticket, including applicable taxes, shipping, etc.
	 *
	 * @property totalPrice
	 * @type Number
	 */
	public Double totalPrice;
	/**
	 * Schema.org/reservationFor
	 * The thing -- flight, event, restaurant,etc. being reserved.
	 *
	 * @property reservationFor
	 * @type Thing
	 */
	public Thing reservationFor;
	/**
	 * Schema.org/priceCurrency
	 * The currency (in 3-letter ISO 4217 format) of the price or a price component, when attached to [[PriceSpecification]] and its subtypes.
	 *
	 * @property priceCurrency
	 * @type Text
	 */
	public String priceCurrency;
	/**
	 * Schema.org/broker
	 * An entity that arranges for an exchange between a buyer and a seller.  In most cases a broker never acquires or releases ownership of a product or service involved in an exchange.  If it is not clear whether an entity is a broker, seller, or buyer, the latter two terms are preferred.
	 *
	 * @property broker
	 * @type Person
	 */
	public Person broker;
	/**
	 * Schema.org/modifiedTime
	 * The date and time the reservation was modified.
	 *
	 * @property modifiedTime
	 * @type DateTime
	 */
	public String modifiedTime;
	/**
	 * Schema.org/bookingTime
	 * The date and time the reservation was booked.
	 *
	 * @property bookingTime
	 * @type DateTime
	 */
	public String bookingTime;
	/**
	 * Schema.org/reservationId
	 * A unique identifier for the reservation.
	 *
	 * @property reservationId
	 * @type Text
	 */
	public String reservationId;
	/**
	 * Schema.org/reservedTicket
	 * A ticket associated with the reservation.
	 *
	 * @property reservedTicket
	 * @type Ticket
	 */
	public Ticket reservedTicket;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Reservation() {
		context = "http://schema.org/";
		type = "Reservation";
	}

}