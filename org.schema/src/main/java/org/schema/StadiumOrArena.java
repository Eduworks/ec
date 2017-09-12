package org.schema;

/**
 * Schema.org/StadiumOrArena
 * A stadium.
 *
 * @author schema.org
 * @class StadiumOrArena
 * @module org.schema
 * @extends SportsActivityLocation
 */
public class StadiumOrArena extends SportsActivityLocation {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public StadiumOrArena() {
		context = "http://schema.org/";
		type = "StadiumOrArena";
	}

}