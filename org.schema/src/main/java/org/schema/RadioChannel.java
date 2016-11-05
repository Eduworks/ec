package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/RadioChannel
 * A unique instance of a radio BroadcastService on a CableOrSatelliteService lineup.
 * @author schema.org
 * @module schema.org
 * @class RadioChannel
 * @extends BroadcastChannel
 */
public class RadioChannel extends BroadcastChannel
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public RadioChannel()
	{
		context="http://schema.org/";
		type="RadioChannel";
	}

}