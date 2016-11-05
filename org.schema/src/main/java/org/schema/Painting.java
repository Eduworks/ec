package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Painting
 * A painting.
 * @author schema.org
 * @module schema.org
 * @class Painting
 * @extends CreativeWork
 */
public class Painting extends CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Painting()
	{
		context="http://schema.org/";
		type="Painting";
	}

}