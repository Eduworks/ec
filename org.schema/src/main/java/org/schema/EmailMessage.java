package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/EmailMessage
 * An email message.
 * @author schema.org
 * @class EmailMessage
 * @module org.schema
 * @extends Message
 */
public class EmailMessage extends Message
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public EmailMessage()
	{
		context="http://schema.org/";
		type="EmailMessage";
	}

}