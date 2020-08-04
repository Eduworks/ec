package org.schema;

/**
 * Schema.org/JoinAction
 * An agent joins an event/group with participants/friends at a location.\n\nRelated actions:\n\n* [[RegisterAction]]: Unlike RegisterAction, JoinAction refers to joining a group/team of people.\n* [[SubscribeAction]]: Unlike SubscribeAction, JoinAction does not imply that you'll be receiving updates.\n* [[FollowAction]]: Unlike FollowAction, JoinAction does not imply that you'll be polling for updates.
 *
 * @author schema.org
 * @class JoinAction
 * @module org.schema
 * @extends InteractAction
 */
public class JoinAction extends InteractAction {
	/**
	 * Schema.org/event
	 * Upcoming or past event associated with this place, organization, or action.
	 *
	 * @property event
	 * @type SchemaEvent
	 */
	public SchemaEvent event;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public JoinAction() {
		context = "http://schema.org/";
		type = "JoinAction";
	}

}