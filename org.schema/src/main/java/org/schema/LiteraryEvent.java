package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/LiteraryEvent
 * Event type: Literary event.
 * @author schema.org
 * @module schema.org
 * @class LiteraryEvent
 * @extends Event
 */
public class LiteraryEvent extends Event
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public LiteraryEvent()
	{
		context="http://schema.org/";
		type="LiteraryEvent";
	}

}