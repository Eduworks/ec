package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/MusicVenue
 * A music venue.
 * @author schema.org
 * @module schema.org
 * @class MusicVenue
 * @extends CivicStructure
 */
public class MusicVenue extends CivicStructure
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public MusicVenue()
	{
		context="http://schema.org/";
		type="MusicVenue";
	}

}