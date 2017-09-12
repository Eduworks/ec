package org.schema;

/**
 * Schema.org/BedDetails
 * An entity holding detailed information about the available bed types, e.g. the quantity of twin beds for a hotel room. For the single case of just one bed of a certain type, you can use bed directly with a text. See also [[BedType]] (under development).
 *
 * @author schema.org
 * @class BedDetails
 * @module org.schema
 * @extends Intangible
 */
public class BedDetails extends Intangible {
	/**
	 * Schema.org/numberOfBeds
	 * The quantity of the given bed type available in the HotelRoom, Suite, House, or Apartment.
	 *
	 * @property numberOfBeds
	 * @type Number
	 */
	public Double numberOfBeds;
	/**
	 * Schema.org/typeOfBed
	 * The type of bed to which the BedDetail refers, i.e. the type of bed available in the quantity indicated by quantity.
	 *
	 * @property typeOfBed
	 * @type Text
	 */
	public String typeOfBed;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public BedDetails() {
		context = "http://schema.org/";
		type = "BedDetails";
	}

}