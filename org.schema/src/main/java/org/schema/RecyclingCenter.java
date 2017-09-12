package org.schema;

/**
 * Schema.org/RecyclingCenter
 * A recycling center.
 *
 * @author schema.org
 * @class RecyclingCenter
 * @module org.schema
 * @extends LocalBusiness
 */
public class RecyclingCenter extends LocalBusiness {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public RecyclingCenter() {
		context = "http://schema.org/";
		type = "RecyclingCenter";
	}

}