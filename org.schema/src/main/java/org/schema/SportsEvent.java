package org.schema;

/**
 * Schema.org/SportsEvent
 * Event type: Sports event.
 * @author schema.org
 * @class SportsEvent
 * @module org.schema
 * @extends Event
 */
public class SportsEvent extends Event
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public SportsEvent()
	{
		context="http://schema.org/";
		type="SportsEvent";
	}

	/**
	 * Schema.org/awayTeam
	 * The away team in a sports event.
	 * @property awayTeam
	 * @type schema,Person | schema,SportsTeam
	 */
	public Object awayTeam;

	/**
	 * Schema.org/competitor
	 * A competitor in a sports event.
	 * @property competitor
	 * @type schema,Person | schema,SportsTeam
	 */
	public Object competitor;

	/**
	 * Schema.org/homeTeam
	 * The home team in a sports event.
	 * @property homeTeam
	 * @type schema,Person | schema,SportsTeam
	 */
	public Object homeTeam;

}