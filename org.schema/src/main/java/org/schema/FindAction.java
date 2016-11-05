package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/FindAction
 * TThe act of finding an object.\n\nRelated actions:\n\n* [[SearchAction]]: FindAction is generally lead by a SearchAction, but not necessarily.
 * @author schema.org
 * @module schema.org
 * @class FindAction
 * @extends Action
 */
public class FindAction extends Action
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public FindAction()
	{
		context="http://schema.org/";
		type="FindAction";
	}

}