package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Embassy
 * An embassy.
 * @author schema.org
 * @class Embassy
 * @module org.schema
 * @extends GovernmentBuilding
 */
public class Embassy extends GovernmentBuilding
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Embassy()
	{
		context="http://schema.org/";
		type="Embassy";
	}

}