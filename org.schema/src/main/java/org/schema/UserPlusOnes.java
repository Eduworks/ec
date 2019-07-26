package org.schema;

/**
 * Schema.org/UserPlusOnes
 * UserInteraction and its subtypes is an old way of talking about users interacting with pages. It is generally better to use [[Action]]-based vocabulary, alongside types such as [[Comment]].
 *
 * @author schema.org
 * @class UserPlusOnes
 * @module org.schema
 * @extends UserInteraction
 */
public class UserPlusOnes extends UserInteraction {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public UserPlusOnes() {
		context = "http://schema.org/";
		type = "UserPlusOnes";
	}

}