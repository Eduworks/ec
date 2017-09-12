package org.schema;

/**
 * Schema.org/BroadcastChannel
 * A unique instance of a BroadcastService on a CableOrSatelliteService lineup.
 * @author schema.org
 * @class BroadcastChannel
 * @module org.schema
 * @extends Intangible
 */
public class BroadcastChannel extends Intangible
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public BroadcastChannel()
	{
		context="http://schema.org/";
		type="BroadcastChannel";
	}

	/**
	 * Schema.org/providesBroadcastService
	 * The BroadcastService offered on this channel.
	 * @property providesBroadcastService
	 * @type BroadcastService
	 */
	public BroadcastService providesBroadcastService;

	/**
	 * Schema.org/genre
	 * Genre of the creative work, broadcast channel or group.
	 * @property genre
	 * @type schema,URL | schema,Text
	 */
	public Object genre;

	/**
	 * Schema.org/broadcastChannelId
	 * The unique address by which the BroadcastService can be identified in a provider lineup. In US, this is typically a number.
	 * @property broadcastChannelId
	 * @type Text
	 */
	public String broadcastChannelId;

	/**
	 * Schema.org/inBroadcastLineup
	 * The CableOrSatelliteService offering the channel.
	 * @property inBroadcastLineup
	 * @type CableOrSatelliteService
	 */
	public CableOrSatelliteService inBroadcastLineup;

	/**
	 * Schema.org/broadcastServiceTier
	 * The type of service required to have access to the channel (e.g. Standard or Premium).
	 * @property broadcastServiceTier
	 * @type Text
	 */
	public String broadcastServiceTier;

}