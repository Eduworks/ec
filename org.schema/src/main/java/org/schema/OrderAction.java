package org.schema;

/**
 * Schema.org/OrderAction
 * An agent orders an object/product/service to be delivered/sent.
 *
 * @author schema.org
 * @class OrderAction
 * @module org.schema
 * @extends TradeAction
 */
public class OrderAction extends TradeAction {
	/**
	 * Schema.org/deliveryMethod
	 * A sub property of instrument. The method of delivery.
	 *
	 * @property deliveryMethod
	 * @type DeliveryMethod
	 */
	public DeliveryMethod deliveryMethod;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public OrderAction() {
		context = "http://schema.org/";
		type = "OrderAction";
	}

}