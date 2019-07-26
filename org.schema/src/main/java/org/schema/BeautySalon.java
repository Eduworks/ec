package org.schema;

/**
 * Schema.org/BeautySalon
 * Beauty salon.
 *
 * @author schema.org
 * @class BeautySalon
 * @module org.schema
 * @extends HealthAndBeautyBusiness
 */
public class BeautySalon extends HealthAndBeautyBusiness {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public BeautySalon() {
		context = "http://schema.org/";
		type = "BeautySalon";
	}

}