package org.schema;

/**
 * Schema.org/VisualArtsEvent
 * SchemaEvent type: Visual arts event.
 *
 * @author schema.org
 * @class VisualArtsEvent
 * @module org.schema
 * @extends SchemaEvent
 */
public class VisualArtsEvent extends SchemaEvent {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public VisualArtsEvent() {
		context = "http://schema.org/";
		type = "VisualArtsEvent";
	}

}