package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Clip
 * A short TV or radio program or a segment/part of a program.
 * @author schema.org
 * @class Clip
 * @module org.schema
 * @extends CreativeWork
 */
public class Clip extends CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Clip()
	{
		context="http://schema.org/";
		type="Clip";
	}

	/**
	 * Schema.org/musicBy
	 * The composer of the soundtrack.
	 * @property musicBy
	 * @type schema,Person | schema,MusicGroup
	 */
	public Object musicBy;

	/**
	 * Schema.org/clipNumber
	 * Position of the clip within an ordered group of clips.
	 * @property clipNumber
	 * @type schema,Integer | schema,Text
	 */
	public Object clipNumber;

	/**
	 * Schema.org/director
	 * A director of e.g. tv, radio, movie, video gaming etc. content, or of an event. Directors can be associated with individual items or with a series, episode, clip.
	 * @property director
	 * @type Person
	 */
	public Person director;

	/**
	 * Schema.org/partOfEpisode
	 * The episode to which this clip belongs.
	 * @property partOfEpisode
	 * @type Episode
	 */
	public Episode partOfEpisode;

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
	 * Schema.org/actors
	 * An actor, e.g. in tv, radio, movie, video games etc. Actors can be associated with individual items or with a series, episode, clip.
	 * @property actors
	 * @type Person
	 */
	public Person actors;

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