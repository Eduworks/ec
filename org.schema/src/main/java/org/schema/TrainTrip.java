package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/TrainTrip
 * A trip on a commercial train line.
 * @author schema.org
 * @class TrainTrip
 * @module org.schema
 * @extends Intangible
 */
public class TrainTrip extends Intangible
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public TrainTrip()
	{
		context="http://schema.org/";
		type="TrainTrip";
	}

	/**
	 * Schema.org/departureTime
	 * The expected departure time.
	 * @property departureTime
	 * @type DateTime
	 */
	public String departureTime;

	/**
	 * Schema.org/departureStation
	 * The station from which the train departs.
	 * @property departureStation
	 * @type TrainStation
	 */
	public TrainStation departureStation;

	/**
	 * Schema.org/arrivalStation
	 * The station where the train trip ends.
	 * @property arrivalStation
	 * @type TrainStation
	 */
	public TrainStation arrivalStation;

	/**
	 * Schema.org/arrivalTime
	 * The expected arrival time.
	 * @property arrivalTime
	 * @type DateTime
	 */
	public String arrivalTime;

	/**
	 * Schema.org/trainName
	 * The name of the train (e.g. The Orient Express).
	 * @property trainName
	 * @type Text
	 */
	public String trainName;

	/**
	 * Schema.org/departurePlatform
	 * The platform from which the train departs.
	 * @property departurePlatform
	 * @type Text
	 */
	public String departurePlatform;

	/**
	 * Schema.org/provider
	 * The service provider, service operator, or service performer; the goods producer. Another party (a seller) may offer those services or goods on behalf of the provider. A provider may also serve as the seller.
	 * @property provider
	 * @type schema,Organization | schema,Person
	 */
	public Object provider;

	/**
	 * Schema.org/arrivalPlatform
	 * The platform where the train arrives.
	 * @property arrivalPlatform
	 * @type Text
	 */
	public String arrivalPlatform;

	/**
	 * Schema.org/trainNumber
	 * The unique identifier for the train.
	 * @property trainNumber
	 * @type Text
	 */
	public String trainNumber;

}