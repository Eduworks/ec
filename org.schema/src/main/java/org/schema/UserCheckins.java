package org.schema;

/**
 * Schema.org/UserCheckins
 * UserInteraction and its subtypes is an old way of talking about users interacting with pages. It is generally better to use [[Action]]-based vocabulary, alongside types such as [[Comment]].
 *
 * @author schema.org
 * @class UserCheckins
 * @module org.schema
 * @extends UserInteraction
 */
public class UserCheckins extends UserInteraction {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public UserCheckins() {
		context = "http://schema.org/";
		type = "UserCheckins";
	}

}