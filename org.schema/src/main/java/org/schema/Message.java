package org.schema;

/**
 * Schema.org/Message
 * A single message from a sender to one or more organizations or people.
 * @author schema.org
 * @class Message
 * @module org.schema
 * @extends CreativeWork
 */
public class Message extends CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Message()
	{
		context="http://schema.org/";
		type="Message";
	}

	/**
	 * Schema.org/sender
	 * A sub property of participant. The participant who is at the sending end of the action.
	 * @property sender
	 * @type schema,Organization | schema,Person | schema,Audience
	 */
	public Object sender;

	/**
	 * Schema.org/dateReceived
	 * The date/time the message was received if a single recipient exists.
	 * @property dateReceived
	 * @type DateTime
	 */
	public String dateReceived;

	/**
	 * Schema.org/dateRead
	 * The date/time at which the message has been read by the recipient if a single recipient exists.
	 * @property dateRead
	 * @type DateTime
	 */
	public String dateRead;

	/**
	 * Schema.org/dateSent
	 * The date/time at which the message was sent.
	 * @property dateSent
	 * @type DateTime
	 */
	public String dateSent;

	/**
	 * Schema.org/messageAttachment
	 * A CreativeWork attached to the message.
	 * @property messageAttachment
	 * @type CreativeWork
	 */
	public CreativeWork messageAttachment;

	/**
	 * Schema.org/recipient
	 * A sub property of participant. The participant who is at the receiving end of the action.
	 * @property recipient
	 * @type schema,Organization | schema,Person | schema,Audience
	 */
	public Object recipient;

}