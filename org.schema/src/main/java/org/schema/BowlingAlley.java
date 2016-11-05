package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/BowlingAlley
 * A bowling alley.
 * @author schema.org
 * @module schema.org
 * @class BowlingAlley
 * @extends SportsActivityLocation
 */
public class BowlingAlley extends SportsActivityLocation
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public BowlingAlley()
	{
		context="http://schema.org/";
		type="BowlingAlley";
	}

}