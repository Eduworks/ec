package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/AssessAction
 * The act of forming one's opinion, reaction or sentiment.
 * @author schema.org
 * @module schema.org
 * @class AssessAction
 * @extends Action
 */
public class AssessAction extends Action
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public AssessAction()
	{
		context="http://schema.org/";
		type="AssessAction";
	}

}