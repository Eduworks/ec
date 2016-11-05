package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/TouristInformationCenter
 * A tourist information center.
 * @author schema.org
 * @module schema.org
 * @class TouristInformationCenter
 * @extends LocalBusiness
 */
public class TouristInformationCenter extends LocalBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public TouristInformationCenter()
	{
		context="http://schema.org/";
		type="TouristInformationCenter";
	}

}