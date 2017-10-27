package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/JurisdictionProfile
 * Geo-political information about applicable geographic areas and their exceptions.
 * @author credentialengine.org
 * @class JurisdictionProfile
 * @module org.credentialengine
 * @extends CreativeWork
 */
public class JurisdictionProfile extends org.schema.CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public JurisdictionProfile()
	{
		context="http://schema.eduworks.com/simpleCtdl";
		type="JurisdictionProfile";
	}

	/**
	 * http://purl.org/ctdl/terms/assertedBy
	 * Agent making a statement based on fact or belief.
	 * @property assertedBy
	 * @type CredentialOrganization | CredentialPerson | QACredentialOrganization
	 */
	public Object assertedBy;

	/**
	 * http://purl.org/ctdl/terms/description
	 * Statememnt, characterization or account of the entity.
	 * @property description
	 * @type langString
	 */
	public String description;

	/**
	 * http://purl.org/ctdl/terms/globalJurisdiction
	 * Whether or not the credential is useful, applicable or recognized everywhere.
	 * Exceptions indicated by the ceterms:jurisdictionException property apply.
	 * @property globalJurisdiction
	 * @type boolean
	 */
	public boolean globalJurisdiction;

	/**
	 * http://purl.org/ctdl/terms/jurisdictionException
	 * Geographic or political region in which the credential is not formally recognized or an organization has no authority to act .
	 * The ceterms:jurisdictionalException property is used in conjunction with the ceterms:jurisdiction property and expresses any exceptions to a more general statement; e.g., the United states except for Colorado.
	 * @property jurisdictionException
	 * @type Place
	 */
	public Place jurisdictionException;

	/**
	 * http://purl.org/ctdl/terms/mainJurisdiction
	 * Primary geographic or political region in which the credential is recognized as applicable or in which an organization has recognized authority to act.
	 * @property mainJurisdiction
	 * @type Place
	 */
	public Place mainJurisdiction;

}