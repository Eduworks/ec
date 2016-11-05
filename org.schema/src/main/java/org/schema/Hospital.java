package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Hospital
 * A hospital.
 * @author schema.org
 * @module schema.org
 * @class Hospital
 * @extends MedicalOrganization
 */
public class Hospital extends MedicalOrganization
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Hospital()
	{
		context="http://schema.org/";
		type="Hospital";
	}

}