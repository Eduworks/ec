package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Festival
 * Event type: Festival.
 * @author schema.org
 * @module schema.org
 * @class Festival
 * @extends Event
 */
public class Festival extends Event
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Festival()
	{
		context="http://schema.org/";
		type="Festival";
	}

}