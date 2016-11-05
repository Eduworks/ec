package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/TVClip
 * A short TV program or a segment/part of a TV program.
 * @author schema.org
 * @module schema.org
 * @class TVClip
 * @extends Clip
 */
public class TVClip extends Clip
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public TVClip()
	{
		context="http://schema.org/";
		type="TVClip";
	}

	/**
	 * Schema.org/partOfTVSeries
	 * The TV series to which this episode or season belongs.
	 * @property partOfTVSeries
	 * @type TVSeries
	 */
	public TVSeries partOfTVSeries;

}