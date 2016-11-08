package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/AutomotiveBusiness
 * Car repair, sales, or parts.
 * @author schema.org
 * @class AutomotiveBusiness
 * @module org.schema
 * @extends LocalBusiness
 */
public class AutomotiveBusiness extends LocalBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public AutomotiveBusiness()
	{
		context="http://schema.org/";
		type="AutomotiveBusiness";
	}

}