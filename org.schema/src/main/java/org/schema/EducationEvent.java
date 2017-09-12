package org.schema;

/**
 * Schema.org/EducationEvent
 * Event type: Education event.
 *
 * @author schema.org
 * @class EducationEvent
 * @module org.schema
 * @extends Event
 */
public class EducationEvent extends Event {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public EducationEvent() {
		context = "http://schema.org/";
		type = "EducationEvent";
	}

}