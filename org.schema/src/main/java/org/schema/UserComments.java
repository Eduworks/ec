package org.schema;

/**
 * Schema.org/UserComments
 * UserInteraction and its subtypes is an old way of talking about users interacting with pages. It is generally better to use [[Action]]-based vocabulary, alongside types such as [[Comment]].
 *
 * @author schema.org
 * @class UserComments
 * @module org.schema
 * @extends UserInteraction
 */
public class UserComments extends UserInteraction {
	/**
	 * Schema.org/discusses
	 * Specifies the CreativeWork associated with the UserComment.
	 *
	 * @property discusses
	 * @type CreativeWork
	 */
	public CreativeWork discusses;
	/**
	 * Schema.org/commentText
	 * The text of the UserComment.
	 *
	 * @property commentText
	 * @type Text
	 */
	public String commentText;
	/**
	 * Schema.org/commentTime
	 * The time at which the UserComment was made.
	 *
	 * @property commentTime
	 * @type Date
	 */
	public String commentTime;
	/**
	 * Schema.org/creator
	 * The creator/author of this CreativeWork. This is the same as the Author property for CreativeWork.
	 *
	 * @property creator
	 * @type Person
	 */
	public Person creator;
	/**
	 * Schema.org/replyToUrl
	 * The URL at which a reply may be posted to the specified UserComment.
	 *
	 * @property replyToUrl
	 * @type URL
	 */
	public String replyToUrl;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public UserComments() {
		context = "http://schema.org/";
		type = "UserComments";
	}

}