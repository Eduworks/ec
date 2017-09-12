package org.schema;

/**
 * Schema.org/Attorney
 * Professional service: Attorney. \n\nThis type is deprecated - [[LegalService]] is more inclusive and less ambiguous.
 * @author schema.org
 * @class Attorney
 * @module org.schema
 * @extends LegalService
 */
public class Attorney extends LegalService
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Attorney()
	{
		context="http://schema.org/";
		type="Attorney";
	}

}