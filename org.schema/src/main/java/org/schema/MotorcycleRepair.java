package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/MotorcycleRepair
 * A motorcycle repair shop.
 * @author schema.org
 * @module schema.org
 * @class MotorcycleRepair
 * @extends AutomotiveBusiness
 */
public class MotorcycleRepair extends AutomotiveBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public MotorcycleRepair()
	{
		context="http://schema.org/";
		type="MotorcycleRepair";
	}

}