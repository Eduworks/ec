package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Locksmith
 * A locksmith.
 * @author schema.org
 * @module schema.org
 * @class Locksmith
 * @extends HomeAndConstructionBusiness
 */
public class Locksmith extends HomeAndConstructionBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Locksmith()
	{
		context="http://schema.org/";
		type="Locksmith";
	}

}