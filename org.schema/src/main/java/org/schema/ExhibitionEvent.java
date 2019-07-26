package org.schema;

/**
 * Schema.org/ExhibitionEvent
 * Event type: Exhibition event, e.g. at a museum, library, archive, tradeshow, ...
 *
 * @author schema.org
 * @class ExhibitionEvent
 * @module org.schema
 * @extends Event
 */
public class ExhibitionEvent extends Event {
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