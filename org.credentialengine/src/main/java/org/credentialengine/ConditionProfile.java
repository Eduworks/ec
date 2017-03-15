package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

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
		context="http://purl.org/ctdl/terms/";
		type="ConditionProfile";
	}

	/**
	 * credentialengine.org/assertedBy
	 * The agent providing the information contained in the entity being described.
	 * @property assertedBy
	 * @type CredentialOrganization | CredentialPerson | QACredentialOrganization
	 */
	public Object assertedBy;

	/**
	 * credentialengine.org/audienceLevelType
	 * A point in a progression through an educational or training context, for which the described resource is intended.
	 * @property audienceLevelType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject audienceLevelType;

	/**
	 * credentialengine.org/audienceType
	 * The applicable audience.
	 * @property audienceType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject audienceType;

	/**
	 * credentialengine.org/credentialProfiled
	 * The resource being described is a profile of the credential being referenced.
	 * @property credentialProfiled
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object credentialProfiled;

	/**
	 * credentialengine.org/creditHourType
	 * Units of time corresponding to types of credits.
	 * @property creditHourType
	 * @type Literal
	 */
	public String creditHourType;

	/**
	 * credentialengine.org/creditHourValue
	 * The number of credit hours awarded for completing or attaining the resource being described.
	 * @property creditHourValue
	 * @type float
	 */
	public float creditHourValue;

	/**
	 * credentialengine.org/creditUnitType
	 * The type of credit associated with degree and non-degree learning opportunities.
	 * @property creditUnitType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject creditUnitType;

	/**
	 * credentialengine.org/creditUnitTypeDescription
	 * A more refined, detailed description of credit unit type.
	 * @property creditUnitTypeDescription
	 * @type Literal
	 */
	public String creditUnitTypeDescription;

	/**
	 * credentialengine.org/creditUnitValue
	 * The number of either credit units awarded for college credit or continuing education units for completing or attaining the resource being described.
	 * @property creditUnitValue
	 * @type float
	 */
	public float creditUnitValue;

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
	 * credentialengine.org/estimatedCost
	 * The estimated cost of the described resource.
	 * @property estimatedCost
	 * @type CostProfile
	 */
	public CostProfile estimatedCost;

	/**
	 * credentialengine.org/jurisdiction
	 * The geo-political region in which the described resource is applicable.
	 * @property jurisdiction
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile jurisdiction;

	/**
	 * credentialengine.org/name
	 * The name of the resource being described.
	 * @property name
	 * @type Literal
	 */
	public String name;

	/**
	 * credentialengine.org/targetAssessment
	 * A resource that provides direct, indirect, formative or summative evaluation or estimation of the nature, ability, or quality for the resource being described.
	 * @property targetAssessment
	 * @type Assessment | AssessmentProfile
	 */
	public Object targetAssessment;

	/**
	 * credentialengine.org/targetCompetency
	 * An alignment to a competency assertion in an established framework.
	 * @property targetCompetency
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject targetCompetency;

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
	 * credentialengine.org/weight
	 * An asserted measurement of the weight, degree, percent, or strength of a recommendation, requirement, or comparison.
	 * @property weight
	 * @type float
	 */
	public float weight;

}