package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/StadiumOrArena
 * A stadium.
 * @author schema.org
 * @module schema.org
 * @class StadiumOrArena
 * @extends SportsActivityLocation
 */
public class StadiumOrArena extends SportsActivityLocation
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public StadiumOrArena()
	{
		context="http://schema.org/";
		type="StadiumOrArena";
	}

}