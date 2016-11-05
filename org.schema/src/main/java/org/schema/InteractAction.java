package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/InteractAction
 * The act of interacting with another person or organization.
 * @author schema.org
 * @module schema.org
 * @class InteractAction
 * @extends Action
 */
public class InteractAction extends Action
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public InteractAction()
	{
		context="http://schema.org/";
		type="InteractAction";
	}

}