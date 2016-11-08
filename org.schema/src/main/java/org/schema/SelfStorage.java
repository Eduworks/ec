package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/SelfStorage
 * A self-storage facility.
 * @author schema.org
 * @class SelfStorage
 * @module org.schema
 * @extends LocalBusiness
 */
public class SelfStorage extends LocalBusiness
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public SelfStorage()
	{
		context="http://schema.org/";
		type="SelfStorage";
	}

}