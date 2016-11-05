package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/OrderStatus
 * Enumerated status values for Order.
 * @author schema.org
 * @module schema.org
 * @class OrderStatus
 * @extends Enumeration
 */
public class OrderStatus extends Enumeration
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public OrderStatus()
	{
		context="http://schema.org/";
		type="OrderStatus";
	}

}