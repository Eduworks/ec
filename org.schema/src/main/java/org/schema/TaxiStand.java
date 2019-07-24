package org.schema;

/**
 * Schema.org/TaxiStand
 * A taxi stand.
 *
 * @author schema.org
 * @class TaxiStand
 * @module org.schema
 * @extends CivicStructure
 */
public class TaxiStand extends CivicStructure {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public TaxiStand() {
		context = "http://schema.org/";
		type = "TaxiStand";
	}

}