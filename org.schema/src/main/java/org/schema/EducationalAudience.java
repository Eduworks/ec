package org.schema;

/**
 * Schema.org/EducationalAudience
 * An EducationalAudience.
 *
 * @author schema.org
 * @class EducationalAudience
 * @module org.schema
 * @extends Audience
 */
public class EducationalAudience extends Audience {
	/**
	 * Schema.org/educationalRole
	 * An educationalRole of an EducationalAudience.
	 *
	 * @property educationalRole
	 * @type Text
	 */
	public String educationalRole;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public EducationalAudience() {
		context = "http://schema.org/";
		type = "EducationalAudience";
	}

}