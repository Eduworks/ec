package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Duration
 * Quantity: Duration (use [ISO 8601 duration format](http://en.wikipedia.org/wiki/ISO_8601)).
 * @author schema.org
 * @module schema.org
 * @class Duration
 * @extends Quantity
 */
public class Duration extends Quantity
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Duration()
	{
		context="http://schema.org/";
		type="Duration";
	}

}