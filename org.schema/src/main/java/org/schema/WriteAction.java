package org.schema;

/**
 * Schema.org/WriteAction
 * The act of authoring written creative content.
 *
 * @author schema.org
 * @class WriteAction
 * @module org.schema
 * @extends CreateAction
 */
public class WriteAction extends CreateAction {
	/**
	 * Schema.org/inLanguage
	 * The language of the content or performance or used in an action. Please use one of the language codes from the [IETF BCP 47 standard](http://tools.ietf.org/html/bcp47). See also [[availableLanguage]].
	 *
	 * @property inLanguage
	 * @type Language
	 */
	public Language inLanguage;
	/**
	 * Schema.org/language
	 * A sub property of instrument. The language used on this action.
	 *
	 * @property language
	 * @type Language
	 */
	public Language language;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public WriteAction() {
		context = "http://schema.org/";
		type = "WriteAction";
	}

}