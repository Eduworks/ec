package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/GeoCoordinates
 * Geographic coordinates of a place or event including latitude and longitude as well as other locational information.
 * @author credentialengine.org
 * @class GeoCoordinates
 * @module org.credentialengine
 * @extends StructuredValue
 */
public class GeoCoordinates extends org.schema.StructuredValue
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public GeoCoordinates()
	{
		context="http://schema.eduworks.com/simpleCtdl";
		type="GeoCoordinates";
	}

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

}