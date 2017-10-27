package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/CostManifest
 * Entity that describes a set of costs maintained at, and applicable across the organizational and/or sub-organizational level.
 * Instances of these ceterms:CostManifest entities are intended to be referenced by other entities to augment the process of describing their costs.
 * @author credentialengine.org
 * @class CostManifest
 * @module org.credentialengine
 */
public class CostManifest extends EcRemoteLinkedData
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public CostManifest()
	{
		super("http://schema.eduworks.com/simpleCtdl","CostManifest");
	}

	/**
	 * http://purl.org/ctdl/terms/costDetails
	 * Webpage or online document containing human-readable, in-depth information about costs.
	 * @property costDetails
	 * @type anyURI
	 */
	public String costDetails;

	/**
	 * http://purl.org/ctdl/terms/costManifestOf
	 * Organization maintaining the cost manifest.
	 * @property costManifestOf
	 * @type CredentialOrganization | QACredentialOrganization
	 */
	public Object costManifestOf;

	/**
	 * http://purl.org/ctdl/terms/ctid
	 * Globally unique Credential Transparency Identifier (CTID) by which the creator, owner or provider of a credential, learning opportunity competency, or assessment recognizes the entity in transactions with the external environment (e.g., in verifiable claims involving a credential).
	 * The CTID is the equivalent of a version identifier for the resource. Different versions of a resource are considered distinct expressions and each must be assigned its own CTID. Each version of a resource can have only one CTID assigned. However, a single version of a resource may have distinct identifier values for both the ctid property and the credentialId property. In such a case both identifiers will be recognized by the resource creator/owner/provider in transactions with the external environment.
	 * @property ctid
	 * @type string
	 */
	public string ctid;

	/**
	 * http://purl.org/ctdl/terms/description
	 * Statememnt, characterization or account of the entity.
	 * @property description
	 * @type langString
	 */
	public langString description;

	/**
	 * http://purl.org/ctdl/terms/endDate
	 * Date some event or activity ends.
	 * @property endDate
	 * @type date
	 */
	public String endDate;

	/**
	 * http://purl.org/ctdl/terms/estimatedCost
	 * Estimated cost of a credential, learning opportunity or assessment.
	 * @property estimatedCost
	 * @type CostProfile
	 */
	public CostProfile estimatedCost;

	/**
	 * http://purl.org/ctdl/terms/name
	 * Name or title of the entity.
	 * @property name
	 * @type langString
	 */
	public langString name;

	/**
	 * http://purl.org/ctdl/terms/startDate
	 * Date the validity or usefulness of the information in this resource begins.
	 * @property startDate
	 * @type date
	 */
	public String startDate;

}