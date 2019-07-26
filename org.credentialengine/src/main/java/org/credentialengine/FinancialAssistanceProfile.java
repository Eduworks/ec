package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/FinancialAssistanceProfile
 * Entity that describes financial assistance that is offered or available.
 * @author credentialengine.org
 * @class FinancialAssistanceProfile
 * @module org.credentialengine
 */
public class FinancialAssistanceProfile extends EcRemoteLinkedData
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public FinancialAssistanceProfile()
	{
		super("http://schema.eduworks.com/simpleCtdl","FinancialAssistanceProfile");
	}

	/**
	 * http://purl.org/ctdl/terms/description
	 * Statement, characterization or account of the entity.
	 * @property description
	 * @type langString
	 */
	public String description;

	/**
	 * http://purl.org/ctdl/terms/name
	 * Name or title of the entity.
	 * @property name
	 * @type langString
	 */
	public String name;

	/**
	 * http://purl.org/ctdl/terms/subjectWebpage
	 * The webpage that describes this entity.
	 * The web page being referenced describes the entity. The value of subjectWebpage is an authoritative location for information about the subject but should not assumed to be a persistent identifier of the subject.
	 * @property subjectWebpage
	 * @type anyURI
	 */
	public String subjectWebpage;

}