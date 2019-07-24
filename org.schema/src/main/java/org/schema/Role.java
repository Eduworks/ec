package org.schema;

/**
 * Schema.org/Role
 * Represents additional information about a relationship or property. For example a Role can be used to say that a 'member' role linking some SportsTeam to a player occurred during a particular time period. Or that a Person's 'actor' role in a Movie was for some particular characterName. Such properties can be attached to a Role entity, which is then associated with the main entities using ordinary properties like 'member' or 'actor'.\n\nSee also [blog post](http://blog.schema.org/2014/06/introducing-role.html).
 *
 * @author schema.org
 * @class Role
 * @module org.schema
 * @extends Intangible
 */
public class Role extends Intangible {
	/**
	 * Schema.org/endDate
	 * The end date and time of the item (in [ISO 8601 date format](http://en.wikipedia.org/wiki/ISO_8601)).
	 *
	 * @property endDate
	 * @type DateTime
	 */
	public String endDate;
	/**
	 * Schema.org/startDate
	 * The start date and time of the item (in [ISO 8601 date format](http://en.wikipedia.org/wiki/ISO_8601)).
	 *
	 * @property startDate
	 * @type Date
	 */
	public String startDate;
	/**
	 * Schema.org/namedPosition
	 * A position played, performed or filled by a person or organization, as part of an organization. For example, an athlete in a SportsTeam might play in the position named 'Quarterback'.
	 *
	 * @property namedPosition
	 * @type Text
	 */
	public String namedPosition;
	/**
	 * Schema.org/roleName
	 * A role played, performed or filled by a person or organization. For example, the team of creators for a comic book might fill the roles named 'inker', 'penciller', and 'letterer'; or an athlete in a SportsTeam might play in the position named 'Quarterback'.
	 *
	 * @property roleName
	 * @type Text
	 */
	public String roleName;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Role() {
		context = "http://schema.org/";
		type = "Role";
	}

}