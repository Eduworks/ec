package org.credentialengine;

/**
 * credentialengine.org/InstructionalProgramClassification
 * The class of enumerations identifying instructional programs.
 *
 * @author credentialengine.org
 * @class InstructionalProgramClassification
 * @module org.credentialengine
 * @extends CredentialFramework
 */
public class InstructionalProgramClassification extends CredentialFramework {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public InstructionalProgramClassification() {
		context = "http://schema.eduworks.com/simpleCtdl";
		type = "InstructionalProgramClassification";
	}

}