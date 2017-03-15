package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/CredentialAssertion
 * The class of  representations of an awarded credential, used to share information about a credential belonging to one holder.
 * @author credentialengine.org
 * @class CredentialAssertion
 * @module org.credentialengine
 */
public class CredentialAssertion extends EcRemoteLinkedData
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public CredentialAssertion()
	{
		super(null,null);
		context="http://purl.org/ctdl/terms/";
		type="CredentialAssertion";
	}

}