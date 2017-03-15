package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/CostProfile
 * The type and nature of direct costs one would incur if one were to pursue attaining a credential.
 * @author credentialengine.org
 * @class CostProfile
 * @module org.credentialengine
 * @extends CreativeWork
 */
public class CostProfile extends org.schema.CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public CostProfile()
	{
		context="http://purl.org/ctdl/terms/";
		type="CostProfile";
	}

	/**
	 * credentialengine.org/audienceType
	 * The applicable audience.
	 * @property audienceType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject audienceType;

	/**
	 * credentialengine.org/description
	 * A short description of the resource being described.
	 * @property description
	 * @type Literal
	 */
	public String description;

	/**
	 * credentialengine.org/endTime
	 * The endTime of something.
	 * @property endTime
	 * @type dateTime
	 */
	public String endTime;

	/**
	 * credentialengine.org/jurisdiction
	 * The geo-political region in which the described resource is applicable.
	 * @property jurisdiction
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile jurisdiction;

	/**
	 * credentialengine.org/name
	 * The name of the resource being described.
	 * @property name
	 * @type Literal
	 */
	public String name;

	/**
	 * credentialengine.org/region
	 * A geo-political area of the described resource.
	 * @property region
	 * @type GeoCoordinates
	 */
	public GeoCoordinates region;

	/**
	 * credentialengine.org/startTime
	 * The startTime of something.
	 * @property startTime
	 * @type dateTime
	 */
	public String startTime;

}