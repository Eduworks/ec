package org.schema;

/**
 * Schema.org/UserInteraction
 * UserInteraction and its subtypes is an old way of talking about users interacting with pages. It is generally better to use [[Action]]-based vocabulary, alongside types such as [[Comment]].
 *
 * @author schema.org
 * @class UserInteraction
 * @module org.schema
 * @extends Event
 */
public class UserInteraction extends Event {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public UserInteraction() {
		context = "http://schema.org/";
		type = "UserInteraction";
	}

}