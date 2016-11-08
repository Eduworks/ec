package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Electrician
 * An electrician.
 * @author schema.org
 * @class Electrician
 * @module org.schema
 * @extends HomeAndConstructionBusiness
 */
public class Electrician extends HomeAndConstructionBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Electrician()
	{
		context="http://schema.org/";
		type="Electrician";
	}

}