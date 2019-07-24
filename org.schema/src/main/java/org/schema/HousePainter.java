package org.schema;

/**
 * Schema.org/HousePainter
 * A house painting service.
 *
 * @author schema.org
 * @class HousePainter
 * @module org.schema
 * @extends HomeAndConstructionBusiness
 */
public class HousePainter extends HomeAndConstructionBusiness {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public HousePainter() {
		context = "http://schema.org/";
		type = "HousePainter";
	}

}