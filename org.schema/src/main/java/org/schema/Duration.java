package org.schema;

/**
 * Schema.org/Duration
 * Quantity: Duration (use [ISO 8601 duration format](http://en.wikipedia.org/wiki/ISO_8601)).
 *
 * @author schema.org
 * @class Duration
 * @module org.schema
 * @extends Quantity
 */
public class Duration extends Quantity {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Duration() {
		context = "http://schema.org/";
		type = "Duration";
	}

}