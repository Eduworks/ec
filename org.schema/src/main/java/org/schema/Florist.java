package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Florist
 * A florist.
 * @author schema.org
 * @class Florist
 * @module org.schema
 * @extends Store
 */
public class Florist extends Store
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Florist()
	{
		context="http://schema.org/";
		type="Florist";
	}

}