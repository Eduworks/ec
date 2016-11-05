package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/CommentAction
 * The act of generating a comment about a subject.
 * @author schema.org
 * @module schema.org
 * @class CommentAction
 * @extends CommunicateAction
 */
public class CommentAction extends CommunicateAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public CommentAction()
	{
		context="http://schema.org/";
		type="CommentAction";
	}

	/**
	 * Schema.org/resultComment
	 * A sub property of result. The Comment created or sent as a result of this action.
	 * @property resultComment
	 * @type Comment
	 */
	public Comment resultComment;

}