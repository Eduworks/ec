package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/EmploymentAgency
 * An employment agency.
 * @author schema.org
 * @class EmploymentAgency
 * @module org.schema
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