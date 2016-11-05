package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Residence
 * The place where a person lives.
 * @author schema.org
 * @module schema.org
 * @class Residence
 * @extends Place
 */
public class Residence extends Place
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Residence()
	{
		context="http://schema.org/";
		type="Residence";
	}

}