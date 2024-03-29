package org.schema;

/**
 * Schema.org/CommentAction
 * The act of generating a comment about a subject.
 *
 * @author schema.org
 * @class CommentAction
 * @module org.schema
 * @extends CommunicateAction
 */
public class CommentAction extends CommunicateAction {
	/**
	 * Schema.org/resultComment
	 * A sub property of result. The Comment created or sent as a result of this action.
	 *
	 * @property resultComment
	 * @type Comment
	 */
	public Comment resultComment;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public CommentAction() {
		context = "http://schema.org/";
		type = "CommentAction";
	}

}