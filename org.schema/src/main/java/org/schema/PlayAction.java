package org.schema;

/**
 * Schema.org/PlayAction
 * The act of playing/exercising/training/performing for enjoyment, leisure, recreation, Competition or exercise.\n\nRelated actions:\n\n* [[ListenAction]]: Unlike ListenAction (which is under ConsumeAction), PlayAction refers to performing for an audience or at an event, rather than consuming music.\n* [[WatchAction]]: Unlike WatchAction (which is under ConsumeAction), PlayAction refers to showing/displaying for an audience or at an event, rather than consuming visual content.
 *
 * @author schema.org
 * @class PlayAction
 * @module org.schema
 * @extends Action
 */
public class PlayAction extends Action {
	/**
	 * Schema.org/audience
	 * An intended audience, i.e. a group for whom something was created.
	 *
	 * @property audience
	 * @type Audience
	 */
	public Audience audience;
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
	public PlayAction() {
		context = "http://schema.org/";
		type = "PlayAction";
	}

}