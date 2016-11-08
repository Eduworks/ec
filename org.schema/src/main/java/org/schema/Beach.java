package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Beach
 * Beach.
 * @author schema.org
 * @class Beach
 * @module org.schema
 * @extends CivicStructure
 */
public class Beach extends CivicStructure
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Beach()
	{
		context="http://schema.org/";
		type="Beach";
	}

}