package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/MusicPlaylist
 * A collection of music tracks in playlist form.
 * @author schema.org
 * @module schema.org
 * @class MusicPlaylist
 * @extends CreativeWork
 */
public class MusicPlaylist extends CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public MusicPlaylist()
	{
		context="http://schema.org/";
		type="MusicPlaylist";
	}

	/**
	 * Schema.org/numTracks
	 * The number of tracks in this album or playlist.
	 * @property numTracks
	 * @type Integer
	 */
	public Integer numTracks;

	/**
	 * Schema.org/track
	 * A music recording (track)&#x2014;usually a single song. If an ItemList is given, the list should contain items of type MusicRecording.
	 * @property track
	 * @type schema,ItemList | schema,MusicRecording	 */
	public Object track;

	/**
	 * Schema.org/tracks
	 * A music recording (track)&#x2014;usually a single song.
	 * @property tracks
	 * @type MusicRecording
	 */
	public MusicRecording tracks;

}