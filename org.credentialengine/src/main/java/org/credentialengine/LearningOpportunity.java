package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/LearningOpportunity
 * Structured and unstructured learning and development opportunities based in direct experience, formal and informal study, observation, and involvement in discourse and practice.
 * @author credentialengine.org
 * @class LearningOpportunity
 * @module org.credentialengine
 */
public class LearningOpportunity extends EcRemoteLinkedData
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public LearningOpportunity()
	{
		super(null,null);
		context="http://purl.org/ctdl/terms/";
		type="LearningOpportunity";
	}

}