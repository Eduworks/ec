package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/IgnoreAction
 * The act of intentionally disregarding the object. An agent ignores an object.
 * @author schema.org
 * @module schema.org
 * @class IgnoreAction
 * @extends AssessAction
 */
public class IgnoreAction extends AssessAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public IgnoreAction()
	{
		context="http://schema.org/";
		type="IgnoreAction";
	}

}