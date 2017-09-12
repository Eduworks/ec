package org.schema;

/**
 * Schema.org/Flight
 * An airline flight.
 * @author schema.org
 * @class Flight
 * @module org.schema
 * @extends Intangible
 */
public class Flight extends Intangible
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Flight()
	{
		context="http://schema.org/";
		type="Flight";
	}

	/**
	 * Schema.org/departureTerminal
	 * Identifier of the flight's departure terminal.
	 * @property departureTerminal
	 * @type Text
	 */
	public String departureTerminal;

	/**
	 * Schema.org/aircraft
	 * The kind of aircraft (e.g., "Boeing 747").
	 * @property aircraft
	 * @type schema,Text | schema,Vehicle
	 */
	public Object aircraft;

	/**
	 * Schema.org/departureTime
	 * The expected departure time.
	 * @property departureTime
	 * @type DateTime
	 */
	public String departureTime;

	/**
	 * Schema.org/arrivalTerminal
	 * Identifier of the flight's arrival terminal.
	 * @property arrivalTerminal
	 * @type Text
	 */
	public String arrivalTerminal;

	/**
	 * Schema.org/flightNumber
	 * The unique identifier for a flight including the airline IATA code. For example, if describing United flight 110, where the IATA code for United is 'UA', the flightNumber is 'UA110'.
	 * @property flightNumber
	 * @type Text
	 */
	public String flightNumber;

	/**
	 * Schema.org/mealService
	 * Description of the meals that will be provided or available for purchase.
	 * @property mealService
	 * @type Text
	 */
	public String mealService;

	/**
	 * Schema.org/seller
	 * An entity which offers (sells / leases / lends / loans) the services / goods.  A seller may also be a provider.
	 * @property seller
	 * @type schema,Organization | schema,Person
	 */
	public Object seller;

	/**
	 * Schema.org/arrivalTime
	 * The expected arrival time.
	 * @property arrivalTime
	 * @type DateTime
	 */
	public String arrivalTime;

	/**
	 * Schema.org/departureGate
	 * Identifier of the flight's departure gate.
	 * @property departureGate
	 * @type Text
	 */
	public String departureGate;

	/**
	 * Schema.org/estimatedFlightDuration
	 * The estimated time the flight will take.
	 * @property estimatedFlightDuration
	 * @type schema,Text | schema,Duration
	 */
	public Object estimatedFlightDuration;

	/**
	 * Schema.org/departureAirport
	 * The airport where the flight originates.
	 * @property departureAirport
	 * @type Airport
	 */
	public Airport departureAirport;

	/**
	 * Schema.org/flightDistance
	 * The distance of the flight.
	 * @property flightDistance
	 * @type schema,Text | schema,Distance
	 */
	public Object flightDistance;

	/**
	 * Schema.org/arrivalAirport
	 * The airport where the flight terminates.
	 * @property arrivalAirport
	 * @type Airport
	 */
	public Airport arrivalAirport;

	/**
	 * Schema.org/provider
	 * The service provider, service operator, or service performer; the goods producer. Another party (a seller) may offer those services or goods on behalf of the provider. A provider may also serve as the seller.
	 * @property provider
	 * @type schema,Organization | schema,Person
	 */
	public Object provider;

	/**
	 * Schema.org/webCheckinTime
	 * The time when a passenger can check into the flight online.
	 * @property webCheckinTime
	 * @type DateTime
	 */
	public String webCheckinTime;

	/**
	 * Schema.org/boardingPolicy
	 * The type of boarding policy used by the airline (e.g. zone-based or group-based).
	 * @property boardingPolicy
	 * @type BoardingPolicyType
	 */
	public BoardingPolicyType boardingPolicy;

	/**
	 * Schema.org/arrivalGate
	 * Identifier of the flight's arrival gate.
	 * @property arrivalGate
	 * @type Text
	 */
	public String arrivalGate;

	/**
	 * Schema.org/carrier
	 * 'carrier' is an out-dated term indicating the 'provider' for parcel delivery and flights.
	 * @property carrier
	 * @type Organization
	 */
	public Organization carrier;

}