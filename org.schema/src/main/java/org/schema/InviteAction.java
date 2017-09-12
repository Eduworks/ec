package org.schema;

/**
 * Schema.org/InviteAction
 * The act of asking someone to attend an event. Reciprocal of RsvpAction.
 * @author schema.org
 * @class InviteAction
 * @module org.schema
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