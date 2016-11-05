package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/ComedyClub
 * A comedy club.
 * @author schema.org
 * @module schema.org
 * @class ComedyClub
 * @extends EntertainmentBusiness
 */
public class ComedyClub extends EntertainmentBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ComedyClub()
	{
		context="http://schema.org/";
		type="ComedyClub";
	}

}