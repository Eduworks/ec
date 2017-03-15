package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/GeoCoordinates
 * The geographic coordinates of a place or event.
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
		context="http://purl.org/ctdl/terms/";
		type="GeoCoordinates";
	}

	/**
	 * credentialengine.org/address
	 * Physical address of the resource.
	 * @property address
	 * @type PostalAddress
	 */
	public PostalAddress address;

	/**
	 * credentialengine.org/name
	 * The name of the resource being described.
	 * @property name
	 * @type Literal
	 */
	public String name;

	/**
	 * credentialengine.org/url
	 * URL of the resource being described.
	 * @property url
	 * @type anyURI
	 */
	public String url;

}