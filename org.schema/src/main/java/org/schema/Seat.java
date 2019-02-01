package org.schema;

/**
 * Schema.org/Seat
 * Used to describe a seat, such as a reserved seat in an event reservation.
 *
 * @author schema.org
 * @class Seat
 * @module org.schema
 * @extends Intangible
 */
public class Seat extends Intangible {
	/**
	 * Schema.org/seatingType
	 * The type/class of the seat.
	 *
	 * @property seatingType
	 * @type Text
	 */
	public String seatingType;
	/**
	 * Schema.org/seatSection
	 * The section location of the reserved seat (e.g. Orchestra).
	 *
	 * @property seatSection
	 * @type Text
	 */
	public String seatSection;
	/**
	 * Schema.org/seatRow
	 * The row location of the reserved seat (e.g., B).
	 *
	 * @property seatRow
	 * @type Text
	 */
	public String seatRow;
	/**
	 * Schema.org/seatNumber
	 * The location of the reserved seat (e.g., 27).
	 *
	 * @property seatNumber
	 * @type Text
	 */
	public String seatNumber;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Seat() {
		context = "http://schema.org/";
		type = "Seat";
	}

}