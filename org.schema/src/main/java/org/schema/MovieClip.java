package org.schema;

/**
 * Schema.org/MovieClip
 * A short segment/part of a movie.
 * @author schema.org
 * @class MovieClip
 * @module org.schema
 * @extends Clip
 */
public class MovieClip extends Clip
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public MovieClip()
	{
		context="http://schema.org/";
		type="MovieClip";
	}

}