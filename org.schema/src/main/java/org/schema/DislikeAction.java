package org.schema;

/**
 * Schema.org/DislikeAction
 * The act of expressing a negative sentiment about the object. An agent dislikes an object (a proposition, topic or theme) with participants.
 *
 * @author schema.org
 * @class DislikeAction
 * @module org.schema
 * @extends ReactAction
 */
public class DislikeAction extends ReactAction {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public DislikeAction() {
		context = "http://schema.org/";
		type = "DislikeAction";
	}

}