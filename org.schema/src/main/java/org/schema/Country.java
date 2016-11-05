package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Country
 * A country.
 * @author schema.org
 * @module schema.org
 * @class Country
 * @extends AdministrativeArea
 */
public class Country extends AdministrativeArea
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Country()
	{
		context="http://schema.org/";
		type="Country";
	}

}