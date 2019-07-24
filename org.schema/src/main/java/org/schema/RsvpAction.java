package org.schema;

/**
 * Schema.org/RsvpAction
 * The act of notifying an event organizer as to whether you expect to attend the event.
 *
 * @author schema.org
 * @class RsvpAction
 * @module org.schema
 * @extends InformAction
 */
public class RsvpAction extends InformAction {
	/**
	 * Schema.org/additionalNumberOfGuests
	 * If responding yes, the number of guests who will attend in addition to the invitee.
	 *
	 * @property additionalNumberOfGuests
	 * @type Number
	 */
	public Double additionalNumberOfGuests;
	/**
	 * Schema.org/comment
	 * Comments, typically from users.
	 *
	 * @property comment
	 * @type Comment
	 */
	public Comment comment;
	/**
	 * Schema.org/rsvpResponse
	 * The response (yes, no, maybe) to the RSVP.
	 *
	 * @property rsvpResponse
	 * @type RsvpResponseType
	 */
	public RsvpResponseType rsvpResponse;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public RsvpAction() {
		context = "http://schema.org/";
		type = "RsvpAction";
	}

}