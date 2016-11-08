package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/School
 * A school.
 * @author schema.org
 * @class School
 * @module org.schema
 * @extends EducationalOrganization
 */
public class School extends EducationalOrganization
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public School()
	{
		context="http://schema.org/";
		type="School";
	}

}