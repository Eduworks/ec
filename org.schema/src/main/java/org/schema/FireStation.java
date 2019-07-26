package org.schema;

/**
 * Schema.org/FireStation
 * A fire station. With firemen.
 *
 * @author schema.org
 * @class FireStation
 * @module org.schema
 * @extends CivicStructure
 */
public class FireStation extends CivicStructure {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public FireStation() {
		context = "http://schema.org/";
		type = "FireStation";
	}

}