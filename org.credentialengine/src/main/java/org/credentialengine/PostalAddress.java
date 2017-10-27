package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/PostalAddress
 * Entity describing a mailing address.
 * @author credentialengine.org
 * @class PostalAddress
 * @module org.credentialengine
 * @extends ContactPoint
 */
public class PostalAddress extends ContactPoint
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public PostalAddress()
	{
		context="http://schema.eduworks.com/simpleCtdl";
		type="PostalAddress";
	}

	/**
	 * http://purl.org/ctdl/terms/addressCountry
	 * Nation with its own government and occupying a particular territory identified by the two-letter ISO 3166-1 alpha-2 country code.
	 * @property addressCountry
	 * @type langString
	 */
	public String addressCountry;

	/**
	 * http://purl.org/ctdl/terms/addressLocality
	 * Town, city, or village in which a particular location is situtated.
	 * @property addressLocality
	 * @type langString
	 */
	public String addressLocality;

	/**
	 * http://purl.org/ctdl/terms/addressRegion
	 * State or province in which a particular location is situtated.
	 * @property addressRegion
	 * @type langString
	 */
	public String addressRegion;

	/**
	 * http://purl.org/ctdl/terms/name
	 * Name or title of the entity.
	 * @property name
	 * @type langString
	 */
	public String name;

	/**
	 * http://purl.org/ctdl/terms/postalCode
	 * The postal code. For example, 94043.
	 * @property postalCode
	 * @type string
	 */
	public String postalCode;

	/**
	 * http://purl.org/ctdl/terms/postOfficeBoxNumber
	 * Post office box number for post office addresses.
	 * @property postOfficeBoxNumber
	 * @type string
	 */
	public String postOfficeBoxNumber;

	/**
	 * http://purl.org/ctdl/terms/streetAddress
	 * Street address. e.g. "1600 Amphitheatre Pkwy".
	 * @property streetAddress
	 * @type langString
	 */
	public String streetAddress;

}