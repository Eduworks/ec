package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/TelevisionStation
 * A television station.
 * @author schema.org
 * @module schema.org
 * @class TelevisionStation
 * @extends LocalBusiness
 */
public class TelevisionStation extends LocalBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public TelevisionStation()
	{
		context="http://schema.org/";
		type="TelevisionStation";
	}

}