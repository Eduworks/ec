package org.schema;

/**
 * Schema.org/MusicEvent
 * SchemaEvent type: Music event.
 *
 * @author schema.org
 * @class MusicEvent
 * @module org.schema
 * @extends SchemaEvent
 */
public class MusicEvent extends SchemaEvent {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public MusicEvent() {
		context = "http://schema.org/";
		type = "MusicEvent";
	}

}