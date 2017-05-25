package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/IndustryClassification
 * The class of enumerations identifying industries.
 * @author credentialengine.org
 * @class IndustryClassification
 * @module org.credentialengine
 * @extends CredentialFramework
 */
public class IndustryClassification extends CredentialFramework
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public IndustryClassification()
	{
		context="http://schema.eduworks.com/simpleCtdl";
		type="IndustryClassification";
	}

}