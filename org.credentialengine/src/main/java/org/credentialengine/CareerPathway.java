package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/CareerPathway
 * Integrated, sequentially ordered collection of credentials, programs, experiences, and services intended to develop technical, academic, and employability skills in a cluster of occupations that share common skills, knowledge, and interests.
 * @author credentialengine.org
 * @class CareerPathway
 * @module org.credentialengine
 */
public class CareerPathway extends EcRemoteLinkedData
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public CareerPathway()
	{
		super("http://schema.eduworks.com/simpleCtdl","CareerPathway");
	}

}