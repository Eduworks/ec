package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/ProcessProfile
 * Entity describing the type, nature, and other relevant information about a process related to a credential.
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
		context="http://schema.eduworks.com/simpleCtdl";
		type="ProcessProfile";
	}

	/**
	 * http://purl.org/ctdl/terms/dateEffective
	 * Effective date of the content of a credential, assessment or learning opportunity.
	 * @property dateEffective
	 * @type date
	 */
	public String dateEffective;

	/**
	 * http://purl.org/ctdl/terms/description
	 * Statememnt, characterization or account of the entity.
	 * @property description
	 * @type langString
	 */
	public langString description;

	/**
	 * http://purl.org/ctdl/terms/externalInputType
	 * Types of external stakeholders that provide input to an entity's processes or resources; select from an existing enumeration of such types.
	 * @property externalInputType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject externalInputType;

	/**
	 * http://purl.org/ctdl/terms/jurisdiction
	 * Geographic or political region in which the credential is formally applicable or an organization has authority to act.
	 * @property jurisdiction
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile jurisdiction;

	/**
	 * http://purl.org/ctdl/terms/processFrequency
	 * Interval of process occurence.
	 * @property processFrequency
	 * @type langString
	 */
	public langString processFrequency;

	/**
	 * http://purl.org/ctdl/terms/processingAgent
	 * Organization or person performing the process.
	 * @property processingAgent
	 * @type CredentialOrganization | CredentialPerson | QACredentialOrganization
	 */
	public Object processingAgent;

	/**
	 * http://purl.org/ctdl/terms/processMethod
	 * Webpage or online document that describes the process methods.
	 * @property processMethod
	 * @type anyURI
	 */
	public String processMethod;

	/**
	 * http://purl.org/ctdl/terms/processMethodDescription
	 * Textual description of the process methods.
	 * @property processMethodDescription
	 * @type langString
	 */
	public langString processMethodDescription;

	/**
	 * http://purl.org/ctdl/terms/processStandards
	 * Webpage or online document that describes the criteria, standards, and/or requirements used with a process.
	 * @property processStandards
	 * @type anyURI
	 */
	public String processStandards;

	/**
	 * http://purl.org/ctdl/terms/processStandardsDescription
	 * Textual description of the criteria, standards, and/or requirements used with a process.
	 * @property processStandardsDescription
	 * @type langString
	 */
	public langString processStandardsDescription;

	/**
	 * http://purl.org/ctdl/terms/region
	 * Entity that describes the longitude, latitude and other location details of an area.
	 * @property region
	 * @type Place
	 */
	public Place region;

	/**
	 * http://purl.org/ctdl/terms/scoringMethodDescription
	 * Textual description of the method used to score the assessment.
	 * @property scoringMethodDescription
	 * @type langString
	 */
	public langString scoringMethodDescription;

	/**
	 * http://purl.org/ctdl/terms/scoringMethodExample
	 * Webpage or online document providing an example of the method or tool used to score the assessment.
	 * @property scoringMethodExample
	 * @type anyURI
	 */
	public String scoringMethodExample;

	/**
	 * http://purl.org/ctdl/terms/scoringMethodExampleDescription
	 * Textual example of the method or tool used to score the assessment.
	 * @property scoringMethodExampleDescription
	 * @type langString
	 */
	public langString scoringMethodExampleDescription;

	/**
	 * http://purl.org/ctdl/terms/subjectWebpage
	 * The webpage that describes this entity.
	 * The web page being referenced describes the entity. The value of subjectWebpage is an authoritative location for information about the subject but should not assumed to be a persistent identifier of the subject.
	 * @property subjectWebpage
	 * @type anyURI
	 */
	public String subjectWebpage;

	/**
	 * http://purl.org/ctdl/terms/targetAssessment
	 * Assessment that provides direct, indirect, formative or summative evaluation or estimation of the nature, ability, or quality for an entity.
	 * @property targetAssessment
	 * @type Assessment | AssessmentProfile
	 */
	public Object targetAssessment;

	/**
	 * http://purl.org/ctdl/terms/targetCompetencyFramework
	 * Competency framework relevant to the process being described.
	 * @property targetCompetencyFramework
	 * @type CompetencyFramework | CredentialAlignmentObject
	 */
	public Object targetCompetencyFramework;

	/**
	 * http://purl.org/ctdl/terms/targetCredential
	 * Credential that is a focus or target of the condition, process or verification service.
	 * @property targetCredential
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object targetCredential;

	/**
	 * http://purl.org/ctdl/terms/targetLearningOpportunity
	 * Learning opportunity that is the focus of a condition, process or another learning opportunity.
	 * @property targetLearningOpportunity
	 * @type LearningOpportunity | LearningOpportunityProfile
	 */
	public Object targetLearningOpportunity;

	/**
	 * http://purl.org/ctdl/terms/verificationMethodDescription
	 * Textual description of the methods used to evaluate an assessment, learning opportunity, process or verificaiton service for validity or reliability.
	 * @property verificationMethodDescription
	 * @type langString
	 */
	public langString verificationMethodDescription;

}