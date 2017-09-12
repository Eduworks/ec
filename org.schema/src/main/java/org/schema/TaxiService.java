package org.schema;

/**
 * Schema.org/TaxiService
 * A service for a vehicle for hire with a driver for local travel. Fares are usually calculated based on distance traveled.
 * @author schema.org
 * @class TaxiService
 * @module org.schema
 * @extends Service
 */
public class TaxiService extends Service
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public TaxiService()
	{
		context="http://schema.org/";
		type="TaxiService";
	}

}