package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/SubscribeAction
 * The act of forming a personal connection with someone/something (object) unidirectionally/asymmetrically to get updates pushed to.\n\nRelated actions:\n\n* [[FollowAction]]: Unlike FollowAction, SubscribeAction implies that the subscriber acts as a passive agent being constantly/actively pushed for updates.\n* [[RegisterAction]]: Unlike RegisterAction, SubscribeAction implies that the agent is interested in continuing receiving updates from the object.\n* [[JoinAction]]: Unlike JoinAction, SubscribeAction implies that the agent is interested in continuing receiving updates from the object.
 * @author schema.org
 * @module schema.org
 * @class SubscribeAction
 * @extends InteractAction
 */
public class SubscribeAction extends InteractAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public SubscribeAction()
	{
		context="http://schema.org/";
		type="SubscribeAction";
	}

}