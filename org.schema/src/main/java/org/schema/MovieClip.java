package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/MovieClip
 * A short segment/part of a movie.
 * @author schema.org
 * @module schema.org
 * @class MovieClip
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