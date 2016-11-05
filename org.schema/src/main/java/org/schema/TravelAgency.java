package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/TravelAgency
 * A travel agency.
 * @author schema.org
 * @module schema.org
 * @class TravelAgency
 * @extends LocalBusiness
 */
public class TravelAgency extends LocalBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public TravelAgency()
	{
		context="http://schema.org/";
		type="TravelAgency";
	}

}