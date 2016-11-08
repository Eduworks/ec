package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Dentist
 * A dentist.
 * @author schema.org
 * @class Dentist
 * @module org.schema
 * @extends MedicalOrganization
 */
public class Dentist extends MedicalOrganization
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Dentist()
	{
		context="http://schema.org/";
		type="Dentist";
	}

}