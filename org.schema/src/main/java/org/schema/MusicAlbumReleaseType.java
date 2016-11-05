package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/MusicAlbumReleaseType
 * The kind of release which this album is: single, EP or album.
 * @author schema.org
 * @module schema.org
 * @class MusicAlbumReleaseType
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