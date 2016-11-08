package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/UseAction
 * The act of applying an object to its intended purpose.
 * @author schema.org
 * @class UseAction
 * @module org.schema
 * @extends ConsumeAction
 */
public class UseAction extends ConsumeAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public UseAction()
	{
		context="http://schema.org/";
		type="UseAction";
	}

}