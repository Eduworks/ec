package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/AskAction
 * The act of posing a question / favor to someone.\n\nRelated actions:\n\n* [[ReplyAction]]: Appears generally as a response to AskAction.
 * @author schema.org
 * @module schema.org
 * @class AskAction
 * @extends CommunicateAction
 */
public class AskAction extends CommunicateAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public AskAction()
	{
		context="http://schema.org/";
		type="AskAction";
	}

	/**
	 * Schema.org/question
	 * A sub property of object. A question.
	 * @property question
	 * @type Question
	 */
	public Question question;

}