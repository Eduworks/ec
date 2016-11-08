package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/OrderAction
 * An agent orders an object/product/service to be delivered/sent.
 * @author schema.org
 * @class OrderAction
 * @module org.schema
 * @extends TradeAction
 */
public class OrderAction extends TradeAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public OrderAction()
	{
		context="http://schema.org/";
		type="OrderAction";
	}

	/**
	 * Schema.org/deliveryMethod
	 * A sub property of instrument. The method of delivery.
	 * @property deliveryMethod
	 * @type DeliveryMethod
	 */
	public DeliveryMethod deliveryMethod;

}