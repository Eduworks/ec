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
		context="http://schema.eduworks.com/simpleCtdl";
		type="CostProfile";
	}

	/**
	 * http://purl.org/ctdl/terms/audienceType
	 * The applicable audience.
	 * @property audienceType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject audienceType;

	/**
	 * http://purl.org/ctdl/terms/description
	 * A short description of the resource being described.
	 * @property description
	 * @type Literal
	 */
	public String description;

	/**
	 * http://purl.org/ctdl/terms/endDate
	 * The end date of something.
	 * @property endDate
	 * @type date
	 */
	public String endDate;

	/**
	 * http://purl.org/ctdl/terms/jurisdiction
	 * The geo-political region in which the described resource is applicable.
	 * @property jurisdiction
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile jurisdiction;

	/**
	 * http://purl.org/ctdl/terms/name
	 * The name of the resource being described.
	 * @property name
	 * @type Literal
	 */
	public String name;

	/**
	 * http://purl.org/ctdl/terms/region
	 * A geo-political area of the described resource.
	 * @property region
	 * @type GeoCoordinates
	 */
	public GeoCoordinates region;

	/**
	 * http://purl.org/ctdl/terms/startDate
	 * The start date of something.
	 * @property startDate
	 * @type date
	 */
	public String startDate;

}