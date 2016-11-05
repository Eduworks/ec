package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/DiscoverAction
 * The act of discovering/finding an object.
 * @author schema.org
 * @module schema.org
 * @class DiscoverAction
 * @extends FindAction
 */
public class DiscoverAction extends FindAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public DiscoverAction()
	{
		context="http://schema.org/";
		type="DiscoverAction";
	}

}