package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/GovernmentPermit
 * A permit issued by a government agency.
 * @author schema.org
 * @module schema.org
 * @class GovernmentPermit
 * @extends Permit
 */
public class GovernmentPermit extends Permit
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public GovernmentPermit()
	{
		context="http://schema.org/";
		type="GovernmentPermit";
	}

}