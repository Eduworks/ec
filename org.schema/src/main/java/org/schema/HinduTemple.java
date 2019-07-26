package org.schema;

/**
 * Schema.org/HinduTemple
 * A Hindu temple.
 *
 * @author schema.org
 * @class HinduTemple
 * @module org.schema
 * @extends PlaceOfWorship
 */
public class HinduTemple extends PlaceOfWorship {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public HinduTemple() {
		context = "http://schema.org/";
		type = "HinduTemple";
	}

}