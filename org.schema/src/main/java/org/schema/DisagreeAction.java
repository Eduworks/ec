package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/DisagreeAction
 * The act of expressing a difference of opinion with the object. An agent disagrees to/about an object (a proposition, topic or theme) with participants.
 * @author schema.org
 * @class DisagreeAction
 * @module org.schema
 * @extends ReactAction
 */
public class DisagreeAction extends ReactAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public DisagreeAction()
	{
		context="http://schema.org/";
		type="DisagreeAction";
	}

}