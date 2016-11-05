package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/GovernmentOrganization
 * A governmental organization or agency.
 * @author schema.org
 * @module schema.org
 * @class GovernmentOrganization
 * @extends Organization
 */
public class GovernmentOrganization extends Organization
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public GovernmentOrganization()
	{
		context="http://schema.org/";
		type="GovernmentOrganization";
	}

}