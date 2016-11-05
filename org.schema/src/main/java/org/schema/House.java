package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/House
 * A house is a building or structure that has the ability to be occupied for habitation by humans or other creatures (Source: Wikipedia, the free encyclopedia, see <a href="http://en.wikipedia.org/wiki/House">http://en.wikipedia.org/wiki/House</a>).
 * @author schema.org
 * @module schema.org
 * @class House
 * @extends Accommodation
 */
public class House extends Accommodation
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public House()
	{
		context="http://schema.org/";
		type="House";
	}

	/**
	 * Schema.org/numberOfRooms
	 * The number of rooms (excluding bathrooms and closets) of the acccommodation or lodging business.
Typical unit code(s): ROM for room or C62 for no unit. The type of room can be put in the unitText property of the QuantitativeValue.
	 * @property numberOfRooms
	 * @type schema,QuantitativeValue | schema,Number	 */
	public Object numberOfRooms;

}