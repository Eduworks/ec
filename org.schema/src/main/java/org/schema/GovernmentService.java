package org.schema;

/**
 * Schema.org/GovernmentService
 * A service provided by a government organization, e.g. food stamps, veterans benefits, etc.
 *
 * @author schema.org
 * @class GovernmentService
 * @module org.schema
 * @extends Service
 */
public class GovernmentService extends Service {
	/**
	 * Schema.org/serviceOperator
	 * The operating organization, if different from the provider.  This enables the representation of services that are provided by an organization, but operated by another organization like a subcontractor.
	 *
	 * @property serviceOperator
	 * @type Organization
	 */
	public Organization serviceOperator;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public GovernmentService() {
		context = "http://schema.org/";
		type = "GovernmentService";
	}

}