package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/InstructionalProgramClassification
 * The class of enumerations identifying instructional programs.
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
		context="http://purl.org/ctdl/terms/";
		type="InstructionalProgramClassification";
	}

}