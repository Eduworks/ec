package org.schema;

/**
 * Schema.org/TattooParlor
 * A tattoo parlor.
 *
 * @author schema.org
 * @class TattooParlor
 * @module org.schema
 * @extends HealthAndBeautyBusiness
 */
public class TattooParlor extends HealthAndBeautyBusiness {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public TattooParlor() {
		context = "http://schema.org/";
		type = "TattooParlor";
	}

}