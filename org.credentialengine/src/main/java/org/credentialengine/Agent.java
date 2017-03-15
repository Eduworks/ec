package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/Agent
 * A resource that acts or has the power to act.
 * @author credentialengine.org
 * @class Agent
 * @module org.credentialengine
 */
public class Agent extends EcRemoteLinkedData
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Agent()
	{
		super(null,null);
		context="http://purl.org/ctdl/terms/";
		type="Agent";
	}

}