package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/TVSeason
 * Season dedicated to TV broadcast and associated online delivery.
 * @author schema.org
 * @module schema.org
 * @class TVSeason
 * @extends CreativeWork
 */
public class TVSeason extends CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public TVSeason()
	{
		context="http://schema.org/";
		type="TVSeason";
	}

	/**
	 * Schema.org/countryOfOrigin
	 * The country of the principal offices of the production company or individual responsible for the movie or program.
	 * @property countryOfOrigin
	 * @type Country
	 */
	public Country countryOfOrigin;

	/**
	 * Schema.org/partOfTVSeries
	 * The TV series to which this episode or season belongs.
	 * @property partOfTVSeries
	 * @type TVSeries
	 */
	public TVSeries partOfTVSeries;

}