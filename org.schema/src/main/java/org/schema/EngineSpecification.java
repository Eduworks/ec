package org.schema;

/**
 * Schema.org/EngineSpecification
 * Information about the engine of the vehicle. A vehicle can have multiple engines represented by multiple engine specification entities.
 *
 * @author schema.org
 * @class EngineSpecification
 * @module org.schema
 * @extends StructuredValue
 */
public class EngineSpecification extends StructuredValue {
	/**
	 * Schema.org/fuelType
	 * The type of fuel suitable for the engine or engines of the vehicle. If the vehicle has only one engine, this property can be attached directly to the vehicle.
	 *
	 * @property fuelType
	 * @type Text
	 */
	public String fuelType;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public EngineSpecification() {
		context = "http://schema.org/";
		type = "EngineSpecification";
	}

}