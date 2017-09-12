package org.schema;

/**
 * Schema.org/TrainStation
 * A train station.
 *
 * @author schema.org
 * @class TrainStation
 * @module org.schema
 * @extends CivicStructure
 */
public class TrainStation extends CivicStructure {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public TrainStation() {
		context = "http://schema.org/";
		type = "TrainStation";
	}

}