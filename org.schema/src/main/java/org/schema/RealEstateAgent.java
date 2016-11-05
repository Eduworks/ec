package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/RealEstateAgent
 * A real-estate agent.
 * @author schema.org
 * @module schema.org
 * @class RealEstateAgent
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