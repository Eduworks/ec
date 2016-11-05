package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/AutoRental
 * A car rental business.
 * @author schema.org
 * @module schema.org
 * @class AutoRental
 * @extends AutomotiveBusiness
 */
public class AutoRental extends AutomotiveBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public AutoRental()
	{
		context="http://schema.org/";
		type="AutoRental";
	}

}