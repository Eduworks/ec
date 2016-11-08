package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Museum
 * A museum.
 * @author schema.org
 * @class Museum
 * @module org.schema
 * @extends CivicStructure
 */
public class Museum extends CivicStructure
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Museum()
	{
		context="http://schema.org/";
		type="Museum";
	}

}