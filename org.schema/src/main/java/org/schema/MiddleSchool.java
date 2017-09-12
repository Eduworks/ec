package org.schema;

/**
 * Schema.org/MiddleSchool
 * A middle school (typically for children aged around 11-14, although this varies somewhat).
 * @author schema.org
 * @class MiddleSchool
 * @module org.schema
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