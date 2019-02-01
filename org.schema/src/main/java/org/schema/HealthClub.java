package org.schema;

/**
 * Schema.org/HealthClub
 * A health club.
 *
 * @author schema.org
 * @class HealthClub
 * @module org.schema
 * @extends HealthAndBeautyBusiness
 */
public class HealthClub extends HealthAndBeautyBusiness {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public HealthClub() {
		context = "http://schema.org/";
		type = "HealthClub";
	}

}