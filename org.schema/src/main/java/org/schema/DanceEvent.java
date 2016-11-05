package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/DanceEvent
 * Event type: A social dance.
 * @author schema.org
 * @module schema.org
 * @class DanceEvent
 * @extends Event
 */
public class DanceEvent extends Event
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public DanceEvent()
	{
		context="http://schema.org/";
		type="DanceEvent";
	}

}