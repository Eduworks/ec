package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/SportsTeam
 * Organization: Sports team.
 * @author schema.org
 * @module schema.org
 * @class SportsTeam
 * @extends SportsOrganization
 */
public class SportsTeam extends SportsOrganization
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public SportsTeam()
	{
		context="http://schema.org/";
		type="SportsTeam";
	}

	/**
	 * Schema.org/athlete
	 * A person that acts as performing member of a sports team; a player as opposed to a coach.
	 * @property athlete
	 * @type Person
	 */
	public Person athlete;

	/**
	 * Schema.org/coach
	 * A person that acts in a coaching role for a sports team.
	 * @property coach
	 * @type Person
	 */
	public Person coach;

}