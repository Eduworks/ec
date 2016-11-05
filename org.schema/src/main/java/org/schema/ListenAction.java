package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/ListenAction
 * The act of consuming audio content.
 * @author schema.org
 * @module schema.org
 * @class ListenAction
 * @extends ConsumeAction
 */
public class ListenAction extends ConsumeAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ListenAction()
	{
		context="http://schema.org/";
		type="ListenAction";
	}

}