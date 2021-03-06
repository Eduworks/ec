package org.schema;

/**
 * Schema.org/CollegeOrUniversity
 * A college, university, or other third-level educational institution.
 *
 * @author schema.org
 * @class CollegeOrUniversity
 * @module org.schema
 * @extends EducationalOrganization
 */
public class CollegeOrUniversity extends EducationalOrganization {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public CollegeOrUniversity() {
		context = "http://schema.org/";
		type = "CollegeOrUniversity";
	}

}