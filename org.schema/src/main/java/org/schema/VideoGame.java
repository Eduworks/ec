package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/VideoGame
 * A video game is an electronic game that involves human interaction with a user interface to generate visual feedback on a video device.
 * @author schema.org
 * @module schema.org
 * @class VideoGame
 * @extends SoftwareApplication
 */
public class VideoGame extends SoftwareApplication
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public VideoGame()
	{
		context="http://schema.org/";
		type="VideoGame";
	}

	/**
	 * Schema.org/musicBy
	 * The composer of the soundtrack.
	 * @property musicBy
	 * @type schema,MusicGroup | schema,Person	 */
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
	 * Schema.org/gameServer
	 * The server on which  it is possible to play the game.
	 * @property gameServer
	 * @type GameServer
	 */
	public GameServer gameServer;

	/**
	 * Schema.org/cheatCode
	 * Cheat codes to the game.
	 * @property cheatCode
	 * @type CreativeWork
	 */
	public CreativeWork cheatCode;

	/**
	 * Schema.org/actor
	 * An actor, e.g. in tv, radio, movie, video games etc., or in an event. Actors can be associated with individual items or with a series, episode, clip.
	 * @property actor
	 * @type Person
	 */
	public Person actor;

	/**
	 * Schema.org/gameTip
	 * Links to tips, tactics, etc.
	 * @property gameTip
	 * @type CreativeWork
	 */
	public CreativeWork gameTip;

	/**
	 * Schema.org/actors
	 * An actor, e.g. in tv, radio, movie, video games etc. Actors can be associated with individual items or with a series, episode, clip.
	 * @property actors
	 * @type Person
	 */
	public Person actors;

	/**
	 * Schema.org/playMode
	 * Indicates whether this game is multi-player, co-op or single-player.  The game can be marked as multi-player, co-op and single-player at the same time.
	 * @property playMode
	 * @type GamePlayMode
	 */
	public GamePlayMode playMode;

	/**
	 * Schema.org/gamePlatform
	 * The electronic systems used to play <a href="http://en.wikipedia.org/wiki/Category:Video_game_platforms">video games</a>.
	 * @property gamePlatform
	 * @type schema,Thing | schema,Text | schema,URL	 */
	public Object gamePlatform;

	/**
	 * Schema.org/directors
	 * A director of e.g. tv, radio, movie, video games etc. content. Directors can be associated with individual items or with a series, episode, clip.
	 * @property directors
	 * @type Person
	 */
	public Person directors;

}