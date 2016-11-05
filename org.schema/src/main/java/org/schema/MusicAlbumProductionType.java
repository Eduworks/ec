package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/MusicAlbumProductionType
 * Classification of the album by it's type of content: soundtrack, live album, studio album, etc.
 * @author schema.org
 * @module schema.org
 * @class MusicAlbumProductionType
 * @extends Enumeration
 */
public class MusicAlbumProductionType extends Enumeration
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public MusicAlbumProductionType()
	{
		context="http://schema.org/";
		type="MusicAlbumProductionType";
	}

}