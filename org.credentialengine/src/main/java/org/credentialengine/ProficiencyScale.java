package org.credentialengine;

import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * ceasn:ProficiencyScale
 * The class of structured profiles describing discrete levels of expertise and performance mastery.
 * Proficiency scales define levels of performance (what a person does) as distinct from knowledge of specific information (what a person knows) and outline tasks a person can manage and the skills necessary to progressively accomplish explicit competencies at increasing levels of complexity. Proficiency scales: (1) assist in making judgments about the kinds of tasks related to a competency that a person is able to perform; and (2) to compare the abilities of different persons with regard to achievement of those competencies at different levels.
 * @author credentialengine.org
 * @class ProficiencyScale
 * @module org.credentialengine
 * @extends EducationalFramework
 */
public class ProficiencyScale extends EcRemoteLinkedData
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ProficiencyScale()
	{
		super("http://schema.eduworks.com/simpleCtdl","ProficiencyScale");
	}

}