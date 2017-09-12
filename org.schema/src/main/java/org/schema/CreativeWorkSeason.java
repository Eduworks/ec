package org.schema;

/**
 * Schema.org/CreativeWorkSeason
 * A media season e.g. tv, radio, video game etc.
 * @author schema.org
 * @class CreativeWorkSeason
 * @module org.schema
 * @extends CreativeWork
 */
public class CreativeWorkSeason extends CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public CreativeWorkSeason()
	{
		context="http://schema.org/";
		type="CreativeWorkSeason";
	}

	/**
	 * Schema.org/episodes
	 * An episode of a TV/radio series or season.
	 * @property episodes
	 * @type Episode
	 */
	public Episode episodes;

	/**
	 * Schema.org/director
	 * A director of e.g. tv, radio, movie, video gaming etc. content, or of an event. Directors can be associated with individual items or with a series, episode, clip.
	 * @property director
	 * @type Person
	 */
	public Person director;

	/**
	 * Schema.org/seasonNumber
	 * Position of the season within an ordered group of seasons.
	 * @property seasonNumber
	 * @type schema,Integer | schema,Text
	 */
	public Object seasonNumber;

	/**
	 * Schema.org/episode
	 * An episode of a tv, radio or game media within a series or season.
	 * @property episode
	 * @type Episode
	 */
	public Episode episode;

	/**
	 * Schema.org/actor
	 * An actor, e.g. in tv, radio, movie, video games etc., or in an event. Actors can be associated with individual items or with a series, episode, clip.
	 * @property actor
	 * @type Person
	 */
	public Person actor;

	/**
	 * Schema.org/trailer
	 * The trailer of a movie or tv/radio series, season, episode, etc.
	 * @property trailer
	 * @type VideoObject
	 */
	public VideoObject trailer;

	/**
	 * Schema.org/startDate
	 * The start date and time of the item (in [ISO 8601 date format](http://en.wikipedia.org/wiki/ISO_8601)).
	 * @property startDate
	 * @type schema,DateTime | schema,Date
	 */
	public Object startDate;

	/**
	 * Schema.org/productionCompany
	 * The production company or studio responsible for the item e.g. series, video game, episode etc.
	 * @property productionCompany
	 * @type Organization
	 */
	public Organization productionCompany;

	/**
	 * Schema.org/numberOfEpisodes
	 * The number of episodes in this season or series.
	 * @property numberOfEpisodes
	 * @type Integer
	 */
	public Integer numberOfEpisodes;

	/**
	 * Schema.org/partOfSeries
	 * The series to which this episode or season belongs.
	 * @property partOfSeries
	 * @type CreativeWorkSeries
	 */
	public CreativeWorkSeries partOfSeries;

	/**
	 * Schema.org/endDate
	 * The end date and time of the item (in [ISO 8601 date format](http://en.wikipedia.org/wiki/ISO_8601)).
	 * @property endDate
	 * @type schema,DateTime | schema,Date
	 */
	public Object endDate;

}