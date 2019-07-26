package org.schema;

/**
 * Schema.org/ComedyEvent
 * Event type: Comedy event.
 *
 * @author schema.org
 * @class ComedyEvent
 * @module org.schema
 * @extends Event
 */
public class ComedyEvent extends Event {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ComedyEvent() {
		context = "http://schema.org/";
		type = "ComedyEvent";
	}

}