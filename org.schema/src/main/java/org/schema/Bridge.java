package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Bridge
 * A bridge.
 * @author schema.org
 * @module schema.org
 * @class Bridge
 * @extends CivicStructure
 */
public class Bridge extends CivicStructure
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Bridge()
	{
		context="http://schema.org/";
		type="Bridge";
	}

}