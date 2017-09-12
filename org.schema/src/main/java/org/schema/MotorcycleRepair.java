package org.schema;

/**
 * Schema.org/MotorcycleRepair
 * A motorcycle repair shop.
 *
 * @author schema.org
 * @class MotorcycleRepair
 * @module org.schema
 * @extends AutomotiveBusiness
 */
public class MotorcycleRepair extends AutomotiveBusiness {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public MotorcycleRepair() {
		context = "http://schema.org/";
		type = "MotorcycleRepair";
	}

}