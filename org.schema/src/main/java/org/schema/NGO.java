package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/NGO
 * Organization: Non-governmental Organization.
 * @author schema.org
 * @module schema.org
 * @class NGO
 * @extends Organization
 */
public class NGO extends Organization
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public NGO()
	{
		context="http://schema.org/";
		type="NGO";
	}

}