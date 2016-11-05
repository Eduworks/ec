package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/ItemAvailability
 * A list of possible product availability options.
 * @author schema.org
 * @module schema.org
 * @class ItemAvailability
 * @extends Enumeration
 */
public class ItemAvailability extends Enumeration
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ItemAvailability()
	{
		context="http://schema.org/";
		type="ItemAvailability";
	}

}