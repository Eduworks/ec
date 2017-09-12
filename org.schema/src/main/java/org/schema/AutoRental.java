package org.schema;

/**
 * Schema.org/AutoRental
 * A car rental business.
 *
 * @author schema.org
 * @class AutoRental
 * @module org.schema
 * @extends AutomotiveBusiness
 */
public class AutoRental extends AutomotiveBusiness {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public AutoRental() {
		context = "http://schema.org/";
		type = "AutoRental";
	}

}