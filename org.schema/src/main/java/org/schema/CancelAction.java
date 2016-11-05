package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/CancelAction
 * The act of asserting that a future event/action is no longer going to happen.\n\nRelated actions:\n\n* [[ConfirmAction]]: The antonym of CancelAction.
 * @author schema.org
 * @module schema.org
 * @class CancelAction
 * @extends PlanAction
 */
public class CancelAction extends PlanAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public CancelAction()
	{
		context="http://schema.org/";
		type="CancelAction";
	}

}