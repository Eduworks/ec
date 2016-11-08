package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Cemetery
 * A graveyard.
 * @author schema.org
 * @class Cemetery
 * @module org.schema
 * @extends CivicStructure
 */
public class Cemetery extends CivicStructure
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Cemetery()
	{
		context="http://schema.org/";
		type="Cemetery";
	}

}