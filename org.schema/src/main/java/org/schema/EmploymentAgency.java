package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/EmploymentAgency
 * An employment agency.
 * @author schema.org
 * @module schema.org
 * @class EmploymentAgency
 * @extends LocalBusiness
 */
public class EmploymentAgency extends LocalBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public EmploymentAgency()
	{
		context="http://schema.org/";
		type="EmploymentAgency";
	}

}