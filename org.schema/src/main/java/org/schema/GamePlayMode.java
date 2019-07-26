package org.schema;

/**
 * Schema.org/GamePlayMode
 * Indicates whether this game is multi-player, co-op or single-player.
 *
 * @author schema.org
 * @class GamePlayMode
 * @module org.schema
 * @extends Enumeration
 */
public class GamePlayMode extends Enumeration {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public GamePlayMode() {
		context = "http://schema.org/";
		type = "GamePlayMode";
	}

}