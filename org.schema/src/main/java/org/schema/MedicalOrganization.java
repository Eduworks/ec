package org.schema;

/**
 * Schema.org/MedicalOrganization
 * A medical organization (physical or not), such as hospital, institution or clinic.
 * @author schema.org
 * @class MedicalOrganization
 * @module org.schema
 * @extends Organization
 */
public class MedicalOrganization extends Organization
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public MedicalOrganization()
	{
		context="http://schema.org/";
		type="MedicalOrganization";
	}

}