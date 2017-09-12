package org.schema;

/**
 * Schema.org/AcceptAction
 * The act of committing to/adopting an object.\n\nRelated actions:\n\n* [[RejectAction]]: The antonym of AcceptAction.
 * @author schema.org
 * @class AcceptAction
 * @module org.schema
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