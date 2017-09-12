package org.schema;

/**
 * Schema.org/InstallAction
 * The act of installing an application.
 *
 * @author schema.org
 * @class InstallAction
 * @module org.schema
 * @extends ConsumeAction
 */
public class InstallAction extends ConsumeAction {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public InstallAction() {
		context = "http://schema.org/";
		type = "InstallAction";
	}

}