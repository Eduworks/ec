package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Library
 * A library.
 * @author schema.org
 * @module schema.org
 * @class Library
 * @extends LocalBusiness
 */
public class Library extends LocalBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Library()
	{
		context="http://schema.org/";
		type="Library";
	}

}