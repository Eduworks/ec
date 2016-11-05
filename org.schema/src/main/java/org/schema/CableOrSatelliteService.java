package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/CableOrSatelliteService
 * A service which provides access to media programming like TV or radio. Access may be via cable or satellite.
 * @author schema.org
 * @module schema.org
 * @class CableOrSatelliteService
 * @extends Service
 */
public class CableOrSatelliteService extends Service
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public CableOrSatelliteService()
	{
		context="http://schema.org/";
		type="CableOrSatelliteService";
	}

}