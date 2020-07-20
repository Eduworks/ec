package org.schema;

/**
 * Schema.org/EducationEvent
 * SchemaEvent type: Education event.
 *
 * @author schema.org
 * @class EducationEvent
 * @module org.schema
 * @extends SchemaEvent
 */
public class EducationEvent extends SchemaEvent {
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