package org.schema;

/**
 * Schema.org/Aquarium
 * Aquarium.
 *
 * @author schema.org
 * @class Aquarium
 * @module org.schema
 * @extends CivicStructure
 */
public class Aquarium extends CivicStructure {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Aquarium() {
		context = "http://schema.org/";
		type = "Aquarium";
	}

}