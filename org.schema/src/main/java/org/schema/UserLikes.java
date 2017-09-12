package org.schema;

/**
 * Schema.org/UserLikes
 * UserInteraction and its subtypes is an old way of talking about users interacting with pages. It is generally better to use [[Action]]-based vocabulary, alongside types such as [[Comment]].
 *
 * @author schema.org
 * @class UserLikes
 * @module org.schema
 * @extends UserInteraction
 */
public class UserLikes extends UserInteraction {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public UserLikes() {
		context = "http://schema.org/";
		type = "UserLikes";
	}

}