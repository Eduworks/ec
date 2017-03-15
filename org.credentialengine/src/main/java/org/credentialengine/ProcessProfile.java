package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/ProcessProfile
 * The type, nature, and related information about a process related to a credential.
 * @author credentialengine.org
 * @class ProcessProfile
 * @module org.credentialengine
 * @extends CreativeWork
 */
public class ProcessProfile extends org.schema.CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ProcessProfile()
	{
		context="http://purl.org/ctdl/terms/";
		type="ProcessProfile";
	}

	/**
	 * credentialengine.org/dateEffective
	 * The effective date of the described resource content.
	 * @property dateEffective
	 * @type dateTime
	 */
	public String dateEffective;

	/**
	 * credentialengine.org/description
	 * A short description of the resource being described.
	 * @property description
	 * @type Literal
	 */
	public String description;

	/**
	 * credentialengine.org/jurisdiction
	 * The geo-political region in which the described resource is applicable.
	 * @property jurisdiction
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile jurisdiction;

	/**
	 * credentialengine.org/processStandards
	 * A resource describing the criteria, standards, and/or requirements used.
	 * @property processStandards
	 * @type anyURI
	 */
	public String processStandards;

	/**
	 * credentialengine.org/processStandardsDescription
	 * A description of the criteria, standards, and/or requirements used.
	 * @property processStandardsDescription
	 * @type Literal
	 */
	public String processStandardsDescription;

	/**
	 * credentialengine.org/region
	 * A geo-political area of the described resource.
	 * @property region
	 * @type GeoCoordinates
	 */
	public GeoCoordinates region;

	/**
	 * credentialengine.org/scoringMethodDescription
	 * The method used to score the assessment.
	 * @property scoringMethodDescription
	 * @type Literal
	 */
	public String scoringMethodDescription;

	/**
	 * credentialengine.org/scoringMethodExample
	 * A resource that is an example of the method or tool used to score the assessment.
	 * @property scoringMethodExample
	 * @type anyURI
	 */
	public String scoringMethodExample;

	/**
	 * credentialengine.org/scoringMethodExampleDescription
	 * The text of an example of the method or tool used to score the assessment.
	 * @property scoringMethodExampleDescription
	 * @type Literal
	 */
	public String scoringMethodExampleDescription;

	/**
	 * credentialengine.org/targetAssessment
	 * A resource that provides direct, indirect, formative or summative evaluation or estimation of the nature, ability, or quality for the resource being described.
	 * @property targetAssessment
	 * @type Assessment | AssessmentProfile
	 */
	public Object targetAssessment;

	/**
	 * credentialengine.org/targetCredential
	 * A credential that is a focus or target of the resource being described.
	 * @property targetCredential
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object targetCredential;

	/**
	 * credentialengine.org/targetLearningOpportunity
	 * A learning opportunity that is the focus of the resource being described.
	 * @property targetLearningOpportunity
	 * @type LearningOpportunity | LearningOpportunityProfile
	 */
	public Object targetLearningOpportunity;

	/**
	 * credentialengine.org/verificationMethodDescription
	 * Description of the methods used to evaluate the resource validity and reliability.
	 * @property verificationMethodDescription
	 * @type Literal
	 */
	public String verificationMethodDescription;

}