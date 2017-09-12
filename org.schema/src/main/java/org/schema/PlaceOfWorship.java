package org.schema;

/**
 * Schema.org/PlaceOfWorship
 * Place of worship, such as a church, synagogue, or mosque.
 *
 * @author schema.org
 * @class PlaceOfWorship
 * @module org.schema
 * @extends CivicStructure
 */
public class PlaceOfWorship extends CivicStructure {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public PlaceOfWorship() {
		context = "http://schema.org/";
		type = "PlaceOfWorship";
	}

}