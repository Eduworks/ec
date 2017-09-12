package org.schema;

/**
 * Schema.org/Mosque
 * A mosque.
 *
 * @author schema.org
 * @class Mosque
 * @module org.schema
 * @extends PlaceOfWorship
 */
public class Mosque extends PlaceOfWorship {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Mosque() {
		context = "http://schema.org/";
		type = "Mosque";
	}

}