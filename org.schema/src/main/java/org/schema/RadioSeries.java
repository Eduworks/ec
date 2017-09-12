package org.schema;

/**
 * Schema.org/RadioSeries
 * CreativeWorkSeries dedicated to radio broadcast and associated online delivery.
 *
 * @author schema.org
 * @class RadioSeries
 * @module org.schema
 * @extends CreativeWorkSeries
 */
public class RadioSeries extends CreativeWorkSeries {
	/**
	 * Schema.org/episodes
	 * An episode of a TV/radio series or season.
	 *
	 * @property episodes
	 * @type Episode
	 */
	public Episode episodes;
	/**
	 * Schema.org/director
	 * A director of e.g. tv, radio, movie, video gaming etc. content, or of an event. Directors can be associated with individual items or with a series, episode, clip.
	 *
	 * @property director
	 * @type Person
	 */
	public Person director;
	/**
	 * Schema.org/episode
	 * An episode of a tv, radio or game media within a series or season.
	 *
	 * @property episode
	 * @type Episode
	 */
	public Episode episode;
	/**
	 * Schema.org/actor
	 * An actor, e.g. in tv, radio, movie, video games etc., or in an event. Actors can be associated with individual items or with a series, episode, clip.
	 *
	 * @property actor
	 * @type Person
	 */
	public Person actor;
	/**
	 * Schema.org/containsSeason
	 * A season that is part of the media series.
	 *
	 * @property containsSeason
	 * @type CreativeWorkSeason
	 */
	public CreativeWorkSeason containsSeason;
	/**
	 * Schema.org/musicBy
	 * The composer of the soundtrack.
	 *
	 * @property musicBy
	 * @type schema, Person | schema,MusicGroup
	 */
	public Object musicBy;
	/**
	 * Schema.org/actors
	 * An actor, e.g. in tv, radio, movie, video games etc. Actors can be associated with individual items or with a series, episode, clip.
	 *
	 * @property actors
	 * @type Person
	 */
	public Person actors;
	/**
	 * Schema.org/seasons
	 * A season in a media series.
	 *
	 * @property seasons
	 * @type CreativeWorkSeason
	 */
	public CreativeWorkSeason seasons;
	/**
	 * Schema.org/trailer
	 * The trailer of a movie or tv/radio series, season, episode, etc.
	 *
	 * @property trailer
	 * @type VideoObject
	 */
	public VideoObject trailer;
	/**
	 * Schema.org/numberOfSeasons
	 * The number of seasons in this series.
	 *
	 * @property numberOfSeasons
	 * @type Integer
	 */
	public Integer numberOfSeasons;
	/**
	 * Schema.org/season
	 * A season in a media series.
	 *
	 * @property season
	 * @type CreativeWorkSeason
	 */
	public CreativeWorkSeason season;
	/**
	 * Schema.org/productionCompany
	 * The production company or studio responsible for the item e.g. series, video game, episode etc.
	 *
	 * @property productionCompany
	 * @type Organization
	 */
	public Organization productionCompany;
	/**
	 * Schema.org/numberOfEpisodes
	 * The number of episodes in this season or series.
	 *
	 * @property numberOfEpisodes
	 * @type Integer
	 */
	public Integer numberOfEpisodes;
	/**
	 * Schema.org/directors
	 * A director of e.g. tv, radio, movie, video games etc. content. Directors can be associated with individual items or with a series, episode, clip.
	 *
	 * @property directors
	 * @type Person
	 */
	public Person directors;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public RadioSeries() {
		context = "http://schema.org/";
		type = "RadioSeries";
	}

}