package org.schema;

/**
 * Schema.org/GeneralContractor
 * A general contractor.
 *
 * @author schema.org
 * @class GeneralContractor
 * @module org.schema
 * @extends HomeAndConstructionBusiness
 */
public class GeneralContractor extends HomeAndConstructionBusiness {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public GeneralContractor() {
		context = "http://schema.org/";
		type = "GeneralContractor";
	}

}