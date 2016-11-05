package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/UserComments
 * UserInteraction and its subtypes is an old way of talking about users interacting with pages. It is generally better to use [[Action]]-based vocabulary, alongside types such as [[Comment]].
 * @author schema.org
 * @module schema.org
 * @class UserComments
 * @extends UserInteraction
 */
public class UserComments extends UserInteraction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public UserComments()
	{
		context="http://schema.org/";
		type="UserComments";
	}

	/**
	 * Schema.org/commentText
	 * The text of the UserComment.
	 * @property commentText
	 * @type Text
	 */
	public String commentText;

	/**
	 * Schema.org/discusses
	 * Specifies the CreativeWork associated with the UserComment.
	 * @property discusses
	 * @type CreativeWork
	 */
	public CreativeWork discusses;

	/**
	 * Schema.org/replyToUrl
	 * The URL at which a reply may be posted to the specified UserComment.
	 * @property replyToUrl
	 * @type URL
	 */
	public String replyToUrl;

	/**
	 * Schema.org/creator
	 * The creator/author of this CreativeWork. This is the same as the Author property for CreativeWork.
	 * @property creator
	 * @type schema,Organization | schema,Person	 */
	public Object creator;

	/**
	 * Schema.org/commentTime
	 * The time at which the UserComment was made.
	 * @property commentTime
	 * @type schema,DateTime | schema,Date	 */
	public Object commentTime;

}