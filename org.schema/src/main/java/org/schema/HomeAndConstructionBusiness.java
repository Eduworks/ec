package org.schema;

/**
 * Schema.org/HomeAndConstructionBusiness
 * A construction business.\n\nA HomeAndConstructionBusiness is a [[LocalBusiness]] that provides services around homes and buildings.\n\nAs a [[LocalBusiness]] it can be described as a [[provider]] of one or more [[Service]]\(s).
 *
 * @author schema.org
 * @class HomeAndConstructionBusiness
 * @module org.schema
 * @extends LocalBusiness
 */
public class HomeAndConstructionBusiness extends LocalBusiness {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public HomeAndConstructionBusiness() {
		context = "http://schema.org/";
		type = "HomeAndConstructionBusiness";
	}

}