package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/AcceptAction
 * The act of committing to/adopting an object.\n\nRelated actions:\n\n* [[RejectAction]]: The antonym of AcceptAction.
 * @author schema.org
 * @module schema.org
 * @class AcceptAction
 * @extends AllocateAction
 */
public class AcceptAction extends AllocateAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public AcceptAction()
	{
		context="http://schema.org/";
		type="AcceptAction";
	}

}