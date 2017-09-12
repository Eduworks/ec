package org.schema;

/**
 * Schema.org/Preschool
 * A preschool.
 * @author schema.org
 * @class Preschool
 * @module org.schema
 * @extends EducationalOrganization
 */
public class Preschool extends EducationalOrganization
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Preschool()
	{
		context="http://schema.org/";
		type="Preschool";
	}

}