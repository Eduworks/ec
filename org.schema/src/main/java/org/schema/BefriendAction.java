package org.schema;

/**
 * Schema.org/BefriendAction
 * The act of forming a personal connection with someone (object) mutually/bidirectionally/symmetrically.\n\nRelated actions:\n\n* [[FollowAction]]: Unlike FollowAction, BefriendAction implies that the connection is reciprocal.
 *
 * @author schema.org
 * @class BefriendAction
 * @module org.schema
 * @extends InteractAction
 */
public class BefriendAction extends InteractAction {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public BefriendAction() {
		context = "http://schema.org/";
		type = "BefriendAction";
	}

}