package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/BroadcastEvent
 * An over the air or online broadcast event.
 * @author schema.org
 * @class BroadcastEvent
 * @module org.schema
 * @extends PublicationEvent
 */
public class BroadcastEvent extends PublicationEvent
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public BroadcastEvent()
	{
		context="http://schema.org/";
		type="BroadcastEvent";
	}

	/**
	 * Schema.org/videoFormat
	 * The type of screening or video broadcast used (e.g. IMAX, 3D, SD, HD, etc.).
	 * @property videoFormat
	 * @type Text
	 */
	public String videoFormat;

	/**
	 * Schema.org/broadcastOfEvent
	 * The event being broadcast such as a sporting event or awards ceremony.
	 * @property broadcastOfEvent
	 * @type Event
	 */
	public Event broadcastOfEvent;

	/**
	 * Schema.org/isLiveBroadcast
	 * True is the broadcast is of a live event.
	 * @property isLiveBroadcast
	 * @type Boolean
	 */
	public Boolean isLiveBroadcast;

}