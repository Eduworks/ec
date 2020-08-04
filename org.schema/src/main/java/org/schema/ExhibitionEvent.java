package org.schema;

/**
 * Schema.org/ExhibitionEvent
 * SchemaEvent type: Exhibition event, e.g. at a museum, library, archive, tradeshow, ...
 *
 * @author schema.org
 * @class ExhibitionEvent
 * @module org.schema
 * @extends SchemaEvent
 */
public class ExhibitionEvent extends SchemaEvent {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ExhibitionEvent() {
		context = "http://schema.org/";
		type = "ExhibitionEvent";
	}

}