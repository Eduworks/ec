package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Hospital
 * A hospital.
 * @author schema.org
 * @class Hospital
 * @module org.schema
 * @extends EmergencyService
 */
public class Hospital extends EmergencyService
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