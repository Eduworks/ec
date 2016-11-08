package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/TVSeries
 * CreativeWorkSeries dedicated to TV broadcast and associated online delivery.
 * @author schema.org
 * @class TVSeries
 * @module org.schema
 * @extends CreativeWorkSeries
 */
public class TVSeries extends CreativeWorkSeries
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public TVSeries()
	{
		context="http://schema.org/";
		type="TVSeries";
	}

	/**
	 * Schema.org/musicBy
	 * The composer of the soundtrack.
	 * @property musicBy
	 * @type schema,Person | schema,MusicGroup
	 */
	public Object musicBy;

	/**
	 * Schema.org/trailer
	 * The trailer of a movie or tv/radio series, season, episode, etc.
	 * @property trailer
	 * @type VideoObject
	 */
	public VideoObject trailer;

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
	 * Schema.org/countryOfOrigin
	 * The country of the principal offices of the production company or individual responsible for the movie or program.
	 * @property countryOfOrigin
	 * @type Country
	 */
	public Country countryOfOrigin;

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
	 * Schema.org/containsSeason
	 * A season that is part of the media series.
	 * @property containsSeason
	 * @type CreativeWorkSeason
	 */
	public CreativeWorkSeason containsSeason;

	/**
	 * Schema.org/actors
	 * An actor, e.g. in tv, radio, movie, video games etc. Actors can be associated with individual items or with a series, episode, clip.
	 * @property actors
	 * @type Person
	 */
	public Person actors;

	/**
	 * Schema.org/seasons
	 * A season in a media series.
	 * @property seasons
	 * @type CreativeWorkSeason
	 */
	public CreativeWorkSeason seasons;

	/**
	 * Schema.org/numberOfSeasons
	 * The number of seasons in this series.
	 * @property numberOfSeasons
	 * @type Integer
	 */
	public Integer numberOfSeasons;

	/**
	 * Schema.org/season
	 * A season in a media series.
	 * @property season
	 * @type CreativeWorkSeason
	 */
	public CreativeWorkSeason season;

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
	 * Schema.org/directors
	 * A director of e.g. tv, radio, movie, video games etc. content. Directors can be associated with individual items or with a series, episode, clip.
	 * @property directors
	 * @type Person
	 */
	public Person directors;

}