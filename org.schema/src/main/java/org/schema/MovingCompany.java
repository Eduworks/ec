package org.schema;

/**
 * Schema.org/MovingCompany
 * A moving company.
 *
 * @author schema.org
 * @class MovingCompany
 * @module org.schema
 * @extends HomeAndConstructionBusiness
 */
public class MovingCompany extends HomeAndConstructionBusiness {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public MovingCompany() {
		context = "http://schema.org/";
		type = "MovingCompany";
	}

}