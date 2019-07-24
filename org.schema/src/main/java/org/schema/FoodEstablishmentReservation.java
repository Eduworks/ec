package org.schema;

/**
 * Schema.org/FoodEstablishmentReservation
 * A reservation to dine at a food-related business.Note: This type is for information about actual reservations, e.g. in confirmation emails or HTML pages with individual confirmations of reservations.
 *
 * @author schema.org
 * @class FoodEstablishmentReservation
 * @module org.schema
 * @extends Reservation
 */
public class FoodEstablishmentReservation extends Reservation {
	/**
	 * Schema.org/startTime
	 * The startTime of something. For a reserved event or service (e.g. FoodEstablishmentReservation), the time that it is expected to start. For actions that span a period of time, when the action was performed. e.g. John wrote a book from *January* to December.\n\nNote that Event uses startDate/endDate instead of startTime/endTime, even when describing dates with times. This situation may be clarified in future revisions.
	 *
	 * @property startTime
	 * @type DateTime
	 */
	public String startTime;
	/**
	 * Schema.org/endTime
	 * The endTime of something. For a reserved event or service (e.g. FoodEstablishmentReservation), the time that it is expected to end. For actions that span a period of time, when the action was performed. e.g. John wrote a book from January to *December*.\n\nNote that Event uses startDate/endDate instead of startTime/endTime, even when describing dates with times. This situation may be clarified in future revisions.
	 *
	 * @property endTime
	 * @type DateTime
	 */
	public String endTime;
	/**
	 * Schema.org/partySize
	 * Number of people the reservation should accommodate.
	 *
	 * @property partySize
	 * @type Integer
	 */
	public Integer partySize;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public FoodEstablishmentReservation() {
		context = "http://schema.org/";
		type = "FoodEstablishmentReservation";
	}

}