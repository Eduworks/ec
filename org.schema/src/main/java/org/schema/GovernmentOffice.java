package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/GovernmentOffice
 * A government office&#x2014;for example, an IRS or DMV office.
 * @author schema.org
 * @class GovernmentOffice
 * @module org.schema
 * @extends LocalBusiness
 */
public class GovernmentOffice extends LocalBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public GovernmentOffice()
	{
		context="http://schema.org/";
		type="GovernmentOffice";
	}

}