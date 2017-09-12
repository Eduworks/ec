package org.schema;

/**
 * Schema.org/Beach
 * Beach.
 *
 * @author schema.org
 * @class Beach
 * @module org.schema
 * @extends CivicStructure
 */
public class Beach extends CivicStructure {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Beach() {
		context = "http://schema.org/";
		type = "Beach";
	}

}