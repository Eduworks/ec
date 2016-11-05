package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/RadioEpisode
 * A radio episode which can be part of a series or season.
 * @author schema.org
 * @module schema.org
 * @class RadioEpisode
 * @extends Episode
 */
public class RadioEpisode extends Episode
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public RadioEpisode()
	{
		context="http://schema.org/";
		type="RadioEpisode";
	}

}