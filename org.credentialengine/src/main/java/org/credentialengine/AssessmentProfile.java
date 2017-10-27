package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/AssessmentProfile
 * Entity that describes the key characteristics of an assessment for a credential.
 * Characteristics described include, but are not limited to, processes for assessment development, maintenance, selection and evaluation as well as assessment examples.
 * @author credentialengine.org
 * @class AssessmentProfile
 * @module org.credentialengine
 * @extends CreativeWork
 */
public class AssessmentProfile extends org.schema.CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public AssessmentProfile()
	{
		context="http://schema.eduworks.com/simpleCtdl";
		type="AssessmentProfile";
	}

	/**
	 * http://purl.org/ctdl/terms/accreditedBy
	 * Quality assurance organization that provides official authorization to, or approval of, a credential, organization, assessment, or learning opportunity.
	 * @property accreditedBy
	 * @type QACredentialOrganization
	 */
	public QACredentialOrganization accreditedBy;

	/**
	 * http://purl.org/ctdl/terms/accreditedIn
	 * Region or political jurisdiction such as a state, province or locale in which the credential, learning opportunity or assessment is accredited.
	 * @property accreditedIn
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile accreditedIn;

	/**
	 * http://purl.org/ctdl/terms/administrationProcess
	 * Entity describing the process by which a credential, assessment, organization, or aspects of it, are administered.
	 * Processes described include the execution of events and the development of resources in the lifecycle of a credential or organization, such as the process for the proctoring of assessments.
	 * @property administrationProcess
	 * @type ProcessProfile
	 */
	public ProcessProfile administrationProcess;

	/**
	 * http://purl.org/ctdl/terms/advancedStandingFrom
	 * Credential that has its time or cost reduced by another credential, assessment or learning opportunity.
	 * @property advancedStandingFrom
	 * @type ApprenticeshipCertificate | AssessmentProfile | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object advancedStandingFrom;

	/**
	 * http://purl.org/ctdl/terms/approvedBy
	 * Organization that pronounces favorable judgment for this credential, assessment, learning opportunity, or organization.
	 * @property approvedBy
	 * @type CredentialOrganization | CredentialPerson | QACredentialOrganization
	 */
	public Object approvedBy;

	/**
	 * http://purl.org/ctdl/terms/approvedIn
	 * Region or political jurisdiction such as a state, province or locale in which an organization pronounces favorable judgment for this credential, assessment, learning opportunity, or organization.
	 * @property approvedIn
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile approvedIn;

	/**
	 * http://purl.org/ctdl/terms/assesses
	 * Competency evaluated through the assessment.
	 * @property assesses
	 * @type Competency | CredentialAlignmentObject
	 */
	public Object assesses;

	/**
	 * http://purl.org/ctdl/terms/assessmentExample
	 * Example assessment or assessment item.
	 * @property assessmentExample
	 * @type anyURI
	 */
	public String assessmentExample;

	/**
	 * http://purl.org/ctdl/terms/assessmentExampleDescription
	 * Text of an example assessment or assessment item.
	 * @property assessmentExampleDescription
	 * @type langString
	 */
	public langString assessmentExampleDescription;

	/**
	 * http://purl.org/ctdl/terms/assessmentMethodType
	 * Type of method used to conduct an assessment; select from an existing enumeration of such types.
	 * @property assessmentMethodType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject assessmentMethodType;

	/**
	 * http://purl.org/ctdl/terms/assessmentOutput
	 * Description of the assessment artifact, performance or examination.
	 * @property assessmentOutput
	 * @type langString
	 */
	public langString assessmentOutput;

	/**
	 * http://purl.org/ctdl/terms/assessmentUseType
	 * Type of intended use of the assessment; select from an existing enumeration of such types.
	 * @property assessmentUseType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject assessmentUseType;

	/**
	 * http://purl.org/ctdl/terms/availabilityListing
	 * Listing of online and/or physical locations where a credential can be pursued.
	 * @property availabilityListing
	 * @type anyURI
	 */
	public String availabilityListing;

	/**
	 * http://purl.org/ctdl/terms/availableAt
	 * Physical location where the credential, assessment, or learning opportunity can be pursued.
	 * @property availableAt
	 * @type Place
	 */
	public Place availableAt;

	/**
	 * http://purl.org/ctdl/terms/availableOnlineAt
	 * Online location where the credential, assessment, or learning opportunity can be pursued.
	 * @property availableOnlineAt
	 * @type anyURI
	 */
	public String availableOnlineAt;

	/**
	 * http://purl.org/ctdl/terms/codedNotation
	 * Set of alpha-numeric symbols that uniquely identifies an item and supports its discovery and use.
	 * Examples include the alpha-numeric code "CCSS.MATH.CONTENT.HSA.CED.A.2" identifying a node in the U.S. Common Core State Standards on creating equations in algebra, or, the code "8021" in the U.S. Standard Industrial Classification (SIC) for identifying the occupational context for "Offices and Clinics of Dentists".
	 * @property codedNotation
	 * @type string
	 */
	public string codedNotation;

	/**
	 * http://purl.org/ctdl/terms/commonConditions
	 * Set constraints, prerequisites, entry conditions, or requirements that are shared across an organization, organizational subdivision, set of credentials, or category of entities and activities.
	 * @property commonConditions
	 * @type ConditionManifest
	 */
	public ConditionManifest commonConditions;

	/**
	 * http://purl.org/ctdl/terms/commonCosts
	 * Set of costs maintained at an organizational or sub-organizational level, which apply to this credential, assessment, or learning opportunity.
	 * @property commonCosts
	 * @type CostManifest
	 */
	public CostManifest commonCosts;

	/**
	 * http://purl.org/ctdl/terms/corequisite
	 * Credentials that must be pursued concurrently.
	 * Includes dual (double) degrees that cannot be earned independently of each other.
	 * @property corequisite
	 * @type ConditionProfile
	 */
	public ConditionProfile corequisite;

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
	 * http://purl.org/ctdl/terms/ctid
	 * Globally unique Credential Transparency Identifier (CTID) by which the creator, owner or provider of a credential, learning opportunity competency, or assessment recognizes the entity in transactions with the external environment (e.g., in verifiable claims involving a credential).
	 * The CTID is the equivalent of a version identifier for the resource. Different versions of a resource are considered distinct expressions and each must be assigned its own CTID. Each version of a resource can have only one CTID assigned. However, a single version of a resource may have distinct identifier values for both the ctid property and the credentialId property. In such a case both identifiers will be recognized by the resource creator/owner/provider in transactions with the external environment.
	 * @property ctid
	 * @type string
	 */
	public string ctid;

	/**
	 * http://purl.org/ctdl/terms/dateEffective
	 * Effective date of the content of a credential, assessment or learning opportunity.
	 * @property dateEffective
	 * @type date
	 */
	public String dateEffective;

	/**
	 * http://purl.org/ctdl/terms/deliveryType
	 * Type of means by which a learning opportunity or assessment is delivered to credential seekers and by which they interact; select from an existing enumeration of such types.
	 * @property deliveryType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject deliveryType;

	/**
	 * http://purl.org/ctdl/terms/deliveryTypeDescription
	 * Detailed description of the delivery type of an assessment or learning opportunity.
	 * @property deliveryTypeDescription
	 * @type langString
	 */
	public langString deliveryTypeDescription;

	/**
	 * http://purl.org/ctdl/terms/description
	 * Statememnt, characterization or account of the entity.
	 * @property description
	 * @type langString
	 */
	public langString description;

	/**
	 * http://purl.org/ctdl/terms/developmentProcess
	 * Entity describing the process by which a credential, or aspects of it, were created.
	 * @property developmentProcess
	 * @type ProcessProfile
	 */
	public ProcessProfile developmentProcess;

	/**
	 * http://purl.org/ctdl/terms/entryCondition
	 * Prerequisites for entry into a credentialing program, a learning opportunity or an assessment including transcripts, records of previous experience, and lower-level learning opportunities.
	 * @property entryCondition
	 * @type ConditionProfile
	 */
	public ConditionProfile entryCondition;

	/**
	 * http://purl.org/ctdl/terms/estimatedCost
	 * Estimated cost of a credential, learning opportunity or assessment.
	 * @property estimatedCost
	 * @type CostProfile
	 */
	public CostProfile estimatedCost;

	/**
	 * http://purl.org/ctdl/terms/estimatedDuration
	 * Estimated time it will take to complete a credential, learning opportunity or assessment.
	 * @property estimatedDuration
	 * @type DurationProfile
	 */
	public DurationProfile estimatedDuration;

	/**
	 * http://purl.org/ctdl/terms/externalResearch
	 * Research that supports or validates one or more aspects of the entity.
	 * @property externalResearch
	 * @type anyURI
	 */
	public String externalResearch;

	/**
	 * http://purl.org/ctdl/terms/financialAssistance
	 * Entity that describes financial assistance for which this credential, assessment, or learning opportunity qualifies.
	 * Whether the financial aid in question is associated with a credential, an assessment, or a learning opportunity is dependent on context.
	 * @property financialAssistance
	 * @type FinancialAlignmentObject
	 */
	public FinancialAlignmentObject financialAssistance;

	/**
	 * http://purl.org/ctdl/terms/hasGroupEvaluation
	 * Whether or not the assessment activity is scored as a group.
	 * @property hasGroupEvaluation
	 * @type boolean
	 */
	public boolean hasGroupEvaluation;

	/**
	 * http://purl.org/ctdl/terms/hasGroupParticipation
	 * Whether or not two or more participants are required to complete the assessment activity.
	 * @property hasGroupParticipation
	 * @type boolean
	 */
	public boolean hasGroupParticipation;

	/**
	 * http://purl.org/ctdl/terms/inLanguage
	 * Primary language of the credential, learning opportunity or assessment.
	 * This is the primary language the entity, even if the it makes use of other languages. For example, a course that teaches Spanish to English-speaking students may primarily be in English, because that is the language used to convey the material.
	 * @property inLanguage
	 * @type language
	 */
	public String inLanguage;

	/**
	 * http://purl.org/ctdl/terms/instructionalProgramType
	 * Type of instructional program; select from an existing enumeration of such types.
	 * @property instructionalProgramType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject instructionalProgramType;

	/**
	 * http://purl.org/ctdl/terms/isAdvancedStandingFor
	 * This credential, assessment, or learning opportunity reduces the time or cost required to earn or complete the referenced credential, assessment, or learning opportunity.
	 * @property isAdvancedStandingFor
	 * @type ApprenticeshipCertificate | AssessmentProfile | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object isAdvancedStandingFor;

	/**
	 * http://purl.org/ctdl/terms/isPreparationFor
	 * This credential, assessment, or learning opportunity provides preparation for the credential, assessment, or learning opportunity being referenced.
	 * @property isPreparationFor
	 * @type ApprenticeshipCertificate | AssessmentProfile | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object isPreparationFor;

	/**
	 * http://purl.org/ctdl/terms/isProctored
	 * Whether or not the assessment is supervised or monitored by an agent.
	 * Such supervision or proctoring includes: (1)  guaranteeing of the identities of the examinees; (2) the conditions of the examination including instructions, time, materials, equipment and completion, and (3) completed without unauthorized assistance.
	 * @property isProctored
	 * @type boolean
	 */
	public boolean isProctored;

	/**
	 * http://purl.org/ctdl/terms/isRecommendedFor
	 * It is recommended to earn or complete this credential, assessment, or learning opportunity before attempting to earn or complete the referenced credential, assessment, or learning opportunity.
	 * @property isRecommendedFor
	 * @type ApprenticeshipCertificate | AssessmentProfile | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object isRecommendedFor;

	/**
	 * http://purl.org/ctdl/terms/isRequiredFor
	 * This credential, assessment, or learning opportunity must be earned or completed prior to attempting to earn or complete the referenced credential, assessment, or learning opportunity.
	 * @property isRequiredFor
	 * @type ApprenticeshipCertificate | AssessmentProfile | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object isRequiredFor;

	/**
	 * http://purl.org/ctdl/terms/jurisdiction
	 * Geographic or political region in which the credential is formally applicable or an organization has authority to act.
	 * @property jurisdiction
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile jurisdiction;

	/**
	 * http://purl.org/ctdl/terms/keyword
	 * Keyword or key phrase describing relevant aspects of an entity.
	 * @property keyword
	 * @type langString
	 */
	public langString keyword;

	/**
	 * http://purl.org/ctdl/terms/maintenanceProcess
	 * Entity describing the process by which the credential is maintained including review and updating.
	 * Such maintenance does not include renewal of a credential by an individual holder.
	 * @property maintenanceProcess
	 * @type ProcessProfile
	 */
	public ProcessProfile maintenanceProcess;

	/**
	 * http://purl.org/ctdl/terms/name
	 * Name or title of the entity.
	 * @property name
	 * @type langString
	 */
	public langString name;

	/**
	 * http://purl.org/ctdl/terms/offeredBy
	 * Agent that offers the credential, learning opportunity or assessment.
	 * @property offeredBy
	 * @type CredentialOrganization | CredentialPerson | QACredentialOrganization
	 */
	public Object offeredBy;

	/**
	 * http://purl.org/ctdl/terms/offeredIn
	 * Region or political jurisdiction such as a state, province or locale where the credential, learning resource or assessment is offered.
	 * @property offeredIn
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile offeredIn;

	/**
	 * http://purl.org/ctdl/terms/ownedBy
	 * Organization or person with an enforceable claim or legal title to the credential, assessment or learning opportunity.
	 * Agent includes credentialing organizations, quality assurance organizations and persons. It does not not include credential holders.
	 * @property ownedBy
	 * @type CredentialOrganization | CredentialPerson | QACredentialOrganization
	 */
	public Object ownedBy;

	/**
	 * http://purl.org/ctdl/terms/preparationFrom
	 * Another credential, learning opportunity or assessment that provides preparation for this credential, learning opportunity or assessment.
	 * @property preparationFrom
	 * @type ApprenticeshipCertificate | AssessmentProfile | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object preparationFrom;

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
	 * http://purl.org/ctdl/terms/recognizedBy
	 * Agent that acknowledges the validity of the credential, learning opportunity of assessment.
	 * @property recognizedBy
	 * @type CredentialOrganization | CredentialPerson | QACredentialOrganization
	 */
	public Object recognizedBy;

	/**
	 * http://purl.org/ctdl/terms/recognizedIn
	 * Region or political jurisdiction such as a state, province or locale in which the credential, learning resource, or assessment has been publicly recommended, acknowledged or endorsed.
	 * @property recognizedIn
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile recognizedIn;

	/**
	 * http://purl.org/ctdl/terms/recommends
	 * Recommended credential, learning opportunity or assessment.
	 * @property recommends
	 * @type ApprenticeshipCertificate | AssessmentProfile | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Competency | ConditionProfile | Credential | CredentialAlignmentObject | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object recommends;

	/**
	 * http://purl.org/ctdl/terms/region
	 * Entity that describes the longitude, latitude and other location details of an area.
	 * @property region
	 * @type Place
	 */
	public Place region;

	/**
	 * http://purl.org/ctdl/terms/regulatedBy
	 * Quality assurance organization that enforces the legal requirements of the credential, learning resource or assessment.
	 * @property regulatedBy
	 * @type QACredentialOrganization
	 */
	public QACredentialOrganization regulatedBy;

	/**
	 * http://purl.org/ctdl/terms/regulatedIn
	 * Region or political jurisdiction such as a state, province or locale in which the credential, learning opportunity or resource is regulated.
	 * @property regulatedIn
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile regulatedIn;

	/**
	 * http://purl.org/ctdl/terms/requires
	 * Requirement or set of requirements for this credential, learning opportunity, or assessment.
	 * @property requires
	 * @type ApprenticeshipCertificate | AssessmentProfile | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Competency | ConditionProfile | Credential | CredentialAlignmentObject | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object requires;

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
	 * http://purl.org/ctdl/terms/scoringMethodType
	 * Type of method used to score the assessment; select from an existing enumeration of such types.
	 * @property scoringMethodType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject scoringMethodType;

	/**
	 * http://purl.org/ctdl/terms/subject
	 * Words or brief phrases describing the topicality of the entity; select subject terms from an existing enumeration of such terms.
	 * @property subject
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject subject;

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
	 * http://purl.org/ctdl/terms/verificationMethodDescription
	 * Textual description of the methods used to evaluate an assessment, learning opportunity, process or verificaiton service for validity or reliability.
	 * @property verificationMethodDescription
	 * @type langString
	 */
	public langString verificationMethodDescription;

	/**
	 * http://purl.org/ctdl/terms/versionIdentifier
	 * Alphanumeric identifier of the version of the credential that is unique within the organizational context of its owner.
	 * The credential version captured here is any local identifier used by the credential owner to identify the version of the credential in the its local system.
	 * @property versionIdentifier
	 * @type IdentifierValue
	 */
	public IdentifierValue versionIdentifier;

}