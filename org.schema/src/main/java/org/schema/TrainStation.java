package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/TrainStation
 * A train station.
 * @author schema.org
 * @module schema.org
 * @class TrainStation
 * @extends CivicStructure
 */
public class TrainStation extends CivicStructure
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public TrainStation()
	{
		context="http://schema.org/";
		type="TrainStation";
	}

}