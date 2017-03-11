package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/PoliceStation
 * A police station.
 * @author schema.org
 * @class PoliceStation
 * @module org.schema
 * @extends CivicStructure
 */
public class PoliceStation extends CivicStructure
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public PoliceStation()
	{
		context="http://schema.org/";
		type="PoliceStation";
	}

}