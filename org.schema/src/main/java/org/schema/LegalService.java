package org.schema;

/**
 * Schema.org/LegalService
 * A LegalService is a business that provides legally-oriented services, advice and representation, e.g. law firms.\n\nAs a [[LocalBusiness]] it can be described as a [[provider]] of one or more [[Service]]\(s).
 * @author schema.org
 * @class LegalService
 * @module org.schema
 * @extends LocalBusiness
 */
public class LegalService extends LocalBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public LegalService()
	{
		context="http://schema.org/";
		type="LegalService";
	}

}