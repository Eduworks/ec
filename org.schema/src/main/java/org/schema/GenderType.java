package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/GenderType
 * An enumeration of genders.
 * @author schema.org
 * @module schema.org
 * @class GenderType
 * @extends Enumeration
 */
public class GenderType extends Enumeration
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public GenderType()
	{
		context="http://schema.org/";
		type="GenderType";
	}

}