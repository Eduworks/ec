package org.schema;

/**
 * Schema.org/BusTrip
 * A trip on a commercial bus line.
 *
 * @author schema.org
 * @class BusTrip
 * @module org.schema
 * @extends Intangible
 */
public class BusTrip extends Intangible {
	/**
	 * Schema.org/departureTime
	 * The expected departure time.
	 *
	 * @property departureTime
	 * @type DateTime
	 */
	public String departureTime;
	/**
	 * Schema.org/busNumber
	 * The unique identifier for the bus.
	 *
	 * @property busNumber
	 * @type Text
	 */
	public String busNumber;
	/**
	 * Schema.org/departureBusStop
	 * The stop or station from which the bus departs.
	 *
	 * @property departureBusStop
	 * @type schema, BusStation | schema,BusStop
	 */
	public Object departureBusStop;
	/**
	 * Schema.org/arrivalTime
	 * The expected arrival time.
	 *
	 * @property arrivalTime
	 * @type DateTime
	 */
	public String arrivalTime;
	/**
	 * Schema.org/provider
	 * The service provider, service operator, or service performer; the goods producer. Another party (a seller) may offer those services or goods on behalf of the provider. A provider may also serve as the seller.
	 *
	 * @property provider
	 * @type schema, Organization | schema,Person
	 */
	public Object provider;
	/**
	 * Schema.org/arrivalBusStop
	 * The stop or station from which the bus arrives.
	 *
	 * @property arrivalBusStop
	 * @type schema, BusStation | schema,BusStop
	 */
	public Object arrivalBusStop;
	/**
	 * Schema.org/busName
	 * The name of the bus (e.g. Bolt Express).
	 *
	 * @property busName
	 * @type Text
	 */
	public String busName;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public BusTrip() {
		context = "http://schema.org/";
		type = "BusTrip";
	}

}