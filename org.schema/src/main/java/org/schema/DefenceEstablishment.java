package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/DefenceEstablishment
 * A defence establishment, such as an army or navy base.
 * @author schema.org
 * @module schema.org
 * @class DefenceEstablishment
 * @extends GovernmentBuilding
 */
public class DefenceEstablishment extends GovernmentBuilding
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public DefenceEstablishment()
	{
		context="http://schema.org/";
		type="DefenceEstablishment";
	}

}