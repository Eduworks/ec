package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/RadioStation
 * A radio station.
 * @author schema.org
 * @module schema.org
 * @class RadioStation
 * @extends LocalBusiness
 */
public class RadioStation extends LocalBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public RadioStation()
	{
		context="http://schema.org/";
		type="RadioStation";
	}

}