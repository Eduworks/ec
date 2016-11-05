package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Taxi
 * A taxi.
 * @author schema.org
 * @module schema.org
 * @class Taxi
 * @extends Service
 */
public class Taxi extends Service
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Taxi()
	{
		context="http://schema.org/";
		type="Taxi";
	}

}