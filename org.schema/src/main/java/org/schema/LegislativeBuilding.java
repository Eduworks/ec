package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/LegislativeBuilding
 * A legislative building&#x2014;for example, the state capitol.
 * @author schema.org
 * @module schema.org
 * @class LegislativeBuilding
 * @extends GovernmentBuilding
 */
public class LegislativeBuilding extends GovernmentBuilding
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public LegislativeBuilding()
	{
		context="http://schema.org/";
		type="LegislativeBuilding";
	}

}