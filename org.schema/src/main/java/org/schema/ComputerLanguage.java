package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/ComputerLanguage
 * This type covers computer programming languages such as Scheme and Lisp, as well as other language-like computer representations. Natural languages are best represented with the [[Language]] type.
 * @author schema.org
 * @module schema.org
 * @class ComputerLanguage
 * @extends Intangible
 */
public class ComputerLanguage extends Intangible
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ComputerLanguage()
	{
		context="http://schema.org/";
		type="ComputerLanguage";
	}

}