package org.schema;

/**
 * Schema.org/ListenAction
 * The act of consuming audio content.
 *
 * @author schema.org
 * @class ListenAction
 * @module org.schema
 * @extends ConsumeAction
 */
public class ListenAction extends ConsumeAction {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ListenAction() {
		context = "http://schema.org/";
		type = "ListenAction";
	}

}