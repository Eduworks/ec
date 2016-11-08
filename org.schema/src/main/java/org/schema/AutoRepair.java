package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/AutoRepair
 * Car repair business.
 * @author schema.org
 * @class AutoRepair
 * @module org.schema
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