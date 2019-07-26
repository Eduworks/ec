package org.schema;

/**
 * Schema.org/Quantity
 * Quantities such as distance, time, mass, weight, etc. Particular instances of say Mass are entities like '3 Kg' or '4 milligrams'.
 *
 * @author schema.org
 * @class Quantity
 * @module org.schema
 * @extends Intangible
 */
public class Quantity extends Intangible {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Quantity() {
		context = "http://schema.org/";
		type = "Quantity";
	}

}