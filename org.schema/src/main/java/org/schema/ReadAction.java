package org.schema;

/**
 * Schema.org/ReadAction
 * The act of consuming written content.
 *
 * @author schema.org
 * @class ReadAction
 * @module org.schema
 * @extends ConsumeAction
 */
public class ReadAction extends ConsumeAction {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ReadAction() {
		context = "http://schema.org/";
		type = "ReadAction";
	}

}