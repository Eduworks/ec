package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/SaleEvent
 * Event type: Sales event.
 * @author schema.org
 * @module schema.org
 * @class SaleEvent
 * @extends Event
 */
public class SaleEvent extends Event
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public SaleEvent()
	{
		context="http://schema.org/";
		type="SaleEvent";
	}

}