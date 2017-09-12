package org.schema;

/**
 * Schema.org/LandmarksOrHistoricalBuildings
 * An historical landmark or building.
 *
 * @author schema.org
 * @class LandmarksOrHistoricalBuildings
 * @module org.schema
 * @extends Place
 */
public class LandmarksOrHistoricalBuildings extends Place {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public LandmarksOrHistoricalBuildings() {
		context = "http://schema.org/";
		type = "LandmarksOrHistoricalBuildings";
	}

}