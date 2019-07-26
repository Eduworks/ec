package org.schema;

/**
 * Schema.org/TouristAttraction
 * A tourist attraction.
 *
 * @author schema.org
 * @class TouristAttraction
 * @module org.schema
 * @extends Place
 */
public class TouristAttraction extends Place {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public TouristAttraction() {
		context = "http://schema.org/";
		type = "TouristAttraction";
	}

}