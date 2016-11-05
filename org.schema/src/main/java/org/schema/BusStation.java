package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/BusStation
 * A bus station.
 * @author schema.org
 * @module schema.org
 * @class BusStation
 * @extends CivicStructure
 */
public class BusStation extends CivicStructure
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public BusStation()
	{
		context="http://schema.org/";
		type="BusStation";
	}

}