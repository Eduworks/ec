package org.schema;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * Schema.org/MobileApplication
 * A software application designed specifically to work well on a mobile device such as a telephone.
 * @author schema.org
 * @module schema.org
 * @class MobileApplication
 * @extends SoftwareApplication
 */
public class MobileApplication extends SoftwareApplication
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public MobileApplication()
	{
		context="http://schema.org/";
		type="MobileApplication";
	}

	/**
	 * Schema.org/carrierRequirements
	 * Specifies specific carrier(s) requirements for the application (e.g. an application may only work on a specific carrier network).
	 * @property carrierRequirements
	 * @type Text
	 */
	public String carrierRequirements;

}