package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/TennisComplex
 * A tennis complex.
 * @author schema.org
 * @class TennisComplex
 * @module org.schema
 * @extends SportsActivityLocation
 */
public class TennisComplex extends SportsActivityLocation
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public TennisComplex()
	{
		context="http://schema.org/";
		type="TennisComplex";
	}

}