package org.schema;

/**
 * Schema.org/GiveAction
 * The act of transferring ownership of an object to a destination. Reciprocal of TakeAction.\n\nRelated actions:\n\n* [[TakeAction]]: Reciprocal of GiveAction.\n* [[SendAction]]: Unlike SendAction, GiveAction implies that ownership is being transferred (e.g. I may send my laptop to you, but that doesn't mean I'm giving it to you).
 *
 * @author schema.org
 * @class GiveAction
 * @module org.schema
 * @extends TransferAction
 */
public class GiveAction extends TransferAction {
	/**
	 * Schema.org/recipient
	 * A sub property of participant. The participant who is at the receiving end of the action.
	 *
	 * @property recipient
	 * @type Organization
	 */
	public Organization recipient;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public GiveAction() {
		context = "http://schema.org/";
		type = "GiveAction";
	}

}