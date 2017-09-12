package org.schema;

/**
 * Schema.org/RadioChannel
 * A unique instance of a radio BroadcastService on a CableOrSatelliteService lineup.
 *
 * @author schema.org
 * @class RadioChannel
 * @module org.schema
 * @extends BroadcastChannel
 */
public class RadioChannel extends BroadcastChannel {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public RadioChannel() {
		context = "http://schema.org/";
		type = "RadioChannel";
	}

}