package org.schema;

/**
 * Schema.org/GovernmentOrganization
 * A governmental organization or agency.
 *
 * @author schema.org
 * @class GovernmentOrganization
 * @module org.schema
 * @extends Organization
 */
public class GovernmentOrganization extends Organization {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public GovernmentOrganization() {
		context = "http://schema.org/";
		type = "GovernmentOrganization";
	}

}