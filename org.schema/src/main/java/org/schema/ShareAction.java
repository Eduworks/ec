package org.schema;

/**
 * Schema.org/ShareAction
 * The act of distributing content to people for their amusement or edification.
 *
 * @author schema.org
 * @class ShareAction
 * @module org.schema
 * @extends CommunicateAction
 */
public class ShareAction extends CommunicateAction {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ShareAction() {
		context = "http://schema.org/";
		type = "ShareAction";
	}

}