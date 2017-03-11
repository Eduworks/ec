package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/HealthClub
 * A health club.
 * @author schema.org
 * @class HealthClub
 * @module org.schema
 * @extends SportsActivityLocation
 */
public class HealthClub extends SportsActivityLocation
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public HealthClub()
	{
		context="http://schema.org/";
		type="HealthClub";
	}

}