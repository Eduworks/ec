package org.schema;

/**
 * Schema.org/MusicVenue
 * A music venue.
 *
 * @author schema.org
 * @class MusicVenue
 * @module org.schema
 * @extends CivicStructure
 */
public class MusicVenue extends CivicStructure {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public MusicVenue() {
		context = "http://schema.org/";
		type = "MusicVenue";
	}

}