package org.schema;

/**
 * Schema.org/FindAction
 * The act of finding an object.\n\nRelated actions:\n\n* [[SearchAction]]: FindAction is generally lead by a SearchAction, but not necessarily.
 *
 * @author schema.org
 * @class FindAction
 * @module org.schema
 * @extends Action
 */
public class FindAction extends Action {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public FindAction() {
		context = "http://schema.org/";
		type = "FindAction";
	}

}