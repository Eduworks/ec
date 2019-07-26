package org.schema;

/**
 * Schema.org/DrawAction
 * The act of producing a visual/graphical representation of an object, typically with a pen/pencil and paper as instruments.
 *
 * @author schema.org
 * @class DrawAction
 * @module org.schema
 * @extends CreateAction
 */
public class DrawAction extends CreateAction {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public DrawAction() {
		context = "http://schema.org/";
		type = "DrawAction";
	}

}