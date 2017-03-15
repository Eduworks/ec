package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/LearningOpportunityProfile
 * A resource describing a learning opportunity.
 * @author credentialengine.org
 * @class LearningOpportunityProfile
 * @module org.credentialengine
 * @extends CreativeWork
 */
public class LearningOpportunityProfile extends org.schema.CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public LearningOpportunityProfile()
	{
		context="http://purl.org/ctdl/terms/";
		type="LearningOpportunityProfile";
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
	 * credentialengine.org/hasPart
	 * Indicates a resource that is (in some sense) a part of the resource being described.
	 * @property hasPart
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object hasPart;

	/**
	 * credentialengine.org/instructionalProgramType
	 * The class identifier for instructional program context.
	 * @property instructionalProgramType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject instructionalProgramType;

	/**
	 * credentialengine.org/isPartOf
	 * Indicates a resource that the resource being described is (in some sense) part of.
	 * @property isPartOf
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object isPartOf;

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