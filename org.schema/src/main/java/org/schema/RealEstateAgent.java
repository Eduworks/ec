package org.schema;

/**
 * Schema.org/RealEstateAgent
 * A real-estate agent.
 * @author schema.org
 * @class RealEstateAgent
 * @module org.schema
 * @extends LocalBusiness
 */
public class RealEstateAgent extends LocalBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public RealEstateAgent()
	{
		context="http://schema.org/";
		type="RealEstateAgent";
	}

}