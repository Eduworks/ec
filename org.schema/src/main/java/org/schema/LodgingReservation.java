package org.schema;

/**
 * Schema.org/LodgingReservation
 * A reservation for lodging at a hotel, motel, inn, etc.\n\nNote: This type is for information about actual reservations, e.g. in confirmation emails or HTML pages with individual confirmations of reservations.
 *
 * @author schema.org
 * @class LodgingReservation
 * @module org.schema
 * @extends Reservation
 */
public class LodgingReservation extends Reservation {
	/**
	 * Schema.org/checkinTime
	 * The earliest someone may check into a lodging establishment.
	 *
	 * @property checkinTime
	 * @type DateTime
	 */
	public String checkinTime;
	/**
	 * Schema.org/numChildren
	 * The number of children staying in the unit.
	 *
	 * @property numChildren
	 * @type Integer
	 */
	public Integer numChildren;
	/**
	 * Schema.org/lodgingUnitDescription
	 * A full description of the lodging unit.
	 *
	 * @property lodgingUnitDescription
	 * @type Text
	 */
	public String lodgingUnitDescription;
	/**
	 * Schema.org/checkoutTime
	 * The latest someone may check out of a lodging establishment.
	 *
	 * @property checkoutTime
	 * @type DateTime
	 */
	public String checkoutTime;
	/**
	 * Schema.org/lodgingUnitType
	 * Textual description of the unit type (including suite vs. room, size of bed, etc.).
	 *
	 * @property lodgingUnitType
	 * @type Text
	 */
	public String lodgingUnitType;
	/**
	 * Schema.org/numAdults
	 * The number of adults staying in the unit.
	 *
	 * @property numAdults
	 * @type Integer
	 */
	public Integer numAdults;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public LodgingReservation() {
		context = "http://schema.org/";
		type = "LodgingReservation";
	}

}