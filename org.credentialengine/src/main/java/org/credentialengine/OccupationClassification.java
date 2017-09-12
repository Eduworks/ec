package org.credentialengine;

/**
 * credentialengine.org/OccupationClassification
 * The class of enumerations identifying occupations.
 *
 * @author credentialengine.org
 * @class OccupationClassification
 * @module org.credentialengine
 * @extends CredentialFramework
 */
public class OccupationClassification extends CredentialFramework {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public OccupationClassification() {
		context = "http://schema.eduworks.com/simpleCtdl";
		type = "OccupationClassification";
	}

}