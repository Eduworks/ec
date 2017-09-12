package org.schema;

/**
 * Schema.org/Code
 * Computer programming source code. Example: Full (compile ready) solutions, code snippet samples, scripts, templates.
 *
 * @author schema.org
 * @class Code
 * @module org.schema
 * @extends CreativeWork
 */
public class Code extends CreativeWork {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Code() {
		context = "http://schema.org/";
		type = "Code";
	}

}