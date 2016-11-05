package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Electrician
 * An electrician.
 * @author schema.org
 * @module schema.org
 * @class Electrician
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