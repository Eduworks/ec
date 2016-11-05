package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/RejectAction
 * The act of rejecting to/adopting an object.\n\nRelated actions:\n\n* [[AcceptAction]]: The antonym of RejectAction.
 * @author schema.org
 * @module schema.org
 * @class RejectAction
 * @extends AllocateAction
 */
public class RejectAction extends AllocateAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public RejectAction()
	{
		context="http://schema.org/";
		type="RejectAction";
	}

}