package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/MiddleSchool
 * A middle school (typically for children aged around 11-14, although this varies somewhat).
 * @author schema.org
 * @module schema.org
 * @class MiddleSchool
 * @extends EducationalOrganization
 */
public class MiddleSchool extends EducationalOrganization
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public MiddleSchool()
	{
		context="http://schema.org/";
		type="MiddleSchool";
	}

}