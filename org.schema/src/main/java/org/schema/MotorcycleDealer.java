package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/MotorcycleDealer
 * A motorcycle dealer.
 * @author schema.org
 * @class MotorcycleDealer
 * @module org.schema
 * @extends AutomotiveBusiness
 */
public class MotorcycleDealer extends AutomotiveBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public MotorcycleDealer()
	{
		context="http://schema.org/";
		type="MotorcycleDealer";
	}

}