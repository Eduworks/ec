package org.credentialengine;

/**
 * credentialengine.org/ConditionProfile
 * A resource describing a condition between a credential and other resources to which the credential is subject during its lifecycle including the requirements to attain the credential.
 * @author credentialengine.org
 * @class ConditionProfile
 * @module org.credentialengine
 * @extends CreativeWork
 */
public class ConditionProfile extends org.schema.CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public ConditionProfile()
	{
		context="http://schema.eduworks.com/simpleCtdl";
		type="ConditionProfile";
	}

	/**
	 * http://purl.org/ctdl/terms/assertedBy
	 * The agent providing the information contained in the entity being described.
	 * @property assertedBy
	 * @type CredentialOrganization | CredentialPerson | QACredentialOrganization
	 */
	public Object assertedBy;

	/**
	 * http://purl.org/ctdl/terms/audienceLevelType
	 * A point in a progression through an educational or training context, for which the described resource is intended.
	 * @property audienceLevelType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject audienceLevelType;

	/**
	 * http://purl.org/ctdl/terms/audienceType
	 * The applicable audience.
	 * @property audienceType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject audienceType;

	/**
	 * http://purl.org/ctdl/terms/credentialProfiled
	 * The resource being described is a profile of the credential being referenced.
	 * @property credentialProfiled
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object credentialProfiled;

	/**
	 * http://purl.org/ctdl/terms/creditHourType
	 * Units of time corresponding to types of credits.
	 * @property creditHourType
	 * @type Literal
	 */
	public String creditHourType;

	/**
	 * http://purl.org/ctdl/terms/creditHourValue
	 * The number of credit hours awarded for completing or attaining the resource being described.
	 * @property creditHourValue
	 * @type float
	 */
	public Float creditHourValue;

	/**
	 * http://purl.org/ctdl/terms/creditUnitType
	 * The type of credit associated with degree and non-degree learning opportunities.
	 * @property creditUnitType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject creditUnitType;

	/**
	 * http://purl.org/ctdl/terms/creditUnitTypeDescription
	 * A more refined, detailed description of credit unit type.
	 * @property creditUnitTypeDescription
	 * @type Literal
	 */
	public String creditUnitTypeDescription;

	/**
	 * http://purl.org/ctdl/terms/creditUnitValue
	 * The number of either credit units awarded for college credit or continuing education units for completing or attaining the resource being described.
	 * @property creditUnitValue
	 * @type float
	 */
	public Float creditUnitValue;

	/**
	 * http://purl.org/ctdl/terms/dateEffective
	 * The effective date of the described resource content.
	 * @property dateEffective
	 * @type date
	 */
	public String dateEffective;

	/**
	 * http://purl.org/ctdl/terms/description
	 * A short description of the resource being described.
	 * @property description
	 * @type Literal
	 */
	public String description;

	/**
	 * http://purl.org/ctdl/terms/estimatedCost
	 * The estimated cost of the described resource.
	 * @property estimatedCost
	 * @type CostProfile
	 */
	public CostProfile estimatedCost;

	/**
	 * http://purl.org/ctdl/terms/jurisdiction
	 * The geo-political region in which the described resource is applicable.
	 * @property jurisdiction
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile jurisdiction;

	/**
	 * http://purl.org/ctdl/terms/name
	 * The name of the resource being described.
	 * @property name
	 * @type Literal
	 */
	public String name;

	/**
	 * http://purl.org/ctdl/terms/subjectWebpage
	 * The web page where the subject of the resource being described is located.
	 * @property subjectWebpage
	 * @type anyURI
	 */
	public String subjectWebpage;

	/**
	 * http://purl.org/ctdl/terms/targetAssessment
	 * A resource that provides direct, indirect, formative or summative evaluation or estimation of the nature, ability, or quality for the resource being described.
	 * @property targetAssessment
	 * @type Assessment | AssessmentProfile
	 */
	public Object targetAssessment;

	/**
	 * http://purl.org/ctdl/terms/targetCompetency
	 * An alignment to a competency assertion in an established framework.
	 * @property targetCompetency
	 * @type Competency | CredentialAlignmentObject
	 */
	public Object targetCompetency;

	/**
	 * http://purl.org/ctdl/terms/targetCredential
	 * A credential that is a focus or target of the resource being described.
	 * @property targetCredential
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object targetCredential;

	/**
	 * http://purl.org/ctdl/terms/targetLearningOpportunity
	 * A learning opportunity that is the focus of the resource being described.
	 * @property targetLearningOpportunity
	 * @type LearningOpportunity | LearningOpportunityProfile
	 */
	public Object targetLearningOpportunity;

	/**
	 * http://purl.org/ctdl/terms/weight
	 * An asserted measurement of the weight, degree, percent, or strength of a recommendation, requirement, or comparison.
	 * @property weight
	 * @type float
	 */
	public Float weight;

}