package org.schema;

/**
 * Schema.org/Language
 * Natural languages such as Spanish, Tamil, Hindi, English, etc. Formal language code tags expressed in [BCP 47](https://en.wikipedia.org/wiki/IETF_language_tag) can be used via the [[alternateName]] property. The Language type previously also covered programming languages such as Scheme and Lisp, which are now best represented using [[ComputerLanguage]].
 * @author schema.org
 * @class Language
 * @module org.schema
 * @extends Intangible
 */
public class Language extends Intangible
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Language()
	{
		context="http://schema.org/";
		type="Language";
	}

}