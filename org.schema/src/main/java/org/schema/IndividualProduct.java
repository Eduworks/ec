package org.schema;

/**
 * Schema.org/IndividualProduct
 * A single, identifiable product instance (e.g. a laptop with a particular serial number).
 *
 * @author schema.org
 * @class IndividualProduct
 * @module org.schema
 * @extends Product
 */
public class IndividualProduct extends Product {
	/**
	 * Schema.org/serialNumber
	 * The serial number or any alphanumeric identifier of a particular product. When attached to an offer, it is a shortcut for the serial number of the product included in the offer.
	 *
	 * @property serialNumber
	 * @type Text
	 */
	public String serialNumber;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public IndividualProduct() {
		context = "http://schema.org/";
		type = "IndividualProduct";
	}

}