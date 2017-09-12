package org.schema;

/**
 * Schema.org/ReplyAction
 * The act of responding to a question/message asked/sent by the object. Related to [[AskAction]]\n\nRelated actions:\n\n* [[AskAction]]: Appears generally as an origin of a ReplyAction.
 * @author schema.org
 * @class ReplyAction
 * @module org.schema
 * @extends CommunicateAction
 */
public class ReplyAction extends CommunicateAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ReplyAction()
	{
		context="http://schema.org/";
		type="ReplyAction";
	}

	/**
	 * Schema.org/resultComment
	 * A sub property of result. The Comment created or sent as a result of this action.
	 * @property resultComment
	 * @type Comment
	 */
	public Comment resultComment;

}