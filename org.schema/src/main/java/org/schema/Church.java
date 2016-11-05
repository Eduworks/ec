package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Church
 * A church.
 * @author schema.org
 * @module schema.org
 * @class Church
 * @extends PlaceOfWorship
 */
public class Church extends PlaceOfWorship
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Church()
	{
		context="http://schema.org/";
		type="Church";
	}

}