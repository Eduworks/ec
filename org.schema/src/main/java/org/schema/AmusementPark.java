package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/AmusementPark
 * An amusement park.
 * @author schema.org
 * @module schema.org
 * @class AmusementPark
 * @extends EntertainmentBusiness
 */
public class AmusementPark extends EntertainmentBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public AmusementPark()
	{
		context="http://schema.org/";
		type="AmusementPark";
	}

}