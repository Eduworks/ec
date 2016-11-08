package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/EducationalOrganization
 * An educational organization.
 * @author schema.org
 * @class EducationalOrganization
 * @module org.schema
 * @extends Organization
 */
public class EducationalOrganization extends Organization
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public EducationalOrganization()
	{
		context="http://schema.org/";
		type="EducationalOrganization";
	}

	/**
	 * Schema.org/alumni
	 * Alumni of an organization.
	 * @property alumni
	 * @type Person
	 */
	public Person alumni;

}