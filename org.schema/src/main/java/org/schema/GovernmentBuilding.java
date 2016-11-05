package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/GovernmentBuilding
 * A government building.
 * @author schema.org
 * @module schema.org
 * @class GovernmentBuilding
 * @extends CivicStructure
 */
public class GovernmentBuilding extends CivicStructure
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public GovernmentBuilding()
	{
		context="http://schema.org/";
		type="GovernmentBuilding";
	}

}