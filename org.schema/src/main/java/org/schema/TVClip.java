package org.schema;

/**
 * Schema.org/TVClip
 * A short TV program or a segment/part of a TV program.
 *
 * @author schema.org
 * @class TVClip
 * @module org.schema
 * @extends Clip
 */
public class TVClip extends Clip {
	/**
	 * Schema.org/partOfTVSeries
	 * The TV series to which this episode or season belongs.
	 *
	 * @property partOfTVSeries
	 * @type TVSeries
	 */
	public TVSeries partOfTVSeries;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public TVClip() {
		context = "http://schema.org/";
		type = "TVClip";
	}

}