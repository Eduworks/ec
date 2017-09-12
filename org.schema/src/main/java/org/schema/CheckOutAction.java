package org.schema;

/**
 * Schema.org/CheckOutAction
 * The act of an agent communicating (service provider, social media, etc) their departure of a previously reserved service (e.g. flight check in) or place (e.g. hotel).\n\nRelated actions:\n\n* [[CheckInAction]]: The antonym of CheckOutAction.\n* [[DepartAction]]: Unlike DepartAction, CheckOutAction implies that the agent is informing/confirming the end of a previously reserved service.\n* [[CancelAction]]: Unlike CancelAction, CheckOutAction implies that the agent is informing/confirming the end of a previously reserved service.
 * @author schema.org
 * @class CheckOutAction
 * @module org.schema
 * @extends CommunicateAction
 */
public class CheckOutAction extends CommunicateAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public CheckOutAction()
	{
		context="http://schema.org/";
		type="CheckOutAction";
	}

}