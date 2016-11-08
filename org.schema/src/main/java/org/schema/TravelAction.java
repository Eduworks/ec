package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/TravelAction
 * The act of traveling from an fromLocation to a destination by a specified mode of transport, optionally with participants.
 * @author schema.org
 * @class TravelAction
 * @module org.schema
 * @extends MoveAction
 */
public class TravelAction extends MoveAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public TravelAction()
	{
		context="http://schema.org/";
		type="TravelAction";
	}

	/**
	 * Schema.org/distance
	 * The distance travelled, e.g. exercising or travelling.
	 * @property distance
	 * @type Distance
	 */
	public Distance distance;

}