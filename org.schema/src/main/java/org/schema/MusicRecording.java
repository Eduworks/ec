package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/MusicRecording
 * A music recording (track), usually a single song.
 * @author schema.org
 * @class MusicRecording
 * @module org.schema
 * @extends CreativeWork
 */
public class MusicRecording extends CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public MusicRecording()
	{
		context="http://schema.org/";
		type="MusicRecording";
	}

	/**
	 * Schema.org/isrcCode
	 * The International Standard Recording Code for the recording.
	 * @property isrcCode
	 * @type Text
	 */
	public String isrcCode;

	/**
	 * Schema.org/inAlbum
	 * The album to which this recording belongs.
	 * @property inAlbum
	 * @type MusicAlbum
	 */
	public MusicAlbum inAlbum;

	/**
	 * Schema.org/recordingOf
	 * The composition this track is a recording of.
	 * @property recordingOf
	 * @type MusicComposition
	 */
	public MusicComposition recordingOf;

	/**
	 * Schema.org/inPlaylist
	 * The playlist to which this recording belongs.
	 * @property inPlaylist
	 * @type MusicPlaylist
	 */
	public MusicPlaylist inPlaylist;

	/**
	 * Schema.org/duration
	 * The duration of the item (movie, audio recording, event, etc.) in [ISO 8601 date format](http://en.wikipedia.org/wiki/ISO_8601).
	 * @property duration
	 * @type Duration
	 */
	public Duration duration;

	/**
	 * Schema.org/byArtist
	 * The artist that performed this album or recording.
	 * @property byArtist
	 * @type MusicGroup
	 */
	public MusicGroup byArtist;

}