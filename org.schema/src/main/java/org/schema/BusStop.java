package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/BusStop
 * A bus stop.
 * @author schema.org
 * @module schema.org
 * @class BusStop
 * @extends CivicStructure
 */
public class BusStop extends CivicStructure
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public BusStop()
	{
		context="http://schema.org/";
		type="BusStop";
	}

}