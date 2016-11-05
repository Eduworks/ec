package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/TelevisionChannel
 * A unique instance of a television BroadcastService on a CableOrSatelliteService lineup.
 * @author schema.org
 * @module schema.org
 * @class TelevisionChannel
 * @extends BroadcastChannel
 */
public class TelevisionChannel extends BroadcastChannel
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public TelevisionChannel()
	{
		context="http://schema.org/";
		type="TelevisionChannel";
	}

}