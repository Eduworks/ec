package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/SkiResort
 * A ski resort.
 * @author schema.org
 * @class SkiResort
 * @module org.schema
 * @extends SportsActivityLocation
 */
public class SkiResort extends SportsActivityLocation
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public SkiResort()
	{
		context="http://schema.org/";
		type="SkiResort";
	}

}