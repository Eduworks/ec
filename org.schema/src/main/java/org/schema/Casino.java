package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Casino
 * A casino.
 * @author schema.org
 * @module schema.org
 * @class Casino
 * @extends EntertainmentBusiness
 */
public class Casino extends EntertainmentBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Casino()
	{
		context="http://schema.org/";
		type="Casino";
	}

}