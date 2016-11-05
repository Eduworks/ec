package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/ReadAction
 * The act of consuming written content.
 * @author schema.org
 * @module schema.org
 * @class ReadAction
 * @extends ConsumeAction
 */
public class ReadAction extends ConsumeAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ReadAction()
	{
		context="http://schema.org/";
		type="ReadAction";
	}

}