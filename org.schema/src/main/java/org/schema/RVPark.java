package org.schema;

/**
 * Schema.org/RVPark
 * A place offering space for "Recreational Vehicles", Caravans, mobile homes and the like.
 *
 * @author schema.org
 * @class RVPark
 * @module org.schema
 * @extends CivicStructure
 */
public class RVPark extends CivicStructure {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public RVPark() {
		context = "http://schema.org/";
		type = "RVPark";
	}

}