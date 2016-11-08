package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/GameServer
 * Server that provides game interaction in a multiplayer game.
 * @author schema.org
 * @class GameServer
 * @module org.schema
 * @extends Intangible
 */
public class GameServer extends Intangible
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public GameServer()
	{
		context="http://schema.org/";
		type="GameServer";
	}

	/**
	 * Schema.org/game
	 * Video game which is played on this server.
	 * @property game
	 * @type VideoGame
	 */
	public VideoGame game;

	/**
	 * Schema.org/serverStatus
	 * Status of a game server.
	 * @property serverStatus
	 * @type GameServerStatus
	 */
	public GameServerStatus serverStatus;

	/**
	 * Schema.org/playersOnline
	 * Number of players on the server.
	 * @property playersOnline
	 * @type Integer
	 */
	public Integer playersOnline;

}