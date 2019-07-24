package org.schema;

/**
 * Schema.org/Taxi
 * A taxi.
 *
 * @author schema.org
 * @class Taxi
 * @module org.schema
 * @extends Service
 */
public class Taxi extends Service {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Taxi() {
		context = "http://schema.org/";
		type = "Taxi";
	}

}