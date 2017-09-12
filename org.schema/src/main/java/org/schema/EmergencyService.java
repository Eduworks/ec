package org.schema;

/**
 * Schema.org/EmergencyService
 * An emergency service, such as a fire station or ER.
 * @author schema.org
 * @class EmergencyService
 * @module org.schema
 * @extends LocalBusiness
 */
public class EmergencyService extends LocalBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public EmergencyService()
	{
		context="http://schema.org/";
		type="EmergencyService";
	}

}