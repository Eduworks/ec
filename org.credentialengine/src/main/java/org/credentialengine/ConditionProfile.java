package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/ConditionProfile
 * Entity describing a constraint, prerequisite, entry condition, or requirement.
 * Constraints exist with credentials, learning opportunities, assessments and other entites to which they are subject during their lifecycles.
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
	 * http://purl.org/ctdl/terms/additionalCondition
	 * Additional state of affairs that must exist or be brought about before something else is permitted.
	 * @property additionalCondition
	 * @type ConditionProfile
	 */
	public ConditionProfile additionalCondition;

	/**
	 * http://purl.org/ctdl/terms/alternativeCondition
	 * Constraints, prerequisites, entry conditions, or requirementst in a context where more than one alternative condition or path has been defined and from which any one path fulfills the parent condition.
	 * A set of alternative conditions are not necessarily mutually exclusive paths; for example, a set of alternative concentrations for a degree may allow a person to optionally complete more than one concentration even though only one is required to earn the degree.
	 * @property alternativeCondition
	 * @type ConditionProfile
	 */
	public ConditionProfile alternativeCondition;

	/**
	 * http://purl.org/ctdl/terms/assertedBy
	 * Agent making a statement based on fact or belief.
	 * @property assertedBy
	 * @type CredentialOrganization | CredentialPerson | QACredentialOrganization
	 */
	public Object assertedBy;

	/**
	 * http://purl.org/ctdl/terms/audienceLevelType
	 * Type of level indicating a point in a progression through an educational or training context, for which the credential is intended; select from an existing enumeration of such types.
	 * @property audienceLevelType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject audienceLevelType;

	/**
	 * http://purl.org/ctdl/terms/audienceType
	 * Type of credential seeker for whom the particular condition or cost is applicable; select from an existing enumeration of such types.
	 * @property audienceType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject audienceType;

	/**
	 * http://purl.org/ctdl/terms/commonCosts
	 * Set of costs maintained at an organizational or sub-organizational level, which apply to this credential, assessment, or learning opportunity.
	 * @property commonCosts
	 * @type CostManifest
	 */
	public CostManifest commonCosts;

	/**
	 * http://purl.org/ctdl/terms/condition
	 * Single constraint, prerequisite, entry condition, requirement, or cost.
	 * @property condition
	 * @type langString
	 */
	public langString condition;

	/**
	 * http://purl.org/ctdl/terms/creditHourType
	 * Type of unit of time corresponding to type of credit such as semester hours, quarter hours, clock hours, or hours of participation.
	 * @property creditHourType
	 * @type langString
	 */
	public langString creditHourType;

	/**
	 * http://purl.org/ctdl/terms/creditHourValue
	 * Number of credit hours awarded for successful completion of a learning opportunity or assessment.
	 * @property creditHourValue
	 * @type float
	 */
	public Float creditHourValue;

	/**
	 * http://purl.org/ctdl/terms/creditUnitType
	 * Type of credit associated with both degree and non-degree learning opportunities; select from an existing enumeration of such types.
	 * @property creditUnitType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject creditUnitType;

	/**
	 * http://purl.org/ctdl/terms/creditUnitTypeDescription
	 * Detailed description of credit unit type.
	 * @property creditUnitTypeDescription
	 * @type langString
	 */
	public langString creditUnitTypeDescription;

	/**
	 * http://purl.org/ctdl/terms/creditUnitValue
	 * Number of either credit units awarded for college credit or continuing education units for successful completion of the learning opportunity or assessment.
	 * @property creditUnitValue
	 * @type float
	 */
	public Float creditUnitValue;

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
	 * http://purl.org/ctdl/terms/estimatedCost
	 * Estimated cost of a credential, learning opportunity or assessment.
	 * @property estimatedCost
	 * @type CostProfile
	 */
	public CostProfile estimatedCost;

	/**
	 * http://purl.org/ctdl/terms/experience
	 * Amount and nature of required work, experiential learning or other relevant experience.
	 * @property experience
	 * @type langString
	 */
	public langString experience;

	/**
	 * http://purl.org/ctdl/terms/jurisdiction
	 * Geographic or political region in which the credential is formally applicable or an organization has authority to act.
	 * @property jurisdiction
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile jurisdiction;

	/**
	 * http://purl.org/ctdl/terms/minimumAge
	 * Minimum allowed age at which a person is eligible for the credential.
	 * @property minimumAge
	 * @type integer
	 */
	public integer minimumAge;

	/**
	 * http://purl.org/ctdl/terms/name
	 * Name or title of the entity.
	 * @property name
	 * @type langString
	 */
	public langString name;

	/**
	 * http://purl.org/ctdl/terms/residentOf
	 * Geographic or political region of which a person must be a legal resident or citizen in order to be eligible for the credential.
	 * Residency defines the duration of stay required by national, state, provincial or local laws that entitles a person to the legal protection and benefits provided to the applicable type.
	 * @property residentOf
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile residentOf;

	/**
	 * http://purl.org/ctdl/terms/subjectWebpage
	 * The webpage that describes this entity.
	 * The web page being referenced describes the entity. The value of subjectWebpage is an authoritative location for information about the subject but should not assumed to be a persistent identifier of the subject.
	 * @property subjectWebpage
	 * @type anyURI
	 */
	public String subjectWebpage;

	/**
	 * http://purl.org/ctdl/terms/submissionOf
	 * Artifact to be submitted such as a transcript, portfolio, or an affidavit.
	 * @property submissionOf
	 * @type langString
	 */
	public langString submissionOf;

	/**
	 * http://purl.org/ctdl/terms/targetAssessment
	 * Assessment that provides direct, indirect, formative or summative evaluation or estimation of the nature, ability, or quality for an entity.
	 * @property targetAssessment
	 * @type Assessment | AssessmentProfile
	 */
	public Object targetAssessment;

	/**
	 * http://purl.org/ctdl/terms/targetCompetency
	 * A competency relevant to the condition being described.
	 * @property targetCompetency
	 * @type Competency | CredentialAlignmentObject
	 */
	public Object targetCompetency;

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
	 * http://purl.org/ctdl/terms/targetPathway
	 * Career pathway in which the credential is a potential component.
	 * @property targetPathway
	 * @type CareerPathway
	 */
	public CareerPathway targetPathway;

	/**
	 * http://purl.org/ctdl/terms/targetTask
	 * Task to be completed.
	 * @property targetTask
	 * @type TaskProfile
	 */
	public TaskProfile targetTask;

	/**
	 * http://purl.org/ctdl/terms/weight
	 * Measurement of the weight, degree, percent, or strength of a recommendation, requirement, or comparison.
	 * @property weight
	 * @type float
	 */
	public Float weight;

	/**
	 * http://purl.org/ctdl/terms/yearsOfExperience
	 * Years of relevant experience.
	 * @property yearsOfExperience
	 * @type float
	 */
	public Float yearsOfExperience;

}