package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/UnRegisterAction
 * The act of un-registering from a service.\n\nRelated actions:\n\n* [[RegisterAction]]: antonym of UnRegisterAction.\n* [[Leave]]: Unlike LeaveAction, UnRegisterAction implies that you are unregistering from a service you werer previously registered, rather than leaving a team/group of people.
 * @author schema.org
 * @class UnRegisterAction
 * @module org.schema
 * @extends InteractAction
 */
public class UnRegisterAction extends InteractAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public UnRegisterAction()
	{
		context="http://schema.org/";
		type="UnRegisterAction";
	}

}