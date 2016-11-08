package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Photograph
 * A photograph.
 * @author schema.org
 * @class Photograph
 * @module org.schema
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