package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/SportsEvent
 * Event type: Sports event.
 * @author schema.org
 * @module schema.org
 * @class SportsEvent
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
	 * @type schema,SportsTeam | schema,Person	 */
	public Object awayTeam;

	/**
	 * Schema.org/competitor
	 * A competitor in a sports event.
	 * @property competitor
	 * @type schema,SportsTeam | schema,Person	 */
	public Object competitor;

	/**
	 * Schema.org/homeTeam
	 * The home team in a sports event.
	 * @property homeTeam
	 * @type schema,SportsTeam | schema,Person	 */
	public Object homeTeam;

}