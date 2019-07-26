package org.schema;

/**
 * Schema.org/ViewAction
 * The act of consuming static visual content.
 *
 * @author schema.org
 * @class ViewAction
 * @module org.schema
 * @extends ConsumeAction
 */
public class ViewAction extends ConsumeAction {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ViewAction() {
		context = "http://schema.org/";
		type = "ViewAction";
	}

}