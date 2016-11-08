package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Courthouse
 * A courthouse.
 * @author schema.org
 * @class Courthouse
 * @module org.schema
 * @extends GovernmentBuilding
 */
public class Courthouse extends GovernmentBuilding
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Courthouse()
	{
		context="http://schema.org/";
		type="Courthouse";
	}

}