package org.credentialengine;

/**
 * credentialengine.org/TaskProfile
 * A profile describing the required or recommended tasks to be performed by a holder of, or applicant for, a credential assertion.
 * @author credentialengine.org
 * @class TaskProfile
 * @module org.credentialengine
 * @extends CreativeWork
 */
public class TaskProfile extends org.schema.CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public TaskProfile()
	{
		context="http://schema.eduworks.com/simpleCtdl";
		type="TaskProfile";
	}

	/**
	 * http://purl.org/ctdl/terms/availabilityListing
	 * A resource that lists online and/or physical locations for the described resource.
	 * @property availabilityListing
	 * @type anyURI
	 */
	public String availabilityListing;

	/**
	 * http://purl.org/ctdl/terms/availableAt
	 * The location where the described resource is available.
	 * @property availableAt
	 * @type GeoCoordinates
	 */
	public GeoCoordinates availableAt;

	/**
	 * http://purl.org/ctdl/terms/availableOnlineAt
	 * The online location where the described resource is available.
	 * @property availableOnlineAt
	 * @type anyURI
	 */
	public String availableOnlineAt;

	/**
	 * http://purl.org/ctdl/terms/dateEffective
	 * The effective date of the described resource content.
	 * @property dateEffective
	 * @type date
	 */
	public String dateEffective;

	/**
	 * http://purl.org/ctdl/terms/description
	 * A short description of the resource being described.
	 * @property description
	 * @type Literal
	 */
	public String description;

	/**
	 * http://purl.org/ctdl/terms/estimatedCost
	 * The estimated cost of the described resource.
	 * @property estimatedCost
	 * @type CostProfile
	 */
	public CostProfile estimatedCost;

	/**
	 * http://purl.org/ctdl/terms/estimatedDuration
	 * The estimated time it will take to complete the described activity.
	 * @property estimatedDuration
	 * @type DurationProfile
	 */
	public DurationProfile estimatedDuration;

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

}