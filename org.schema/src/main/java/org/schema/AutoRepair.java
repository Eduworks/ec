package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/AutoRepair
 * Car repair business.
 * @author schema.org
 * @module schema.org
 * @class AutoRepair
 * @extends AutomotiveBusiness
 */
public class AutoRepair extends AutomotiveBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public AutoRepair()
	{
		context="http://schema.org/";
		type="AutoRepair";
	}

}