package org.schema;

/**
 * Schema.org/GameServerStatus
 * Status of a game server.
 *
 * @author schema.org
 * @class GameServerStatus
 * @module org.schema
 * @extends Enumeration
 */
public class GameServerStatus extends Enumeration {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public GameServerStatus() {
		context = "http://schema.org/";
		type = "GameServerStatus";
	}

}