package org.schema;

/**
 * Schema.org/LockerDelivery
 * A DeliveryMethod in which an item is made available via locker.
 *
 * @author schema.org
 * @class LockerDelivery
 * @module org.schema
 * @extends DeliveryMethod
 */
public class LockerDelivery extends DeliveryMethod {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public LockerDelivery() {
		context = "http://schema.org/";
		type = "LockerDelivery";
	}

}