package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/Place
 * Entity describing a physical location or geospatial area.
 * @author credentialengine.org
 * @class Place
 * @module org.credentialengine
 */
public class Place extends EcRemoteLinkedData
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Place()
	{
		super("http://schema.eduworks.com/simpleCtdl","Place");
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
	 * http://purl.org/ctdl/terms/description
	 * Statement, characterization or account of the entity.
	 * @property description
	 * @type langString
	 */
	public String description;

	/**
	 * http://purl.org/ctdl/terms/geoURI
	 * Entity that describes the longitude, latitude and other location details of a place.
	 * This may define a place at any scale. Examples include a city, state, province, country, or continent.
	 * @property geoURI
	 * @type anyURI
	 */
	public String geoURI;

	/**
	 * http://purl.org/ctdl/terms/latitude
	 * Latitude of a location.
	 * For example 37.42242 (WGS 84)
	 * @property latitude
	 * @type float
	 */
	public Float latitude;

	/**
	 * http://purl.org/ctdl/terms/longitude
	 * The longitude of a location.
	 * For example -122.08585 (WGS 84).
	 * @property longitude
	 * @type float
	 */
	public Float longitude;

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

	/**
	 * http://purl.org/ctdl/terms/targetContactPoint
	 * Options for contacting the organization or person.
	 * @property targetContactPoint
	 * @type ContactPoint
	 */
	public ContactPoint targetContactPoint;

}