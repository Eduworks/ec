package org.schema;

/**
 * Schema.org/UserBlocks
 * UserInteraction and its subtypes is an old way of talking about users interacting with pages. It is generally better to use [[Action]]-based vocabulary, alongside types such as [[Comment]].
 *
 * @author schema.org
 * @class UserBlocks
 * @module org.schema
 * @extends UserInteraction
 */
public class UserBlocks extends UserInteraction {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public UserBlocks() {
		context = "http://schema.org/";
		type = "UserBlocks";
	}

}