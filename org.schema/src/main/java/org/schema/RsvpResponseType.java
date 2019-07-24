package org.schema;

/**
 * Schema.org/RsvpResponseType
 * RsvpResponseType is an enumeration type whose instances represent responding to an RSVP request.
 *
 * @author schema.org
 * @class RsvpResponseType
 * @module org.schema
 * @extends Enumeration
 */
public class RsvpResponseType extends Enumeration {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public RsvpResponseType() {
		context = "http://schema.org/";
		type = "RsvpResponseType";
	}

}