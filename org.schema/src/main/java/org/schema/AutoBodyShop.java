package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/AutoBodyShop
 * Auto body shop.
 * @author schema.org
 * @class AutoBodyShop
 * @module org.schema
 * @extends AutomotiveBusiness
 */
public class AutoBodyShop extends AutomotiveBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public AutoBodyShop()
	{
		context="http://schema.org/";
		type="AutoBodyShop";
	}

}