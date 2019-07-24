package org.schema;

/**
 * Schema.org/DriveWheelConfigurationValue
 * A value indicating which roadwheels will receive torque.
 *
 * @author schema.org
 * @class DriveWheelConfigurationValue
 * @module org.schema
 * @extends QualitativeValue
 */
public class DriveWheelConfigurationValue extends QualitativeValue {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public DriveWheelConfigurationValue() {
		context = "http://schema.org/";
		type = "DriveWheelConfigurationValue";
	}

}