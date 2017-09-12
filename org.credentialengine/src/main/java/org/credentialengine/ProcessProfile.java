package org.credentialengine;

/**
 * credentialengine.org/ProcessProfile
 * The type, nature, and related information about a process related to a credential.
 *
 * @author credentialengine.org
 * @class ProcessProfile
 * @module org.credentialengine
 * @extends CreativeWork
 */
public class ProcessProfile extends org.schema.CreativeWork {
	/**
	 * http://purl.org/ctdl/terms/dateEffective
	 * The effective date of the described resource content.
	 *
	 * @property dateEffective
	 * @type date
	 */
	public String dateEffective;
	/**
	 * http://purl.org/ctdl/terms/description
	 * A short description of the resource being described.
	 *
	 * @property description
	 * @type Literal
	 */
	public String description;
	/**
	 * http://purl.org/ctdl/terms/jurisdiction
	 * The geo-political region in which the described resource is applicable.
	 *
	 * @property jurisdiction
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile jurisdiction;
	/**
	 * http://purl.org/ctdl/terms/processStandards
	 * A resource describing the criteria, standards, and/or requirements used.
	 *
	 * @property processStandards
	 * @type anyURI
	 */
	public String processStandards;
	/**
	 * http://purl.org/ctdl/terms/processStandardsDescription
	 * A description of the criteria, standards, and/or requirements used.
	 *
	 * @property processStandardsDescription
	 * @type Literal
	 */
	public String processStandardsDescription;
	/**
	 * http://purl.org/ctdl/terms/region
	 * A geo-political area of the described resource.
	 *
	 * @property region
	 * @type GeoCoordinates
	 */
	public GeoCoordinates region;
	/**
	 * http://purl.org/ctdl/terms/scoringMethodDescription
	 * The method used to score the assessment.
	 *
	 * @property scoringMethodDescription
	 * @type Literal
	 */
	public String scoringMethodDescription;
	/**
	 * http://purl.org/ctdl/terms/scoringMethodExample
	 * A resource that is an example of the method or tool used to score the assessment.
	 *
	 * @property scoringMethodExample
	 * @type anyURI
	 */
	public String scoringMethodExample;
	/**
	 * http://purl.org/ctdl/terms/scoringMethodExampleDescription
	 * The text of an example of the method or tool used to score the assessment.
	 *
	 * @property scoringMethodExampleDescription
	 * @type Literal
	 */
	public String scoringMethodExampleDescription;
	/**
	 * http://purl.org/ctdl/terms/subjectWebpage
	 * The web page where the subject of the resource being described is located.
	 *
	 * @property subjectWebpage
	 * @type anyURI
	 */
	public String subjectWebpage;
	/**
	 * http://purl.org/ctdl/terms/targetAssessment
	 * A resource that provides direct, indirect, formative or summative evaluation or estimation of the nature, ability, or quality for the resource being described.
	 *
	 * @property targetAssessment
	 * @type Assessment | AssessmentProfile
	 */
	public Object targetAssessment;
	/**
	 * http://purl.org/ctdl/terms/targetCredential
	 * A credential that is a focus or target of the resource being described.
	 *
	 * @property targetCredential
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object targetCredential;
	/**
	 * http://purl.org/ctdl/terms/targetLearningOpportunity
	 * A learning opportunity that is the focus of the resource being described.
	 *
	 * @property targetLearningOpportunity
	 * @type LearningOpportunity | LearningOpportunityProfile
	 */
	public Object targetLearningOpportunity;
	/**
	 * http://purl.org/ctdl/terms/verificationMethodDescription
	 * Description of the methods used to evaluate the resource validity and reliability.
	 *
	 * @property verificationMethodDescription
	 * @type Literal
	 */
	public String verificationMethodDescription;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ProcessProfile() {
		context = "http://schema.eduworks.com/simpleCtdl";
		type = "ProcessProfile";
	}

}