package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/EatAction
 * The act of swallowing solid objects.
 * @author schema.org
 * @module schema.org
 * @class EatAction
 * @extends ConsumeAction
 */
public class EatAction extends ConsumeAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public EatAction()
	{
		context="http://schema.org/";
		type="EatAction";
	}

}