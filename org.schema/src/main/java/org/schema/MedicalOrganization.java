package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/MedicalOrganization
 * A medical organization (physical or not), such as hospital, institution or clinic.
 * @author schema.org
 * @module schema.org
 * @class MedicalOrganization
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