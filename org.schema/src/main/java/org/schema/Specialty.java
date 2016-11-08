package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Specialty
 * Any branch of a field in which people typically develop specific expertise, usually after significant study, time, and effort.
 * @author schema.org
 * @class Specialty
 * @module org.schema
 * @extends Enumeration
 */
public class Specialty extends Enumeration
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Specialty()
	{
		context="http://schema.org/";
		type="Specialty";
	}

}