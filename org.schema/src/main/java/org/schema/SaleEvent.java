package org.schema;

/**
 * Schema.org/SaleEvent
 * SchemaEvent type: Sales event.
 *
 * @author schema.org
 * @class SaleEvent
 * @module org.schema
 * @extends SchemaEvent
 */
public class SaleEvent extends SchemaEvent {
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