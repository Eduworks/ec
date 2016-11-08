package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/Vehicle
 * A vehicle is a device that is designed or used to transport people or cargo over land, water, air, or through space.
 * @author schema.org
 * @class Vehicle
 * @module org.schema
 * @extends Product
 */
public class Vehicle extends Product
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Vehicle()
	{
		context="http://schema.org/";
		type="Vehicle";
	}

	/**
	 * Schema.org/vehicleConfiguration
	 * A short text indicating the configuration of the vehicle, e.g. '5dr hatchback ST 2.5 MT 225 hp' or 'limited edition'.
	 * @property vehicleConfiguration
	 * @type Text
	 */
	public String vehicleConfiguration;

	/**
	 * Schema.org/driveWheelConfiguration
	 * The drive wheel configuration, i.e. which roadwheels will receive torque from the vehicle's engine via the drivetrain.
	 * @property driveWheelConfiguration
	 * @type schema,DriveWheelConfigurationValue | schema,Text
	 */
	public Object driveWheelConfiguration;

	/**
	 * Schema.org/vehicleInteriorColor
	 * The color or color combination of the interior of the vehicle.
	 * @property vehicleInteriorColor
	 * @type Text
	 */
	public String vehicleInteriorColor;

	/**
	 * Schema.org/numberOfDoors
	 * The number of doors.\n\nTypical unit code(s): C62
	 * @property numberOfDoors
	 * @type schema,QuantitativeValue | schema,Number
	 */
	public Object numberOfDoors;

	/**
	 * Schema.org/vehicleTransmission
	 * The type of component used for transmitting the power from a rotating power source to the wheels or other relevant component(s) ("gearbox" for cars).
	 * @property vehicleTransmission
	 * @type schema,QualitativeValue | schema,URL | schema,Text
	 */
	public Object vehicleTransmission;

	/**
	 * Schema.org/vehicleSeatingCapacity
	 * The number of passengers that can be seated in the vehicle, both in terms of the physical space available, and in terms of limitations set by law.\n\nTypical unit code(s): C62 for persons.
	 * @property vehicleSeatingCapacity
	 * @type schema,QuantitativeValue | schema,Number
	 */
	public Object vehicleSeatingCapacity;

	/**
	 * Schema.org/cargoVolume
	 * The available volume for cargo or luggage. For automobiles, this is usually the trunk volume.\n\nTypical unit code(s): LTR for liters, FTQ for cubic foot/feet\n\nNote: You can use [[minValue]] and [[maxValue]] to indicate ranges.
	 * @property cargoVolume
	 * @type QuantitativeValue
	 */
	public QuantitativeValue cargoVolume;

	/**
	 * Schema.org/knownVehicleDamages
	 * A textual description of known damages, both repaired and unrepaired.
	 * @property knownVehicleDamages
	 * @type Text
	 */
	public String knownVehicleDamages;

	/**
	 * Schema.org/vehicleEngine
	 * Information about the engine or engines of the vehicle.
	 * @property vehicleEngine
	 * @type EngineSpecification
	 */
	public EngineSpecification vehicleEngine;

	/**
	 * Schema.org/steeringPosition
	 * The position of the steering wheel or similar device (mostly for cars).
	 * @property steeringPosition
	 * @type SteeringPositionValue
	 */
	public SteeringPositionValue steeringPosition;

	/**
	 * Schema.org/vehicleIdentificationNumber
	 * The Vehicle Identification Number (VIN) is a unique serial number used by the automotive industry to identify individual motor vehicles.
	 * @property vehicleIdentificationNumber
	 * @type Text
	 */
	public String vehicleIdentificationNumber;

	/**
	 * Schema.org/productionDate
	 * The date of production of the item, e.g. vehicle.
	 * @property productionDate
	 * @type Date
	 */
	public String productionDate;

	/**
	 * Schema.org/vehicleModelDate
	 * The release date of a vehicle model (often used to differentiate versions of the same make and model).
	 * @property vehicleModelDate
	 * @type Date
	 */
	public String vehicleModelDate;

	/**
	 * Schema.org/numberOfForwardGears
	 * The total number of forward gears available for the transmission system of the vehicle.\n\nTypical unit code(s): C62
	 * @property numberOfForwardGears
	 * @type schema,QuantitativeValue | schema,Number
	 */
	public Object numberOfForwardGears;

	/**
	 * Schema.org/fuelConsumption
	 * The amount of fuel consumed for traveling a particular distance or temporal duration with the given vehicle (e.g. liters per 100 km).\n\n* Note 1: There are unfortunately no standard unit codes for liters per 100 km.  Use [[unitText]] to indicate the unit of measurement, e.g. L/100 km.\n* Note 2: There are two ways of indicating the fuel consumption, [[fuelConsumption]] (e.g. 8 liters per 100 km) and [[fuelEfficiency]] (e.g. 30 miles per gallon). They are reciprocal.\n* Note 3: Often, the absolute value is useful only when related to driving speed ("at 80 km/h") or usage pattern ("city traffic"). You can use [[valueReference]] to link the value for the fuel consumption to another value.
	 * @property fuelConsumption
	 * @type QuantitativeValue
	 */
	public QuantitativeValue fuelConsumption;

	/**
	 * Schema.org/numberOfAirbags
	 * The number or type of airbags in the vehicle.
	 * @property numberOfAirbags
	 * @type schema,Number | schema,Text
	 */
	public Object numberOfAirbags;

	/**
	 * Schema.org/purchaseDate
	 * The date the item e.g. vehicle was purchased by the current owner.
	 * @property purchaseDate
	 * @type Date
	 */
	public String purchaseDate;

	/**
	 * Schema.org/numberOfPreviousOwners
	 * The number of owners of the vehicle, including the current one.\n\nTypical unit code(s): C62
	 * @property numberOfPreviousOwners
	 * @type schema,QuantitativeValue | schema,Number
	 */
	public Object numberOfPreviousOwners;

	/**
	 * Schema.org/dateVehicleFirstRegistered
	 * The date of the first registration of the vehicle with the respective public authorities.
	 * @property dateVehicleFirstRegistered
	 * @type Date
	 */
	public String dateVehicleFirstRegistered;

	/**
	 * Schema.org/mileageFromOdometer
	 * The total distance travelled by the particular vehicle since its initial production, as read from its odometer.\n\nTypical unit code(s): KMT for kilometers, SMI for statute miles
	 * @property mileageFromOdometer
	 * @type QuantitativeValue
	 */
	public QuantitativeValue mileageFromOdometer;

	/**
	 * Schema.org/fuelEfficiency
	 * The distance traveled per unit of fuel used; most commonly miles per gallon (mpg) or kilometers per liter (km/L).\n\n* Note 1: There are unfortunately no standard unit codes for miles per gallon or kilometers per liter. Use [[unitText]] to indicate the unit of measurement, e.g. mpg or km/L.\n* Note 2: There are two ways of indicating the fuel consumption, [[fuelConsumption]] (e.g. 8 liters per 100 km) and [[fuelEfficiency]] (e.g. 30 miles per gallon). They are reciprocal.\n* Note 3: Often, the absolute value is useful only when related to driving speed ("at 80 km/h") or usage pattern ("city traffic"). You can use [[valueReference]] to link the value for the fuel economy to another value.
	 * @property fuelEfficiency
	 * @type QuantitativeValue
	 */
	public QuantitativeValue fuelEfficiency;

	/**
	 * Schema.org/fuelType
	 * The type of fuel suitable for the engine or engines of the vehicle. If the vehicle has only one engine, this property can be attached directly to the vehicle.
	 * @property fuelType
	 * @type schema,QualitativeValue | schema,URL | schema,Text
	 */
	public Object fuelType;

	/**
	 * Schema.org/numberOfAxles
	 * The number of axles.\n\nTypical unit code(s): C62
	 * @property numberOfAxles
	 * @type schema,QuantitativeValue | schema,Number
	 */
	public Object numberOfAxles;

	/**
	 * Schema.org/vehicleSpecialUsage
	 * Indicates whether the vehicle has been used for special purposes, like commercial rental, driving school, or as a taxi. The legislation in many countries requires this information to be revealed when offering a car for sale.
	 * @property vehicleSpecialUsage
	 * @type Text
	 */
	public String vehicleSpecialUsage;

	/**
	 * Schema.org/vehicleInteriorType
	 * The type or material of the interior of the vehicle (e.g. synthetic fabric, leather, wood, etc.). While most interior types are characterized by the material used, an interior type can also be based on vehicle usage or target audience.
	 * @property vehicleInteriorType
	 * @type Text
	 */
	public String vehicleInteriorType;

}