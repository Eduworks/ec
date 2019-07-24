package org.schema;

/**
 * Schema.org/Season
 * A media season e.g. tv, radio, video game etc.
 *
 * @author schema.org
 * @class Season
 * @module org.schema
 * @extends CreativeWork
 */
public class Season extends CreativeWork {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Season() {
		context = "http://schema.org/";
		type = "Season";
	}

}