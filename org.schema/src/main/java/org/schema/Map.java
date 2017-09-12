package org.schema;

/**
 * Schema.org/Map
 * A map.
 *
 * @author schema.org
 * @class Map
 * @module org.schema
 * @extends CreativeWork
 */
public class Map extends CreativeWork {
	/**
	 * Schema.org/mapType
	 * Indicates the kind of Map, from the MapCategoryType Enumeration.
	 *
	 * @property mapType
	 * @type MapCategoryType
	 */
	public MapCategoryType mapType;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Map() {
		context = "http://schema.org/";
		type = "Map";
	}

}