package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Plumber
 * A plumbing service.
 * @author schema.org
 * @class Plumber
 * @module org.schema
 * @extends HomeAndConstructionBusiness
 */
public class Plumber extends HomeAndConstructionBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Plumber()
	{
		context="http://schema.org/";
		type="Plumber";
	}

}