package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/BusinessEvent
 * Event type: Business event.
 * @author schema.org
 * @class BusinessEvent
 * @module org.schema
 * @extends Event
 */
public class BusinessEvent extends Event
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public BusinessEvent()
	{
		context="http://schema.org/";
		type="BusinessEvent";
	}

}