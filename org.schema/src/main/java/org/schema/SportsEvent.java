package org.schema;

/**
 * Schema.org/SportsEvent
 * Event type: Sports event.
 *
 * @author schema.org
 * @class SportsEvent
 * @module org.schema
 * @extends Event
 */
public class SportsEvent extends Event {
	/**
	 * Schema.org/awayTeam
	 * The away team in a sports event.
	 *
	 * @property awayTeam
	 * @type Person
	 */
	public Person awayTeam;
	/**
	 * Schema.org/homeTeam
	 * The home team in a sports event.
	 *
	 * @property homeTeam
	 * @type SportsTeam
	 */
	public SportsTeam homeTeam;
	/**
	 * Schema.org/competitor
	 * A competitor in a sports event.
	 *
	 * @property competitor
	 * @type Person
	 */
	public Person competitor;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public SportsEvent() {
		context = "http://schema.org/";
		type = "SportsEvent";
	}

}