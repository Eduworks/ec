package org.schema;

/**
 * Schema.org/MobileApplication
 * A software application designed specifically to work well on a mobile device such as a telephone.
 *
 * @author schema.org
 * @class MobileApplication
 * @module org.schema
 * @extends SoftwareApplication
 */
public class MobileApplication extends SoftwareApplication {
	/**
	 * Schema.org/carrierRequirements
	 * Specifies specific carrier(s) requirements for the application (e.g. an application may only work on a specific carrier network).
	 *
	 * @property carrierRequirements
	 * @type Text
	 */
	public String carrierRequirements;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public MobileApplication() {
		context = "http://schema.org/";
		type = "MobileApplication";
	}

}