package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/TelevisionStation
 * A television station.
 * @author schema.org
 * @class TelevisionStation
 * @module org.schema
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