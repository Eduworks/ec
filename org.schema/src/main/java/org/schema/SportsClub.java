package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/SportsClub
 * A sports club.
 * @author schema.org
 * @module schema.org
 * @class SportsClub
 * @extends SportsActivityLocation
 */
public class SportsClub extends SportsActivityLocation
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public SportsClub()
	{
		context="http://schema.org/";
		type="SportsClub";
	}

}