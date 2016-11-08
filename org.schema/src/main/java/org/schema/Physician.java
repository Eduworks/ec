package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Physician
 * A doctor's office.
 * @author schema.org
 * @class Physician
 * @module org.schema
 * @extends MedicalOrganization
 */
public class Physician extends MedicalOrganization
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Physician()
	{
		context="http://schema.org/";
		type="Physician";
	}

}