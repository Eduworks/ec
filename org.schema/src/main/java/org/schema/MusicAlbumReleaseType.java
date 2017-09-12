package org.schema;

/**
 * Schema.org/MusicAlbumReleaseType
 * The kind of release which this album is: single, EP or album.
 * @author schema.org
 * @class MusicAlbumReleaseType
 * @module org.schema
 * @extends Enumeration
 */
public class MusicAlbumReleaseType extends Enumeration
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public MusicAlbumReleaseType()
	{
		context="http://schema.org/";
		type="MusicAlbumReleaseType";
	}

}