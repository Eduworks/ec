package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/QACredentialOrganization
 * A quality assurance organization that plays one or more key roles in the lifecycle of a resource.
 * @author credentialengine.org
 * @class QACredentialOrganization
 * @module org.credentialengine
 * @extends Agent
 */
public class QACredentialOrganization extends Agent
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public QACredentialOrganization()
	{
		context="http://purl.org/ctdl/terms/";
		type="QACredentialOrganization";
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
	 * credentialengine.org/address
	 * Physical address of the resource.
	 * @property address
	 * @type PostalAddress
	 */
	public PostalAddress address;

	/**
	 * credentialengine.org/agentPurpose
	 * A resource that describes the agent's primary purpose.
	 * @property agentPurpose
	 * @type anyURI
	 */
	public String agentPurpose;

	/**
	 * credentialengine.org/agentPurposeDescription
	 * A description of the primary purpose of the agent being referenced.
	 * @property agentPurposeDescription
	 * @type Literal
	 */
	public String agentPurposeDescription;

	/**
	 * credentialengine.org/agentSectorType
	 * The types of sociological, economic, or political subdivision of society served by an agent.
	 * @property agentSectorType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject agentSectorType;

	/**
	 * credentialengine.org/agentType
	 * The type of the described agent.
	 * @property agentType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject agentType;

	/**
	 * credentialengine.org/alternativeIdentifier
	 * An alternative, publicly available and globally unique agent identifier issued by an authoritative entity.
	 * @property alternativeIdentifier
	 * @type IdentifierValue
	 */
	public IdentifierValue alternativeIdentifier;

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
	 * credentialengine.org/approves
	 * The agent being described officially accepts or authorizes the resource being referenced.
	 * @property approves
	 * @type ApprenticeshipCertificate | AssessmentProfile | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | CompetencyFramework | Credential | CredentialOrganization | CredentialPerson | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QACredentialOrganization | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object approves;

	/**
	 * credentialengine.org/availabilityListing
	 * A resource that lists online and/or physical locations for the described resource.
	 * @property availabilityListing
	 * @type anyURI
	 */
	public String availabilityListing;

	/**
	 * credentialengine.org/contactPoint
	 * A contact point for a person or organization.
	 * @property contactPoint
	 * @type ContactPoint | ContactPoint
	 */
	public Object contactPoint;

	/**
	 * credentialengine.org/credentialingAction
	 * Indicates a potential credentialing action, which describes an idealized action in which this thing would play an 'object' role.
	 * @property credentialingAction
	 * @type AccreditAction | AdvancedStandingAction | ApproveAction | CredentialingAction | OfferAction | RecognizeAction | RegulateAction | RenewAction | RevokeAction | RightsAction
	 */
	public Object credentialingAction;

	/**
	 * credentialengine.org/department
	 * The organization being referenced is a department of the organization being described.
	 * @property department
	 * @type CredentialOrganization | QACredentialOrganization
	 */
	public Object department;

	/**
	 * credentialengine.org/description
	 * A short description of the resource being described.
	 * @property description
	 * @type Literal
	 */
	public String description;

	/**
	 * credentialengine.org/duns
	 * The Dun & Bradstreet DUNS number for identifying an organization or business person.
	 * @property duns
	 * @type Literal
	 */
	public String duns;

	/**
	 * credentialengine.org/email
	 * Email address of the agent being described.
	 * @property email
	 * @type Literal | Email
	 */
	public Object email;

	/**
	 * credentialengine.org/employee
	 * The referenced person is an employee of the organization being described.
	 * @property employee
	 * @type CredentialPerson
	 */
	public CredentialPerson employee;

	/**
	 * credentialengine.org/fein
	 * A Federal Employer Identification Number (FEIN) for identifying organizations, persons, states, government agencies, corporations, and companies.
	 * @property fein
	 * @type Literal
	 */
	public String fein;

	/**
	 * credentialengine.org/foundingDate
	 * The date that this organization was founded.
	 * @property foundingDate
	 * @type dateTime
	 */
	public String foundingDate;

	/**
	 * credentialengine.org/hasVerificationService
	 * A profile of available systems provided by the described agent to verify credential holders.
	 * @property hasVerificationService
	 * @type VerificationServiceProfile
	 */
	public VerificationServiceProfile hasVerificationService;

	/**
	 * credentialengine.org/image
	 * The image or icon that represents the resource.
	 * @property image
	 * @type Image
	 */
	public org.schema.ImageObject image;

	/**
	 * credentialengine.org/ipedsID
	 * The unique six (6) digit identifier assigned to all institutions that have submitted data to the Integrated Postsecondary Education Data System (IPEDS).
	 * @property ipedsID
	 * @type Literal
	 */
	public String ipedsID;

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
	 * credentialengine.org/learningOpportunityOffered
	 * A learning opportunity offered by the agent.
	 * @property learningOpportunityOffered
	 * @type LearningOpportunityProfile
	 */
	public LearningOpportunityProfile learningOpportunityOffered;

	/**
	 * credentialengine.org/missionAndGoalsStatement
	 * A resource that defines or explains the mission and goals statement of the resource being described.
	 * @property missionAndGoalsStatement
	 * @type anyURI
	 */
	public String missionAndGoalsStatement;

	/**
	 * credentialengine.org/missionAndGoalsStatementDescription
	 * The mission and goals statement of the described agent.
	 * @property missionAndGoalsStatementDescription
	 * @type Literal
	 */
	public String missionAndGoalsStatementDescription;

	/**
	 * credentialengine.org/naics
	 * The North American Industry Classification System (NAICS) code for a particular organization or business person.
	 * @property naics
	 * @type Literal
	 */
	public String naics;

	/**
	 * credentialengine.org/name
	 * The name of the resource being described.
	 * @property name
	 * @type Literal
	 */
	public String name;

	/**
	 * credentialengine.org/offers
	 * Offers access to or issues the resource being referenced.
	 * @property offers
	 * @type ApprenticeshipCertificate | AssessmentProfile | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object offers;

	/**
	 * credentialengine.org/opeID
	 * OPE ID number (Office of Postsecondary Education Identification) sometimes referred to as the Federal School Code.
	 * @property opeID
	 * @type Literal
	 */
	public String opeID;

	/**
	 * credentialengine.org/owns
	 * The described agent has legal title to the referenced resource.
	 * @property owns
	 * @type ApprenticeshipCertificate | AssessmentProfile | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object owns;

	/**
	 * credentialengine.org/parentOrganization
	 * The larger, parent organization of the organization being described.
	 * @property parentOrganization
	 * @type CredentialOrganization | QACredentialOrganization
	 */
	public Object parentOrganization;

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
	 * credentialengine.org/recognizes
	 * The agent being described recommends, endorses, indicates preference for, or otherwise provides positive judgment of a resource.
	 * @property recognizes
	 * @type ApprenticeshipCertificate | AssessmentProfile | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | CompetencyFramework | Credential | CredentialOrganization | CredentialPerson | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QACredentialOrganization | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object recognizes;

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
	 * credentialengine.org/renews
	 * The described agent handles the renewal of an award of the referenced credential.
	 * @property renews
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object renews;

	/**
	 * credentialengine.org/revokes
	 * The described agent ends the validity or operation of the resource being referenced based on cause.
	 * @property revokes
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object revokes;

	/**
	 * credentialengine.org/sameAs
	 * The resource being described is the same as the resource being referenced.
	 * @property sameAs
	 * @type 	/**
	 * credentialengine.org/serviceType
	 * The type of service offered by the organization.
	 * @property serviceType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject serviceType;

	/**
	 * credentialengine.org/socialMedia
	 * A social media resource for the resource being described.
	 * @property socialMedia
	 * @type anyURI
	 */
	public String socialMedia;

	/**
	 * credentialengine.org/subjectWebpage
	 * The web page where the subject of the resource being described is located.
	 * @property subjectWebpage
	 * @type anyURI
	 */
	public String subjectWebpage;

	/**
	 * credentialengine.org/subOrganization
	 * The organization being described is the parent of the organization being referenced.
	 * @property subOrganization
	 * @type CredentialOrganization | QACredentialOrganization
	 */
	public Object subOrganization;

	/**
	 * credentialengine.org/targetContactPoint
	 * Options for contacting the resource being described.
	 * @property targetContactPoint
	 * @type ContactPoint
	 */
	public ContactPoint targetContactPoint;

}