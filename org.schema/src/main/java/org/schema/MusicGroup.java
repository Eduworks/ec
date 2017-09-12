package org.schema;

/**
 * Schema.org/MusicGroup
 * A musical group, such as a band, an orchestra, or a choir. Can also be a solo musician.
 * @author schema.org
 * @class MusicGroup
 * @module org.schema
 * @extends PerformingGroup
 */
public class MusicGroup extends PerformingGroup
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public MusicGroup()
	{
		context="http://schema.org/";
		type="MusicGroup";
	}

	/**
	 * Schema.org/albums
	 * A collection of music albums.
	 * @property albums
	 * @type MusicAlbum
	 */
	public MusicAlbum albums;

	/**
	 * Schema.org/genre
	 * Genre of the creative work, broadcast channel or group.
	 * @property genre
	 * @type schema,URL | schema,Text
	 */
	public Object genre;

	/**
	 * Schema.org/musicGroupMember
	 * A member of a music group&#x2014;for example, John, Paul, George, or Ringo.
	 * @property musicGroupMember
	 * @type Person
	 */
	public Person musicGroupMember;

	/**
	 * Schema.org/tracks
	 * A music recording (track)&#x2014;usually a single song.
	 * @property tracks
	 * @type MusicRecording
	 */
	public MusicRecording tracks;

	/**
	 * Schema.org/track
	 * A music recording (track)&#x2014;usually a single song. If an ItemList is given, the list should contain items of type MusicRecording.
	 * @property track
	 * @type schema,MusicRecording | schema,ItemList
	 */
	public Object track;

	/**
	 * Schema.org/album
	 * A music album.
	 * @property album
	 * @type MusicAlbum
	 */
	public MusicAlbum album;

}