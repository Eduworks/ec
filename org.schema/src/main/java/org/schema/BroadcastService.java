package org.schema;

/**
 * Schema.org/BroadcastService
 * A delivery service through which content is provided via broadcast over the air or online.
 * @author schema.org
 * @class BroadcastService
 * @module org.schema
 * @extends Service
 */
public class BroadcastService extends Service
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public BroadcastService()
	{
		context="http://schema.org/";
		type="BroadcastService";
	}

	/**
	 * Schema.org/broadcastTimezone
	 * The timezone in [ISO 8601 format](http://en.wikipedia.org/wiki/ISO_8601) for which the service bases its broadcasts
	 * @property broadcastTimezone
	 * @type Text
	 */
	public String broadcastTimezone;

	/**
	 * Schema.org/area
	 * The area within which users can expect to reach the broadcast service.
	 * @property area
	 * @type Place
	 */
	public Place area;

	/**
	 * Schema.org/videoFormat
	 * The type of screening or video broadcast used (e.g. IMAX, 3D, SD, HD, etc.).
	 * @property videoFormat
	 * @type Text
	 */
	public String videoFormat;

	/**
	 * Schema.org/broadcastDisplayName
	 * The name displayed in the channel guide. For many US affiliates, it is the network name.
	 * @property broadcastDisplayName
	 * @type Text
	 */
	public String broadcastDisplayName;

	/**
	 * Schema.org/broadcastAffiliateOf
	 * The media network(s) whose content is broadcast on this station.
	 * @property broadcastAffiliateOf
	 * @type Organization
	 */
	public Organization broadcastAffiliateOf;

	/**
	 * Schema.org/parentService
	 * A broadcast service to which the broadcast service may belong to such as regional variations of a national channel.
	 * @property parentService
	 * @type BroadcastService
	 */
	public BroadcastService parentService;

	/**
	 * Schema.org/broadcaster
	 * The organization owning or operating the broadcast service.
	 * @property broadcaster
	 * @type Organization
	 */
	public Organization broadcaster;

}