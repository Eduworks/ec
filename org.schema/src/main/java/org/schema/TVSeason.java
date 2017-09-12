package org.schema;

/**
 * Schema.org/TVSeason
 * Season dedicated to TV broadcast and associated online delivery.
 *
 * @author schema.org
 * @class TVSeason
 * @module org.schema
 * @extends CreativeWorkSeason
 */
public class TVSeason extends CreativeWorkSeason {
	/**
	 * Schema.org/countryOfOrigin
	 * The country of the principal offices of the production company or individual responsible for the movie or program.
	 *
	 * @property countryOfOrigin
	 * @type Country
	 */
	public Country countryOfOrigin;
	/**
	 * Schema.org/partOfTVSeries
	 * The TV series to which this episode or season belongs.
	 *
	 * @property partOfTVSeries
	 * @type TVSeries
	 */
	public TVSeries partOfTVSeries;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public TVSeason() {
		context = "http://schema.org/";
		type = "TVSeason";
	}

}