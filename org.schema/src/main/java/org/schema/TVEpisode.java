package org.schema;

/**
 * Schema.org/TVEpisode
 * A TV episode which can be part of a series or season.
 * @author schema.org
 * @class TVEpisode
 * @module org.schema
 * @extends Episode
 */
public class TVEpisode extends Episode
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public TVEpisode()
	{
		context="http://schema.org/";
		type="TVEpisode";
	}

	/**
	 * Schema.org/subtitleLanguage
	 * Languages in which subtitles/captions are available, in [IETF BCP 47 standard format](http://tools.ietf.org/html/bcp47).
	 * @property subtitleLanguage
	 * @type schema,Text | schema,Language
	 */
	public Object subtitleLanguage;

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