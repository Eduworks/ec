package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/ParkingFacility
 * A parking lot or other parking facility.
 * @author schema.org
 * @module schema.org
 * @class ParkingFacility
 * @extends CivicStructure
 */
public class ParkingFacility extends CivicStructure
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ParkingFacility()
	{
		context="http://schema.org/";
		type="ParkingFacility";
	}

}