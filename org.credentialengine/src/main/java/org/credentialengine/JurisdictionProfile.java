package org.credentialengine;

/**
 * credentialengine.org/JurisdictionProfile
 * Geo-political information about applicable geographic areas and their exceptions.
 *
 * @author credentialengine.org
 * @class JurisdictionProfile
 * @module org.credentialengine
 * @extends CreativeWork
 */
public class JurisdictionProfile extends org.schema.CreativeWork {
	/**
	 * http://purl.org/ctdl/terms/assertedBy
	 * The agent providing the information contained in the entity being described.
	 *
	 * @property assertedBy
	 * @type CredentialOrganization | CredentialPerson | QACredentialOrganization
	 */
	public Object assertedBy;
	/**
	 * http://purl.org/ctdl/terms/description
	 * A short description of the resource being described.
	 *
	 * @property description
	 * @type Literal
	 */
	public String description;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public JurisdictionProfile() {
		context = "http://schema.eduworks.com/simpleCtdl";
		type = "JurisdictionProfile";
	}

}