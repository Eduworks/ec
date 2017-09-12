package org.schema;

/**
 * Schema.org/LeaveAction
 * An agent leaves an event / group with participants/friends at a location.\n\nRelated actions:\n\n* [[JoinAction]]: The antonym of LeaveAction.\n* [[UnRegisterAction]]: Unlike UnRegisterAction, LeaveAction implies leaving a group/team of people rather than a service.
 * @author schema.org
 * @class LeaveAction
 * @module org.schema
 * @extends InteractAction
 */
public class LeaveAction extends InteractAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public LeaveAction()
	{
		context="http://schema.org/";
		type="LeaveAction";
	}

	/**
	 * Schema.org/event
	 * Upcoming or past event associated with this place, organization, or action.
	 * @property event
	 * @type Event
	 */
	public Event event;

}