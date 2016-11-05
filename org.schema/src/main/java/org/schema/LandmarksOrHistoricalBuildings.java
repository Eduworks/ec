package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/LandmarksOrHistoricalBuildings
 * An historical landmark or building.
 * @author schema.org
 * @module schema.org
 * @class LandmarksOrHistoricalBuildings
 * @extends Place
 */
public class LandmarksOrHistoricalBuildings extends Place
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public LandmarksOrHistoricalBuildings()
	{
		context="http://schema.org/";
		type="LandmarksOrHistoricalBuildings";
	}

}