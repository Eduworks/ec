package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/RsvpResponseType
 * RsvpResponseType is an enumeration type whose instances represent responding to an RSVP request.
 * @author schema.org
 * @module schema.org
 * @class RsvpResponseType
 * @extends Enumeration
 */
public class RsvpResponseType extends Enumeration
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public RsvpResponseType()
	{
		context="http://schema.org/";
		type="RsvpResponseType";
	}

}