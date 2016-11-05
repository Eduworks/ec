package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Museum
 * A museum.
 * @author schema.org
 * @module schema.org
 * @class Museum
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