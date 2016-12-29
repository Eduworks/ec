package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/AssessAction
 * The act of forming one's opinion, reaction or sentiment.
 * @author schema.org
 * @class AssessAction
 * @module org.schema
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

    public String prettyStartTime()
    {
        return new Date(startTime).toLocaleString();
    }
}