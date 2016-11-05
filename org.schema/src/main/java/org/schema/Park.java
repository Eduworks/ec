package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Park
 * A park.
 * @author schema.org
 * @module schema.org
 * @class Park
 * @extends CivicStructure
 */
public class Park extends CivicStructure
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Park()
	{
		context="http://schema.org/";
		type="Park";
	}

}