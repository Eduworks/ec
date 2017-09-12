package org.schema;

/**
 * Schema.org/Hotel
 * A hotel is an establishment that provides lodging paid on a short-term basis (Source: Wikipedia, the free encyclopedia, see http://en.wikipedia.org/wiki/Hotel).
 * <br /><br />
 * See also the <a href="/docs/hotels.html">dedicated document on the use of schema.org for marking up hotels and other forms of accommodations</a>.
 *
 * @author schema.org
 * @class Hotel
 * @module org.schema
 * @extends LodgingBusiness
 */
public class Hotel extends LodgingBusiness {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Hotel() {
		context = "http://schema.org/";
		type = "Hotel";
	}

}