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
		context="http://purl.org/ctdl/terms/";
		type="JurisdictionProfile";
	}

	/**
	 * credentialengine.org/assertedBy
	 * The agent providing the information contained in the entity being described.
	 * @property assertedBy
	 * @type CredentialOrganization | CredentialPerson | QACredentialOrganization
	 */
	public Object assertedBy;

	/**
	 * credentialengine.org/description
	 * A short description of the resource being described.
	 * @property description
	 * @type Literal
	 */
	public String description;

}