package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/OrganizeAction
 * The act of manipulating/administering/supervising/controlling one or more objects.
 * @author schema.org
 * @module schema.org
 * @class OrganizeAction
 * @extends Action
 */
public class OrganizeAction extends Action
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public OrganizeAction()
	{
		context="http://schema.org/";
		type="OrganizeAction";
	}

}