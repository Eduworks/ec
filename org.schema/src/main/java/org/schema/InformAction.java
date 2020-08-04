package org.schema;

/**
 * Schema.org/InformAction
 * The act of notifying someone of information pertinent to them, with no expectation of a response.
 *
 * @author schema.org
 * @class InformAction
 * @module org.schema
 * @extends CommunicateAction
 */
public class InformAction extends CommunicateAction {
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
	public InformAction() {
		context = "http://schema.org/";
		type = "InformAction";
	}

}