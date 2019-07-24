package org.schema;

/**
 * Schema.org/RadioClip
 * A short radio program or a segment/part of a radio program.
 *
 * @author schema.org
 * @class RadioClip
 * @module org.schema
 * @extends Clip
 */
public class RadioClip extends Clip {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public RadioClip() {
		context = "http://schema.org/";
		type = "RadioClip";
	}

}