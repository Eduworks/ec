package org.schema;

/**
 * Schema.org/BarOrPub
 * A bar or pub.
 *
 * @author schema.org
 * @class BarOrPub
 * @module org.schema
 * @extends FoodEstablishment
 */
public class BarOrPub extends FoodEstablishment {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public BarOrPub() {
		context = "http://schema.org/";
		type = "BarOrPub";
	}

}