package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/CityHall
 * A city hall.
 * @author schema.org
 * @module schema.org
 * @class CityHall
 * @extends GovernmentBuilding
 */
public class CityHall extends GovernmentBuilding
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public CityHall()
	{
		context="http://schema.org/";
		type="CityHall";
	}

}