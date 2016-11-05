package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/City
 * A city or town.
 * @author schema.org
 * @module schema.org
 * @class City
 * @extends AdministrativeArea
 */
public class City extends AdministrativeArea
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public City()
	{
		context="http://schema.org/";
		type="City";
	}

}