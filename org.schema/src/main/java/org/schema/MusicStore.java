package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/MusicStore
 * A music store.
 * @author schema.org
 * @module schema.org
 * @class MusicStore
 * @extends Store
 */
public class MusicStore extends Store
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public MusicStore()
	{
		context="http://schema.org/";
		type="MusicStore";
	}

}