package org.schema;

/**
 * Schema.org/OfferItemCondition
 * A list of possible conditions for the item.
 *
 * @author schema.org
 * @class OfferItemCondition
 * @module org.schema
 * @extends Enumeration
 */
public class OfferItemCondition extends Enumeration {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public OfferItemCondition() {
		context = "http://schema.org/";
		type = "OfferItemCondition";
	}

}