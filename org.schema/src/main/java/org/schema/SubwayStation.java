package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/SubwayStation
 * A subway station.
 * @author schema.org
 * @module schema.org
 * @class SubwayStation
 * @extends CivicStructure
 */
public class SubwayStation extends CivicStructure
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public SubwayStation()
	{
		context="http://schema.org/";
		type="SubwayStation";
	}

}