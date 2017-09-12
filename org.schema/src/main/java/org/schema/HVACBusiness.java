package org.schema;

/**
 * Schema.org/HVACBusiness
 * A business that provide Heating, Ventilation and Air Conditioning services.
 *
 * @author schema.org
 * @class HVACBusiness
 * @module org.schema
 * @extends HomeAndConstructionBusiness
 */
public class HVACBusiness extends HomeAndConstructionBusiness {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public HVACBusiness() {
		context = "http://schema.org/";
		type = "HVACBusiness";
	}

}