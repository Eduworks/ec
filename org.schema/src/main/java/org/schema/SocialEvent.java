package org.schema;

/**
 * Schema.org/SocialEvent
 * Event type: Social event.
 *
 * @author schema.org
 * @class SocialEvent
 * @module org.schema
 * @extends Event
 */
public class SocialEvent extends Event {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public SocialEvent() {
		context = "http://schema.org/";
		type = "SocialEvent";
	}

}