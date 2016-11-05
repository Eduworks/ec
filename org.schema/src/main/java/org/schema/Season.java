package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Season
 * A media season e.g. tv, radio, video game etc.
 * @author schema.org
 * @module schema.org
 * @class Season
 * @extends CreativeWork
 */
public class Season extends CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Season()
	{
		context="http://schema.org/";
		type="Season";
	}

}