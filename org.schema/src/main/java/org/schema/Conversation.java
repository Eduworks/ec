package org.schema;

/**
 * Schema.org/Conversation
 * One or more messages between organizations or people on a particular topic. Individual messages can be linked to the conversation with isPartOf or hasPart properties.
 *
 * @author schema.org
 * @class Conversation
 * @module org.schema
 * @extends CreativeWork
 */
public class Conversation extends CreativeWork {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Conversation() {
		context = "http://schema.org/";
		type = "Conversation";
	}

}