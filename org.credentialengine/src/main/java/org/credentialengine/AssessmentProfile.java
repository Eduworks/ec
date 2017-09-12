package org.credentialengine;

/**
 * credentialengine.org/AssessmentProfile
 * A resource that describes the key characteristics of an assessment for a credential.
 *
 * @author credentialengine.org
 * @class AssessmentProfile
 * @module org.credentialengine
 * @extends CreativeWork
 */
public class AssessmentProfile extends org.schema.CreativeWork {
	/**
	 * http://purl.org/ctdl/terms/accreditedBy
	 * An agent that accredits the described resource.
	 *
	 * @property accreditedBy
	 * @type QACredentialOrganization
	 */
	public QACredentialOrganization accreditedBy;
	/**
	 * http://purl.org/ctdl/terms/accreditedIn
	 * The resource being described is accredited in the jurisdiction being referenced.
	 *
	 * @property accreditedIn
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile accreditedIn;
	/**
	 * http://purl.org/ctdl/terms/administrationProcess
	 * A profile of the process by which the resource being described, or aspects of it, are administered.
	 *
	 * @property administrationProcess
	 * @type ProcessProfile
	 */
	public ProcessProfile administrationProcess;
	/**
	 * http://purl.org/ctdl/terms/approvedBy
	 * Pronouncement of a favorable judgment by the agent being referenced.
	 *
	 * @property approvedBy
	 * @type CredentialOrganization | CredentialPerson | QACredentialOrganization
	 */
	public Object approvedBy;
	/**
	 * http://purl.org/ctdl/terms/approvedIn
	 * The resource being described is approved in the jurisdiction being referenced.
	 *
	 * @property approvedIn
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile approvedIn;
	/**
	 * http://purl.org/ctdl/terms/availabilityListing
	 * A resource that lists online and/or physical locations for the described resource.
	 *
	 * @property availabilityListing
	 * @type anyURI
	 */
	public String availabilityListing;
	/**
	 * http://purl.org/ctdl/terms/availableAt
	 * The location where the described resource is available.
	 *
	 * @property availableAt
	 * @type GeoCoordinates
	 */
	public GeoCoordinates availableAt;
	/**
	 * http://purl.org/ctdl/terms/availableOnlineAt
	 * The online location where the described resource is available.
	 *
	 * @property availableOnlineAt
	 * @type anyURI
	 */
	public String availableOnlineAt;
	/**
	 * http://purl.org/ctdl/terms/codedNotation
	 * A short set of alpha-numeric symbols that uniquely identifies a resource and supports its discovery.
	 *
	 * @property codedNotation
	 * @type Literal
	 */
	public String codedNotation;
	/**
	 * http://purl.org/ctdl/terms/commonConditions
	 * The resource being referenced describes a set of common conditions applicable to the resource being described.
	 *
	 * @property commonConditions
	 * @type ConditionManifest
	 */
	public ConditionManifest commonConditions;
	/**
	 * http://purl.org/ctdl/terms/corequisite
	 * The resource being referenced must be pursued concurrently with the resource being described.
	 *
	 * @property corequisite
	 * @type ConditionProfile
	 */
	public ConditionProfile corequisite;
	/**
	 * http://purl.org/ctdl/terms/creditHourType
	 * Units of time corresponding to types of credits.
	 *
	 * @property creditHourType
	 * @type Literal
	 */
	public String creditHourType;
	/**
	 * http://purl.org/ctdl/terms/creditHourValue
	 * The number of credit hours awarded for completing or attaining the resource being described.
	 *
	 * @property creditHourValue
	 * @type float
	 */
	public Float creditHourValue;
	/**
	 * http://purl.org/ctdl/terms/creditUnitType
	 * The type of credit associated with degree and non-degree learning opportunities.
	 *
	 * @property creditUnitType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject creditUnitType;
	/**
	 * http://purl.org/ctdl/terms/creditUnitTypeDescription
	 * A more refined, detailed description of credit unit type.
	 *
	 * @property creditUnitTypeDescription
	 * @type Literal
	 */
	public String creditUnitTypeDescription;
	/**
	 * http://purl.org/ctdl/terms/creditUnitValue
	 * The number of either credit units awarded for college credit or continuing education units for completing or attaining the resource being described.
	 *
	 * @property creditUnitValue
	 * @type float
	 */
	public Float creditUnitValue;
	/**
	 * http://purl.org/ctdl/terms/dateEffective
	 * The effective date of the described resource content.
	 *
	 * @property dateEffective
	 * @type date
	 */
	public String dateEffective;
	/**
	 * http://purl.org/ctdl/terms/deliveryType
	 * The means by which the resource being described is delivered to people or interacted with by people.
	 *
	 * @property deliveryType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject deliveryType;
	/**
	 * http://purl.org/ctdl/terms/deliveryTypeDescription
	 * A more detailed, refined description of delivery type.
	 *
	 * @property deliveryTypeDescription
	 * @type Literal
	 */
	public String deliveryTypeDescription;
	/**
	 * http://purl.org/ctdl/terms/description
	 * A short description of the resource being described.
	 *
	 * @property description
	 * @type Literal
	 */
	public String description;
	/**
	 * http://purl.org/ctdl/terms/developmentProcess
	 * A profile of the process by which the resource being described, or aspects of it, were created.
	 *
	 * @property developmentProcess
	 * @type ProcessProfile
	 */
	public ProcessProfile developmentProcess;
	/**
	 * http://purl.org/ctdl/terms/entryCondition
	 * The prerequisites for entry into the resource being described.
	 *
	 * @property entryCondition
	 * @type ConditionProfile
	 */
	public ConditionProfile entryCondition;
	/**
	 * http://purl.org/ctdl/terms/estimatedCost
	 * The estimated cost of the described resource.
	 *
	 * @property estimatedCost
	 * @type CostProfile
	 */
	public CostProfile estimatedCost;
	/**
	 * http://purl.org/ctdl/terms/estimatedDuration
	 * The estimated time it will take to complete the described activity.
	 *
	 * @property estimatedDuration
	 * @type DurationProfile
	 */
	public DurationProfile estimatedDuration;
	/**
	 * http://purl.org/ctdl/terms/financialAssistance
	 * The types of financial assistance for which the resource being described qualifies.
	 *
	 * @property financialAssistance
	 * @type FinancialAlignmentObject
	 */
	public FinancialAlignmentObject financialAssistance;
	/**
	 * http://purl.org/ctdl/terms/inLanguage
	 * The primary language used in or by the resource being described.
	 *
	 * @property inLanguage
	 * @type language
	 */
	public String inLanguage;
	/**
	 * http://purl.org/ctdl/terms/instructionalProgramType
	 * The class identifier for instructional program context.
	 *
	 * @property instructionalProgramType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject instructionalProgramType;
	/**
	 * http://purl.org/ctdl/terms/jurisdiction
	 * The geo-political region in which the described resource is applicable.
	 *
	 * @property jurisdiction
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile jurisdiction;
	/**
	 * http://purl.org/ctdl/terms/keyword
	 * Keywords or key phrases describing aspects of a resource considered useful for its discovery.
	 *
	 * @property keyword
	 * @type Literal
	 */
	public String keyword;
	/**
	 * http://purl.org/ctdl/terms/maintenanceProcess
	 * The process by which the resource being described is maintained including review and updating.
	 *
	 * @property maintenanceProcess
	 * @type ProcessProfile
	 */
	public ProcessProfile maintenanceProcess;
	/**
	 * http://purl.org/ctdl/terms/name
	 * The name of the resource being described.
	 *
	 * @property name
	 * @type Literal
	 */
	public String name;
	/**
	 * http://purl.org/ctdl/terms/offeredBy
	 * Access to the described resource is offered by the referenced agent.
	 *
	 * @property offeredBy
	 * @type CredentialOrganization | CredentialPerson | QACredentialOrganization
	 */
	public Object offeredBy;
	/**
	 * http://purl.org/ctdl/terms/offeredIn
	 * The resource being described is offered in the jurisdiction being referenced.
	 *
	 * @property offeredIn
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile offeredIn;
	/**
	 * http://purl.org/ctdl/terms/ownedBy
	 * An agent that has an enforceable claim or title to a resource.
	 *
	 * @property ownedBy
	 * @type CredentialOrganization | CredentialPerson | QACredentialOrganization
	 */
	public Object ownedBy;
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
	 * http://purl.org/ctdl/terms/recognizedBy
	 * The agent being referenced acknowledges the validity of the described resource.
	 *
	 * @property recognizedBy
	 * @type CredentialOrganization | CredentialPerson | QACredentialOrganization
	 */
	public Object recognizedBy;
	/**
	 * http://purl.org/ctdl/terms/recognizedIn
	 * The resource being described is publicly recommended, acknowledged, or endorsed in the jurisdiction being referenced.
	 *
	 * @property recognizedIn
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile recognizedIn;
	/**
	 * http://purl.org/ctdl/terms/recommends
	 * The resource being described recommends the resource being referenced.
	 *
	 * @property recommends
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | CredentialAlignmentObject | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object recommends;
	/**
	 * http://purl.org/ctdl/terms/region
	 * A geo-political area of the described resource.
	 *
	 * @property region
	 * @type GeoCoordinates
	 */
	public GeoCoordinates region;
	/**
	 * http://purl.org/ctdl/terms/regulatedBy
	 * The agent being referenced enforces the legal requirements of the referenced resource.
	 *
	 * @property regulatedBy
	 * @type QACredentialOrganization
	 */
	public QACredentialOrganization regulatedBy;
	/**
	 * http://purl.org/ctdl/terms/regulatedIn
	 * The resource being described is regulated in the jurisdiction being referenced.
	 *
	 * @property regulatedIn
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile regulatedIn;
	/**
	 * http://purl.org/ctdl/terms/requires
	 * The resource being described requires the resource being referenced.
	 *
	 * @property requires
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | CredentialAlignmentObject | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object requires;
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
	 * http://purl.org/ctdl/terms/subject
	 * Words or brief phrases describing topicality of a resource.
	 *
	 * @property subject
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject subject;
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
	 * http://purl.org/ctdl/terms/targetCompetency
	 * An alignment to a competency assertion in an established framework.
	 *
	 * @property targetCompetency
	 * @type Competency | CredentialAlignmentObject
	 */
	public Object targetCompetency;
	/**
	 * http://purl.org/ctdl/terms/verificationMethodDescription
	 * Description of the methods used to evaluate the resource validity and reliability.
	 *
	 * @property verificationMethodDescription
	 * @type Literal
	 */
	public String verificationMethodDescription;
	/**
	 * http://purl.org/ctdl/terms/versionIdentifier
	 * An alphanumeric identifier of a version of the resource being described that is unique within the organizational context.
	 *
	 * @property versionIdentifier
	 * @type IdentifierValue
	 */
	public IdentifierValue versionIdentifier;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public AssessmentProfile() {
		context = "http://schema.eduworks.com/simpleCtdl";
		type = "AssessmentProfile";
	}

}