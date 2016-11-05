package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/ComedyEvent
 * Event type: Comedy event.
 * @author schema.org
 * @module schema.org
 * @class ComedyEvent
 * @extends Event
 */
public class ComedyEvent extends Event
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ComedyEvent()
	{
		context="http://schema.org/";
		type="ComedyEvent";
	}

}