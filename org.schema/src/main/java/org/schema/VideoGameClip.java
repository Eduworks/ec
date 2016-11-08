package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/VideoGameClip
 * A short segment/part of a video game.
 * @author schema.org
 * @class VideoGameClip
 * @module org.schema
 * @extends Clip
 */
public class VideoGameClip extends Clip
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public VideoGameClip()
	{
		context="http://schema.org/";
		type="VideoGameClip";
	}

}