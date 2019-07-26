package org.schema;

/**
 * Schema.org/Car
 * A car is a wheeled, self-powered motor vehicle used for transportation.
 *
 * @author schema.org
 * @class Car
 * @module org.schema
 * @extends Vehicle
 */
public class Car extends Vehicle {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Car() {
		context = "http://schema.org/";
		type = "Car";
	}

}