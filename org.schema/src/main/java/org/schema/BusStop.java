package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/BusStop
 * A bus stop.
 * @author schema.org
 * @class BusStop
 * @module org.schema
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