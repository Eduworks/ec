package org.schema;

/**
 * Schema.org/SaleEvent
 * Event type: Sales event.
 *
 * @author schema.org
 * @class SaleEvent
 * @module org.schema
 * @extends Event
 */
public class SaleEvent extends Event {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public SaleEvent() {
		context = "http://schema.org/";
		type = "SaleEvent";
	}

}