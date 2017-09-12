package org.schema;

/**
 * Schema.org/TakeAction
 * The act of gaining ownership of an object from an origin. Reciprocal of GiveAction.\n\nRelated actions:\n\n* [[GiveAction]]: The reciprocal of TakeAction.\n* [[ReceiveAction]]: Unlike ReceiveAction, TakeAction implies that ownership has been transfered.
 * @author schema.org
 * @class TakeAction
 * @module org.schema
 * @extends TransferAction
 */
public class TakeAction extends TransferAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public TakeAction()
	{
		context="http://schema.org/";
		type="TakeAction";
	}

}