package org.schema;

/**
 * Schema.org/SocialEvent
 * SchemaEvent type: Social event.
 *
 * @author schema.org
 * @class SocialEvent
 * @module org.schema
 * @extends SchemaEvent
 */
public class SocialEvent extends SchemaEvent {
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