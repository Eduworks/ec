package org.schema;

/**
 * Schema.org/RadioEpisode
 * A radio episode which can be part of a series or season.
 * @author schema.org
 * @class RadioEpisode
 * @module org.schema
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