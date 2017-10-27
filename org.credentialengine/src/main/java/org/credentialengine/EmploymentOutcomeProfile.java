package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/EmploymentOutcomeProfile
 * Entity that describes employment outcomes and related statistical information for a given credential.
 * @author credentialengine.org
 * @class EmploymentOutcomeProfile
 * @module org.credentialengine
 * @extends CreativeWork
 */
public class EmploymentOutcomeProfile extends org.schema.CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public EmploymentOutcomeProfile()
	{
		context="http://schema.eduworks.com/simpleCtdl";
		type="EmploymentOutcomeProfile";
	}

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
	public String description;

	/**
	 * http://purl.org/ctdl/terms/jobsObtained
	 * Number of jobs obtained in the region during a given timeframe.
	 * @property jobsObtained
	 * @type integer
	 */
	public Integer jobsObtained;

	/**
	 * http://purl.org/ctdl/terms/jurisdiction
	 * Geographic or political region in which the credential is formally applicable or an organization has authority to act.
	 * @property jurisdiction
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile jurisdiction;

	/**
	 * http://purl.org/ctdl/terms/source
	 * Authoritative source of an entity's information.
	 * Citation or description of an authoritative souce from which information or description has been derived.
	 * @property source
	 * @type anyURI
	 */
	public String source;

}