package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/MusicEvent
 * Event type: Music event.
 * @author schema.org
 * @module schema.org
 * @class MusicEvent
 * @extends Event
 */
public class MusicEvent extends Event
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public MusicEvent()
	{
		context="http://schema.org/";
		type="MusicEvent";
	}

}