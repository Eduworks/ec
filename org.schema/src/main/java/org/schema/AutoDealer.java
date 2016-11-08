package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/AutoDealer
 * An car dealership.
 * @author schema.org
 * @class AutoDealer
 * @module org.schema
 * @extends AutomotiveBusiness
 */
public class AutoDealer extends AutomotiveBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public AutoDealer()
	{
		context="http://schema.org/";
		type="AutoDealer";
	}

}