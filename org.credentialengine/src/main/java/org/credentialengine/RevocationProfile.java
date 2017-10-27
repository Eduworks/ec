package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/RevocationProfile
 * Entity describing conditions and methods by which a credential can be removed from a holder.
 * @author credentialengine.org
 * @class RevocationProfile
 * @module org.credentialengine
 * @extends CreativeWork
 */
public class RevocationProfile extends org.schema.CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public RevocationProfile()
	{
		context="http://schema.eduworks.com/simpleCtdl";
		type="RevocationProfile";
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
	public langString description;

	/**
	 * http://purl.org/ctdl/terms/jurisdiction
	 * Geographic or political region in which the credential is formally applicable or an organization has authority to act.
	 * @property jurisdiction
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile jurisdiction;

	/**
	 * http://purl.org/ctdl/terms/region
	 * Entity that describes the longitude, latitude and other location details of an area.
	 * @property region
	 * @type Place
	 */
	public Place region;

	/**
	 * http://purl.org/ctdl/terms/revocationCriteria
	 * Webpage or online document that provides information about the removal criteria for an awarded credential.
	 * @property revocationCriteria
	 * @type anyURI
	 */
	public String revocationCriteria;

	/**
	 * http://purl.org/ctdl/terms/revocationCriteriaDescription
	 * Textual description providing information about the removal criteria for an awarded credential.
	 * @property revocationCriteriaDescription
	 * @type langString
	 */
	public langString revocationCriteriaDescription;

}