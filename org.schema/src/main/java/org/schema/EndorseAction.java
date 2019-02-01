package org.schema;

/**
 * Schema.org/EndorseAction
 * An agent approves/certifies/likes/supports/sanction an object.
 *
 * @author schema.org
 * @class EndorseAction
 * @module org.schema
 * @extends ReactAction
 */
public class EndorseAction extends ReactAction {
	/**
	 * Schema.org/endorsee
	 * A sub property of participant. The person/organization being supported.
	 *
	 * @property endorsee
	 * @type Organization
	 */
	public Organization endorsee;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public EndorseAction() {
		context = "http://schema.org/";
		type = "EndorseAction";
	}

}