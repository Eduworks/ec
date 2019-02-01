package org.schema;

/**
 * Schema.org/CommunicateAction
 * The act of conveying information to another person via a communication medium (instrument) such as speech, email, or telephone conversation.
 *
 * @author schema.org
 * @class CommunicateAction
 * @module org.schema
 * @extends InteractAction
 */
public class CommunicateAction extends InteractAction {
	/**
	 * Schema.org/about
	 * The subject matter of the content.
	 *
	 * @property about
	 * @type Thing
	 */
	public Thing about;
	/**
	 * Schema.org/recipient
	 * A sub property of participant. The participant who is at the receiving end of the action.
	 *
	 * @property recipient
	 * @type Organization
	 */
	public Organization recipient;
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
	public CommunicateAction() {
		context = "http://schema.org/";
		type = "CommunicateAction";
	}

}