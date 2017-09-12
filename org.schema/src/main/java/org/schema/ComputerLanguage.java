package org.schema;

/**
 * Schema.org/ComputerLanguage
 * This type covers computer programming languages such as Scheme and Lisp, as well as other language-like computer representations. Natural languages are best represented with the [[Language]] type.
 *
 * @author schema.org
 * @class ComputerLanguage
 * @module org.schema
 * @extends Intangible
 */
public class ComputerLanguage extends Intangible {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ComputerLanguage() {
		context = "http://schema.org/";
		type = "ComputerLanguage";
	}

}