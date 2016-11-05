package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/ShareAction
 * The act of distributing content to people for their amusement or edification.
 * @author schema.org
 * @module schema.org
 * @class ShareAction
 * @extends CommunicateAction
 */
public class ShareAction extends CommunicateAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ShareAction()
	{
		context="http://schema.org/";
		type="ShareAction";
	}

}