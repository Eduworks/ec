package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/TaskProfile
 * Entity describing the required or recommended tasks to be performed by a holder of, or applicant for, a credential.
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
	 * http://purl.org/ctdl/terms/affiliatedAgent
	 * Organization or person that plays some role in assigning, performing, assisting with, facilitating, approving of, or otherwise being involved with the task being described.
	 * @property affiliatedAgent
	 * @type CredentialOrganization | CredentialPerson | QACredentialOrganization
	 */
	public Object affiliatedAgent;

	/**
	 * http://purl.org/ctdl/terms/availabilityListing
	 * Listing of online and/or physical locations where a credential can be pursued.
	 * @property availabilityListing
	 * @type anyURI
	 */
	public String availabilityListing;

	/**
	 * http://purl.org/ctdl/terms/availableAt
	 * Physical location where the credential, assessment, or learning opportunity can be pursued.
	 * @property availableAt
	 * @type Place
	 */
	public Place availableAt;

	/**
	 * http://purl.org/ctdl/terms/availableOnlineAt
	 * Online location where the credential, assessment, or learning opportunity can be pursued.
	 * @property availableOnlineAt
	 * @type anyURI
	 */
	public String availableOnlineAt;

	/**
	 * http://purl.org/ctdl/terms/dateEffective
	 * Effective date of the content of a credential, assessment or learning opportunity.
	 * @property dateEffective
	 * @type date
	 */
	public String dateEffective;

	/**
	 * http://purl.org/ctdl/terms/description
	 * Statememnt, characterization or account of the entity.
	 * @property description
	 * @type langString
	 */
	public langString description;

	/**
	 * http://purl.org/ctdl/terms/estimatedCost
	 * Estimated cost of a credential, learning opportunity or assessment.
	 * @property estimatedCost
	 * @type CostProfile
	 */
	public CostProfile estimatedCost;

	/**
	 * http://purl.org/ctdl/terms/estimatedDuration
	 * Estimated time it will take to complete a credential, learning opportunity or assessment.
	 * @property estimatedDuration
	 * @type DurationProfile
	 */
	public DurationProfile estimatedDuration;

	/**
	 * http://purl.org/ctdl/terms/jurisdiction
	 * Geographic or political region in which the credential is formally applicable or an organization has authority to act.
	 * @property jurisdiction
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile jurisdiction;

	/**
	 * http://purl.org/ctdl/terms/name
	 * Name or title of the entity.
	 * @property name
	 * @type langString
	 */
	public langString name;

	/**
	 * http://purl.org/ctdl/terms/taskDetails
	 * Webpage or online document that provides additional information about the task.
	 * @property taskDetails
	 * @type anyURI
	 */
	public String taskDetails;

}