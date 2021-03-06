package org.schema;

/**
 * Schema.org/SportsTeam
 * Organization: Sports team.
 *
 * @author schema.org
 * @class SportsTeam
 * @module org.schema
 * @extends SportsOrganization
 */
public class SportsTeam extends SportsOrganization {
	/**
	 * Schema.org/athlete
	 * A person that acts as performing member of a sports team; a player as opposed to a coach.
	 *
	 * @property athlete
	 * @type Person
	 */
	public Person athlete;
	/**
	 * Schema.org/coach
	 * A person that acts in a coaching role for a sports team.
	 *
	 * @property coach
	 * @type Person
	 */
	public Person coach;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public SportsTeam() {
		context = "http://schema.org/";
		type = "SportsTeam";
	}

}