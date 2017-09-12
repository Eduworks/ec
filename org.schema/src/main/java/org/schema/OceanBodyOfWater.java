package org.schema;

/**
 * Schema.org/OceanBodyOfWater
 * An ocean (for example, the Pacific).
 *
 * @author schema.org
 * @class OceanBodyOfWater
 * @module org.schema
 * @extends BodyOfWater
 */
public class OceanBodyOfWater extends BodyOfWater {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public OceanBodyOfWater() {
		context = "http://schema.org/";
		type = "OceanBodyOfWater";
	}

}