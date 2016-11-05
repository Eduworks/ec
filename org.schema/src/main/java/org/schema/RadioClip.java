package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/RadioClip
 * A short radio program or a segment/part of a radio program.
 * @author schema.org
 * @module schema.org
 * @class RadioClip
 * @extends Clip
 */
public class RadioClip extends Clip
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public RadioClip()
	{
		context="http://schema.org/";
		type="RadioClip";
	}

}