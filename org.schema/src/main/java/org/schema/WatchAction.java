package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/WatchAction
 * The act of consuming dynamic/moving visual content.
 * @author schema.org
 * @module schema.org
 * @class WatchAction
 * @extends ConsumeAction
 */
public class WatchAction extends ConsumeAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public WatchAction()
	{
		context="http://schema.org/";
		type="WatchAction";
	}

}