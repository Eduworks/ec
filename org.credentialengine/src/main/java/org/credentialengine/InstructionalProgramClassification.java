package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/InstructionalProgramClassification
 * Class of concept schemes defining instructional program types such as the CIP codes in the U.S.
 * @author credentialengine.org
 * @class InstructionalProgramClassification
 * @module org.credentialengine
 * @extends CredentialFramework
 */
public class InstructionalProgramClassification extends CredentialFramework
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public InstructionalProgramClassification()
	{
		context="http://schema.eduworks.com/simpleCtdl";
		type="InstructionalProgramClassification";
	}

}