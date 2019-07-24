package org.schema;

/**
 * Schema.org/HighSchool
 * A high school.
 *
 * @author schema.org
 * @class HighSchool
 * @module org.schema
 * @extends EducationalOrganization
 */
public class HighSchool extends EducationalOrganization {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public HighSchool() {
		context = "http://schema.org/";
		type = "HighSchool";
	}

}