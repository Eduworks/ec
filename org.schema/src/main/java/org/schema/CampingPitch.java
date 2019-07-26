package org.schema;

/**
 * Schema.org/CampingPitch
 * A camping pitch is an individual place for overnight stay in the outdoors, typically being part of a larger camping site.
 * <br /><br />
 * See also the <a href="/docs/hotels.html">dedicated document on the use of schema.org for marking up hotels and other forms of accommodations</a>.
 *
 * @author schema.org
 * @class CampingPitch
 * @module org.schema
 * @extends Accommodation
 */
public class CampingPitch extends Accommodation {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public CampingPitch() {
		context = "http://schema.org/";
		type = "CampingPitch";
	}

}