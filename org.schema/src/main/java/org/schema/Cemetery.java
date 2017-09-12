package org.schema;

/**
 * Schema.org/Cemetery
 * A graveyard.
 *
 * @author schema.org
 * @class Cemetery
 * @module org.schema
 * @extends CivicStructure
 */
public class Cemetery extends CivicStructure {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Cemetery() {
		context = "http://schema.org/";
		type = "Cemetery";
	}

}