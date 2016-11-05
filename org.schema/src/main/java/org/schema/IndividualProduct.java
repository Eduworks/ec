package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/IndividualProduct
 * A single, identifiable product instance (e.g. a laptop with a particular serial number).
 * @author schema.org
 * @module schema.org
 * @class IndividualProduct
 * @extends Product
 */
public class IndividualProduct extends Product
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public IndividualProduct()
	{
		context="http://schema.org/";
		type="IndividualProduct";
	}

	/**
	 * Schema.org/serialNumber
	 * The serial number or any alphanumeric identifier of a particular product. When attached to an offer, it is a shortcut for the serial number of the product included in the offer.
	 * @property serialNumber
	 * @type Text
	 */
	public String serialNumber;

}