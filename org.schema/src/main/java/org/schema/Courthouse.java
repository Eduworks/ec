package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Courthouse
 * A courthouse.
 * @author schema.org
 * @module schema.org
 * @class Courthouse
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