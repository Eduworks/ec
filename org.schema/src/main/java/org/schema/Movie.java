package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Movie
 * A movie.
 * @author schema.org
 * @class Movie
 * @module org.schema
 * @extends CreativeWork
 */
public class Movie extends CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Movie()
	{
		context="http://schema.org/";
		type="Movie";
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
	 * Schema.org/subtitleLanguage
	 * Languages in which subtitles/captions are available, in [IETF BCP 47 standard format](http://tools.ietf.org/html/bcp47).
	 * @property subtitleLanguage
	 * @type schema,Language | schema,Text
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
	 * Schema.org/duration
	 * The duration of the item (movie, audio recording, event, etc.) in [ISO 8601 date format](http://en.wikipedia.org/wiki/ISO_8601).
	 * @property duration
	 * @type Duration
	 */
	public Duration duration;

	/**
	 * Schema.org/actor
	 * An actor, e.g. in tv, radio, movie, video games etc., or in an event. Actors can be associated with individual items or with a series, episode, clip.
	 * @property actor
	 * @type Person
	 */
	public Person actor;

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

}