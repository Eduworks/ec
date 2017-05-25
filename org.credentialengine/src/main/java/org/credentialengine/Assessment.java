package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/Assessment
 * Direct, indirect, formative and summative evaluation or estimation of the nature, ability, or quality of a resource, performance, or outcome of an action.
 * @author credentialengine.org
 * @class Assessment
 * @module org.credentialengine
 */
public class Assessment extends EcRemoteLinkedData
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Assessment()
	{
		super("http://schema.eduworks.com/simpleCtdl","Assessment");
	}

}