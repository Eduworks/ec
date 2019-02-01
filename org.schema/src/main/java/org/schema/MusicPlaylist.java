package org.schema;

/**
 * Schema.org/MusicPlaylist
 * A collection of music tracks in playlist form.
 *
 * @author schema.org
 * @class MusicPlaylist
 * @module org.schema
 * @extends CreativeWork
 */
public class MusicPlaylist extends CreativeWork {
	/**
	 * Schema.org/track
	 * A music recording (track)&#x2014;usually a single song. If an ItemList is given, the list should contain items of type MusicRecording.
	 *
	 * @property track
	 * @type MusicRecording
	 */
	public MusicRecording track;
	/**
	 * Schema.org/numTracks
	 * The number of tracks in this album or playlist.
	 *
	 * @property numTracks
	 * @type Integer
	 */
	public Integer numTracks;
	/**
	 * Schema.org/tracks
	 * A music recording (track)&#x2014;usually a single song.
	 *
	 * @property tracks
	 * @type MusicRecording
	 */
	public MusicRecording tracks;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public MusicPlaylist() {
		context = "http://schema.org/";
		type = "MusicPlaylist";
	}

}