package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Episode
 * A media episode (e.g. TV, radio, video game) which can be part of a series or season.
 * @author schema.org
 * @class Episode
 * @module org.schema
 * @extends CreativeWork
 */
public class Episode extends CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Episode()
	{
		context="http://schema.org/";
		type="Episode";
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
	 * Schema.org/director
	 * A director of e.g. tv, radio, movie, video gaming etc. content, or of an event. Directors can be associated with individual items or with a series, episode, clip.
	 * @property director
	 * @type Person
	 */
	public Person director;

	/**
	 * Schema.org/partOfSeason
	 * The season to which this episode belongs.
	 * @property partOfSeason
	 * @type CreativeWorkSeason
	 */
	public CreativeWorkSeason partOfSeason;

	/**
	 * Schema.org/actor
	 * An actor, e.g. in tv, radio, movie, video games etc., or in an event. Actors can be associated with individual items or with a series, episode, clip.
	 * @property actor
	 * @type Person
	 */
	public Person actor;

	/**
	 * Schema.org/episodeNumber
	 * Position of the episode within an ordered group of episodes.
	 * @property episodeNumber
	 * @type schema,Integer | schema,Text
	 */
	public Object episodeNumber;

	/**
	 * Schema.org/actors
	 * An actor, e.g. in tv, radio, movie, video games etc. Actors can be associated with individual items or with a series, episode, clip.
	 * @property actors
	 * @type Person
	 */
	public Person actors;

	/**
	 * Schema.org/productionCompany
	 * The production company or studio responsible for the item e.g. series, video game, episode etc.
	 * @property productionCompany
	 * @type Organization
	 */
	public Organization productionCompany;

	/**
	 * Schema.org/directors
	 * A director of e.g. tv, radio, movie, video games etc. content. Directors can be associated with individual items or with a series, episode, clip.
	 * @property directors
	 * @type Person
	 */
	public Person directors;

	/**
	 * Schema.org/partOfSeries
	 * The series to which this episode or season belongs.
	 * @property partOfSeries
	 * @type CreativeWorkSeries
	 */
	public CreativeWorkSeries partOfSeries;

}