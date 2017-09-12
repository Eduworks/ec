package org.schema;

/**
 * Schema.org/MusicVideoObject
 * A music video file.
 * @author schema.org
 * @class MusicVideoObject
 * @module org.schema
 * @extends MediaObject
 */
public class MusicVideoObject extends MediaObject
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public MusicVideoObject()
	{
		context="http://schema.org/";
		type="MusicVideoObject";
	}

}