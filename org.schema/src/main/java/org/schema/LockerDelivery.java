package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/LockerDelivery
 * A DeliveryMethod in which an item is made available via locker.
 * @author schema.org
 * @module schema.org
 * @class LockerDelivery
 * @extends DeliveryMethod
 */
public class LockerDelivery extends DeliveryMethod
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public LockerDelivery()
	{
		context="http://schema.org/";
		type="LockerDelivery";
	}

}