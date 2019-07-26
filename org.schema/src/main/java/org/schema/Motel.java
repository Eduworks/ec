package org.schema;

/**
 * Schema.org/Motel
 * A motel.
 * <br /><br />
 * See also the <a href="/docs/hotels.html">dedicated document on the use of schema.org for marking up hotels and other forms of accommodations</a>.
 *
 * @author schema.org
 * @class Motel
 * @module org.schema
 * @extends LodgingBusiness
 */
public class Motel extends LodgingBusiness {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Motel() {
		context = "http://schema.org/";
		type = "Motel";
	}

}