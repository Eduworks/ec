package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/AudioObject
 * An audio file.
 * @author schema.org
 * @module schema.org
 * @class AudioObject
 * @extends MediaObject
 */
public class AudioObject extends MediaObject
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public AudioObject()
	{
		context="http://schema.org/";
		type="AudioObject";
	}

	/**
	 * Schema.org/transcript
	 * If this MediaObject is an AudioObject or VideoObject, the transcript of that object.
	 * @property transcript
	 * @type Text
	 */
	public String transcript;

}