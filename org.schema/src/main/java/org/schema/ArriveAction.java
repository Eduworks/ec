package org.schema;

/**
 * Schema.org/ArriveAction
 * The act of arriving at a place. An agent arrives at a destination from a fromLocation, optionally with participants.
 *
 * @author schema.org
 * @class ArriveAction
 * @module org.schema
 * @extends MoveAction
 */
public class ArriveAction extends MoveAction {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ArriveAction() {
		context = "http://schema.org/";
		type = "ArriveAction";
	}

}