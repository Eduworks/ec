package org.schema;

/**
 * Schema.org/CableOrSatelliteService
 * A service which provides access to media programming like TV or radio. Access may be via cable or satellite.
 *
 * @author schema.org
 * @class CableOrSatelliteService
 * @module org.schema
 * @extends Service
 */
public class CableOrSatelliteService extends Service {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public CableOrSatelliteService() {
		context = "http://schema.org/";
		type = "CableOrSatelliteService";
	}

}