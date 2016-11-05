package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/InviteAction
 * The act of asking someone to attend an event. Reciprocal of RsvpAction.
 * @author schema.org
 * @module schema.org
 * @class InviteAction
 * @extends CommunicateAction
 */
public class InviteAction extends CommunicateAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public InviteAction()
	{
		context="http://schema.org/";
		type="InviteAction";
	}

	/**
	 * Schema.org/event
	 * Upcoming or past event associated with this place, organization, or action.
	 * @property event
	 * @type Event
	 */
	public Event event;

}