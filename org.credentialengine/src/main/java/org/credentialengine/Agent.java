package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/Agent
 * Organization or person that acts or has the power to act.
 * Broad type that includes both organizations and people who play roles in the lifecycle of a credential.
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
		super("http://schema.eduworks.com/simpleCtdl","Agent");
	}

	/**
	 * http://purl.org/ctdl/terms/hasAlignmentMap
	 * Alignment map owned by the agent.
	 * @property hasAlignmentMap
	 * @type AlignmentMap
	 */
	public AlignmentMap hasAlignmentMap;

}