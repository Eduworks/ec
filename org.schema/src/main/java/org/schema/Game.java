package org.schema;

/**
 * Schema.org/Game
 * The Game type represents things which are games. These are typically rule-governed recreational activities, e.g. role-playing games in which players assume the role of characters in a fictional setting.
 *
 * @author schema.org
 * @class Game
 * @module org.schema
 * @extends CreativeWork
 */
public class Game extends CreativeWork {
	/**
	 * Schema.org/gameLocation
	 * Real or fictional location of the game (or part of game).
	 *
	 * @property gameLocation
	 * @type schema, PostalAddress | schema,Place | schema,URL
	 */
	public Object gameLocation;
	/**
	 * Schema.org/quest
	 * The task that a player-controlled character, or group of characters may complete in order to gain a reward.
	 *
	 * @property quest
	 * @type Thing
	 */
	public Thing quest;
	/**
	 * Schema.org/gameItem
	 * An item is an object within the game world that can be collected by a player or, occasionally, a non-player character.
	 *
	 * @property gameItem
	 * @type Thing
	 */
	public Thing gameItem;
	/**
	 * Schema.org/numberOfPlayers
	 * Indicate how many people can play this game (minimum, maximum, or range).
	 *
	 * @property numberOfPlayers
	 * @type QuantitativeValue
	 */
	public QuantitativeValue numberOfPlayers;
	/**
	 * Schema.org/characterAttribute
	 * A piece of data that represents a particular aspect of a fictional character (skill, power, character points, advantage, disadvantage).
	 *
	 * @property characterAttribute
	 * @type Thing
	 */
	public Thing characterAttribute;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Game() {
		context = "http://schema.org/";
		type = "Game";
	}

}