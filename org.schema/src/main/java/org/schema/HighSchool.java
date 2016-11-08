package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/HighSchool
 * A high school.
 * @author schema.org
 * @class HighSchool
 * @module org.schema
 * @extends EducationalOrganization
 */
public class HighSchool extends EducationalOrganization
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public HighSchool()
	{
		context="http://schema.org/";
		type="HighSchool";
	}

}