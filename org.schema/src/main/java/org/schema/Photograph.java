package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Photograph
 * A photograph.
 * @author schema.org
 * @module schema.org
 * @class Photograph
 * @extends CreativeWork
 */
public class Photograph extends CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Photograph()
	{
		context="http://schema.org/";
		type="Photograph";
	}

}