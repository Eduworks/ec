package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/AssessmentProfile
 * A resource that describes the key characteristics of an assessment for a credential.
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
		context="http://purl.org/ctdl/terms/";
		type="AssessmentProfile";
	}

	/**
	 * credentialengine.org/accreditedBy
	 * An agent that accredits the described resource.
	 * @property accreditedBy
	 * @type QACredentialOrganization
	 */
	public QACredentialOrganization accreditedBy;

	/**
	 * credentialengine.org/accreditedIn
	 * The resource being described is accredited in the jurisdiction being referenced.
	 * @property accreditedIn
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile accreditedIn;

	/**
	 * credentialengine.org/administrationProcess
	 * A profile of the process by which the resource being described, or aspects of it, are administered.
	 * @property administrationProcess
	 * @type ProcessProfile
	 */
	public ProcessProfile administrationProcess;

	/**
	 * credentialengine.org/approvedBy
	 * Pronouncement of a favorable judgment by the agent being referenced.
	 * @property approvedBy
	 * @type CredentialOrganization | CredentialPerson | QACredentialOrganization
	 */
	public Object approvedBy;

	/**
	 * credentialengine.org/approvedIn
	 * The resource being described is approved in the jurisdiction being referenced.
	 * @property approvedIn
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile approvedIn;

	/**
	 * credentialengine.org/availabilityListing
	 * A resource that lists online and/or physical locations for the described resource.
	 * @property availabilityListing
	 * @type anyURI
	 */
	public String availabilityListing;

	/**
	 * credentialengine.org/availableAt
	 * The location where the described resource is available.
	 * @property availableAt
	 * @type GeoCoordinates
	 */
	public GeoCoordinates availableAt;

	/**
	 * credentialengine.org/availableOnlineAt
	 * The online location where the described resource is available.
	 * @property availableOnlineAt
	 * @type anyURI
	 */
	public String availableOnlineAt;

	/**
	 * credentialengine.org/codedNotation
	 * A short set of alpha-numeric symbols that uniquely identifies a resource and supports its discovery.
	 * @property codedNotation
	 * @type Literal
	 */
	public String codedNotation;

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
	 * credentialengine.org/deliveryType
	 * The means by which the resource being described is delivered to people or interacted with by people.
	 * @property deliveryType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject deliveryType;

	/**
	 * credentialengine.org/deliveryTypeDescription
	 * A more detailed, refined description of delivery type.
	 * @property deliveryTypeDescription
	 * @type Literal
	 */
	public String deliveryTypeDescription;

	/**
	 * credentialengine.org/description
	 * A short description of the resource being described.
	 * @property description
	 * @type Literal
	 */
	public String description;

	/**
	 * credentialengine.org/developmentProcess
	 * A profile of the process by which the resource being described, or aspects of it, were created.
	 * @property developmentProcess
	 * @type ProcessProfile
	 */
	public ProcessProfile developmentProcess;

	/**
	 * credentialengine.org/entryCondition
	 * The prerequisites for entry into the resource being described.
	 * @property entryCondition
	 * @type ConditionProfile
	 */
	public ConditionProfile entryCondition;

	/**
	 * credentialengine.org/estimatedCost
	 * The estimated cost of the described resource.
	 * @property estimatedCost
	 * @type CostProfile
	 */
	public CostProfile estimatedCost;

	/**
	 * credentialengine.org/estimatedDuration
	 * The estimated time it will take to complete the described activity.
	 * @property estimatedDuration
	 * @type DurationProfile
	 */
	public DurationProfile estimatedDuration;

	/**
	 * credentialengine.org/instructionalProgramType
	 * The class identifier for instructional program context.
	 * @property instructionalProgramType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject instructionalProgramType;

	/**
	 * credentialengine.org/jurisdiction
	 * The geo-political region in which the described resource is applicable.
	 * @property jurisdiction
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile jurisdiction;

	/**
	 * credentialengine.org/keyword
	 * Keywords or key phrases describing aspects of a resource considered useful for its discovery.
	 * @property keyword
	 * @type Literal
	 */
	public String keyword;

	/**
	 * credentialengine.org/maintenanceProcess
	 * The process by which the resource being described is maintained including review and updating.
	 * @property maintenanceProcess
	 * @type ProcessProfile
	 */
	public ProcessProfile maintenanceProcess;

	/**
	 * credentialengine.org/name
	 * The name of the resource being described.
	 * @property name
	 * @type Literal
	 */
	public String name;

	/**
	 * credentialengine.org/offeredBy
	 * Access to the described resource is offered by the referenced agent.
	 * @property offeredBy
	 * @type CredentialOrganization | CredentialPerson | QACredentialOrganization
	 */
	public Object offeredBy;

	/**
	 * credentialengine.org/offeredIn
	 * The resource being described is offered in the jurisdiction being referenced.
	 * @property offeredIn
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile offeredIn;

	/**
	 * credentialengine.org/ownedBy
	 * An agent that has an enforceable claim or title to a resource.
	 * @property ownedBy
	 * @type CredentialOrganization | CredentialPerson | QACredentialOrganization
	 */
	public Object ownedBy;

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
	 * credentialengine.org/recognizedBy
	 * The agent being referenced acknowledges the validity of the described resource.
	 * @property recognizedBy
	 * @type CredentialOrganization | CredentialPerson | QACredentialOrganization
	 */
	public Object recognizedBy;

	/**
	 * credentialengine.org/recognizedIn
	 * The resource being described is publicly recommended, acknowledged, or endorsed in the jurisdiction being referenced.
	 * @property recognizedIn
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile recognizedIn;

	/**
	 * credentialengine.org/recommends
	 * The resource being described recommends the resource being referenced.
	 * @property recommends
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | CredentialAlignmentObject | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object recommends;

	/**
	 * credentialengine.org/region
	 * A geo-political area of the described resource.
	 * @property region
	 * @type GeoCoordinates
	 */
	public GeoCoordinates region;

	/**
	 * credentialengine.org/regulatedBy
	 * The agent being referenced enforces the legal requirements of the referenced resource.
	 * @property regulatedBy
	 * @type QACredentialOrganization
	 */
	public QACredentialOrganization regulatedBy;

	/**
	 * credentialengine.org/regulatedIn
	 * The resource being described is regulated in the jurisdiction being referenced.
	 * @property regulatedIn
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile regulatedIn;

	/**
	 * credentialengine.org/requires
	 * The resource being described requires the resource being referenced.
	 * @property requires
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | CredentialAlignmentObject | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object requires;

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
	 * credentialengine.org/subject
	 * Words or brief phrases describing topicality of a resource.
	 * @property subject
	 * @type CredentialAlignmentObject | Literal
	 */
	public Object subject;

	/**
	 * credentialengine.org/subjectWebpage
	 * The web page where the subject of the resource being described is located.
	 * @property subjectWebpage
	 * @type anyURI
	 */
	public String subjectWebpage;

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
	 * credentialengine.org/verificationMethodDescription
	 * Description of the methods used to evaluate the resource validity and reliability.
	 * @property verificationMethodDescription
	 * @type Literal
	 */
	public String verificationMethodDescription;

	/**
	 * credentialengine.org/versionIdentifier
	 * An alphanumeric identifier of a version of the resource being described that is unique within the organizational context.
	 * @property versionIdentifier
	 * @type IdentifierValue
	 */
	public IdentifierValue versionIdentifier;

}