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
		context="http://schema.eduworks.com/simpleCtdl";
		type="QACredentialOrganization";
	}

	/**
	 * http://purl.org/ctdl/terms/accreditedBy
	 * An agent that accredits the described resource.
	 * @property accreditedBy
	 * @type QACredentialOrganization
	 */
	public QACredentialOrganization accreditedBy;

	/**
	 * http://purl.org/ctdl/terms/accreditedIn
	 * The resource being described is accredited in the jurisdiction being referenced.
	 * @property accreditedIn
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile accreditedIn;

	/**
	 * http://purl.org/ctdl/terms/address
	 * Physical address of the resource.
	 * @property address
	 * @type PostalAddress
	 */
	public PostalAddress address;

	/**
	 * http://purl.org/ctdl/terms/administrationProcess
	 * A profile of the process by which the resource being described, or aspects of it, are administered.
	 * @property administrationProcess
	 * @type ProcessProfile
	 */
	public ProcessProfile administrationProcess;

	/**
	 * http://purl.org/ctdl/terms/agentPurpose
	 * A resource that describes the agent's primary purpose.
	 * @property agentPurpose
	 * @type anyURI
	 */
	public String agentPurpose;

	/**
	 * http://purl.org/ctdl/terms/agentPurposeDescription
	 * A description of the primary purpose of the agent being referenced.
	 * @property agentPurposeDescription
	 * @type Literal
	 */
	public String agentPurposeDescription;

	/**
	 * http://purl.org/ctdl/terms/agentSectorType
	 * The types of sociological, economic, or political subdivision of society served by an agent.
	 * @property agentSectorType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject agentSectorType;

	/**
	 * http://purl.org/ctdl/terms/agentType
	 * The type of the described agent.
	 * @property agentType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject agentType;

	/**
	 * http://purl.org/ctdl/terms/alternativeIdentifier
	 * An alternative, publicly available and globally unique agent identifier issued by an authoritative entity.
	 * @property alternativeIdentifier
	 * @type IdentifierValue
	 */
	public IdentifierValue alternativeIdentifier;

	/**
	 * http://purl.org/ctdl/terms/approvedBy
	 * Pronouncement of a favorable judgment by the agent being referenced.
	 * @property approvedBy
	 * @type CredentialOrganization | CredentialPerson | QACredentialOrganization
	 */
	public Object approvedBy;

	/**
	 * http://purl.org/ctdl/terms/approvedIn
	 * The resource being described is approved in the jurisdiction being referenced.
	 * @property approvedIn
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile approvedIn;

	/**
	 * http://purl.org/ctdl/terms/approves
	 * The agent being described officially accepts or authorizes the resource being referenced.
	 * @property approves
	 * @type ApprenticeshipCertificate | AssessmentProfile | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | CompetencyFramework | Credential | CredentialOrganization | CredentialPerson | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QACredentialOrganization | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object approves;

	/**
	 * http://purl.org/ctdl/terms/availabilityListing
	 * A resource that lists online and/or physical locations for the described resource.
	 * @property availabilityListing
	 * @type anyURI
	 */
	public String availabilityListing;

	/**
	 * http://purl.org/ctdl/terms/contactPoint
	 * A contact point for a person or organization.
	 * @property contactPoint
	 * @type ContactPoint
	 */
	public ContactPoint contactPoint;

	/**
	 * http://purl.org/ctdl/terms/credentialingAction
	 * Indicates a past or potential credentialing action in which the resource being described plays an 'object' role.
	 * @property credentialingAction
	 * @type AccreditAction | AdvancedStandingAction | ApproveAction | CredentialingAction | OfferAction | RecognizeAction | RegulateAction | RenewAction | RevokeAction | RightsAction
	 */
	public Object credentialingAction;

	/**
	 * http://purl.org/ctdl/terms/department
	 * The organization being referenced is a department of the organization being described.
	 * @property department
	 * @type CredentialOrganization | QACredentialOrganization
	 */
	public Object department;

	/**
	 * http://purl.org/ctdl/terms/description
	 * A short description of the resource being described.
	 * @property description
	 * @type Literal
	 */
	public String description;

	/**
	 * http://purl.org/ctdl/terms/developmentProcess
	 * A profile of the process by which the resource being described, or aspects of it, were created.
	 * @property developmentProcess
	 * @type ProcessProfile
	 */
	public ProcessProfile developmentProcess;

	/**
	 * http://purl.org/ctdl/terms/duns
	 * The Dun & Bradstreet DUNS number for identifying an organization or business person.
	 * @property duns
	 * @type Literal
	 */
	public String duns;

	/**
	 * http://purl.org/ctdl/terms/email
	 * Email address of the agent being described.
	 * @property email
	 * @type Literal
	 */
	public String email;

	/**
	 * http://purl.org/ctdl/terms/employee
	 * The referenced person is an employee of the organization being described.
	 * @property employee
	 * @type CredentialPerson
	 */
	public CredentialPerson employee;

	/**
	 * http://purl.org/ctdl/terms/fein
	 * A Federal Employer Identification Number (FEIN) for identifying organizations, persons, states, government agencies, corporations, and companies.
	 * @property fein
	 * @type Literal
	 */
	public String fein;

	/**
	 * http://purl.org/ctdl/terms/foundingDate
	 * The date that this organization was founded.
	 * @property foundingDate
	 * @type Literal
	 */
	public String foundingDate;

	/**
	 * http://purl.org/ctdl/terms/hasConditionManifest
	 * The resource being referenced describes a set of conditions maintained by the agent being described.
	 * @property hasConditionManifest
	 * @type ConditionManifest
	 */
	public ConditionManifest hasConditionManifest;

	/**
	 * http://purl.org/ctdl/terms/hasVerificationService
	 * A profile of available systems provided by the described agent to verify credential holders.
	 * @property hasVerificationService
	 * @type VerificationServiceProfile
	 */
	public VerificationServiceProfile hasVerificationService;

	/**
	 * http://purl.org/ctdl/terms/image
	 * The image or icon that represents the resource.
	 * @property image
	 * @type anyURI
	 */
	public String image;

	/**
	 * http://purl.org/ctdl/terms/industryType
	 * The class identifier for the industry context from an established framework.
	 * @property industryType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject industryType;

	/**
	 * http://purl.org/ctdl/terms/ipedsID
	 * The unique six (6) digit identifier assigned to all institutions that have submitted data to the Integrated Postsecondary Education Data System (IPEDS).
	 * @property ipedsID
	 * @type Literal
	 */
	public String ipedsID;

	/**
	 * http://purl.org/ctdl/terms/jurisdiction
	 * The geo-political region in which the described resource is applicable.
	 * @property jurisdiction
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile jurisdiction;

	/**
	 * http://purl.org/ctdl/terms/keyword
	 * Keywords or key phrases describing aspects of a resource considered useful for its discovery.
	 * @property keyword
	 * @type Literal
	 */
	public String keyword;

	/**
	 * http://purl.org/ctdl/terms/learningOpportunityOffered
	 * A learning opportunity offered by the agent.
	 * @property learningOpportunityOffered
	 * @type LearningOpportunityProfile
	 */
	public LearningOpportunityProfile learningOpportunityOffered;

	/**
	 * http://purl.org/ctdl/terms/maintenanceProcess
	 * The process by which the resource being described is maintained including review and updating.
	 * @property maintenanceProcess
	 * @type ProcessProfile
	 */
	public ProcessProfile maintenanceProcess;

	/**
	 * http://purl.org/ctdl/terms/missionAndGoalsStatement
	 * A resource that defines or explains the mission and goals statement of the resource being described.
	 * @property missionAndGoalsStatement
	 * @type anyURI
	 */
	public String missionAndGoalsStatement;

	/**
	 * http://purl.org/ctdl/terms/missionAndGoalsStatementDescription
	 * The mission and goals statement of the described agent.
	 * @property missionAndGoalsStatementDescription
	 * @type Literal
	 */
	public String missionAndGoalsStatementDescription;

	/**
	 * http://purl.org/ctdl/terms/naics
	 * The North American Industry Classification System (NAICS) code for a particular organization or business person.
	 * @property naics
	 * @type Literal
	 */
	public String naics;

	/**
	 * http://purl.org/ctdl/terms/name
	 * The name of the resource being described.
	 * @property name
	 * @type Literal
	 */
	public String name;

	/**
	 * http://purl.org/ctdl/terms/offers
	 * The agent being described offers or confers the resource being referenced.
	 * @property offers
	 * @type ApprenticeshipCertificate | AssessmentProfile | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object offers;

	/**
	 * http://purl.org/ctdl/terms/opeID
	 * OPE ID number (Office of Postsecondary Education Identification) sometimes referred to as the Federal School Code.
	 * @property opeID
	 * @type Literal
	 */
	public String opeID;

	/**
	 * http://purl.org/ctdl/terms/owns
	 * The described agent has legal title to the referenced resource.
	 * @property owns
	 * @type ApprenticeshipCertificate | AssessmentProfile | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object owns;

	/**
	 * http://purl.org/ctdl/terms/parentOrganization
	 * The larger, parent organization of the organization being described.
	 * @property parentOrganization
	 * @type CredentialOrganization | QACredentialOrganization
	 */
	public Object parentOrganization;

	/**
	 * http://purl.org/ctdl/terms/recognizedBy
	 * The agent being referenced acknowledges the validity of the described resource.
	 * @property recognizedBy
	 * @type CredentialOrganization | CredentialPerson | QACredentialOrganization
	 */
	public Object recognizedBy;

	/**
	 * http://purl.org/ctdl/terms/recognizedIn
	 * The resource being described is publicly recommended, acknowledged, or endorsed in the jurisdiction being referenced.
	 * @property recognizedIn
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile recognizedIn;

	/**
	 * http://purl.org/ctdl/terms/recognizes
	 * The agent being described recommends, endorses, indicates preference for, or otherwise provides positive judgment of a resource.
	 * @property recognizes
	 * @type ApprenticeshipCertificate | AssessmentProfile | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | CompetencyFramework | Credential | CredentialOrganization | CredentialPerson | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QACredentialOrganization | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object recognizes;

	/**
	 * http://purl.org/ctdl/terms/regulatedBy
	 * The agent being referenced enforces the legal requirements of the referenced resource.
	 * @property regulatedBy
	 * @type QACredentialOrganization
	 */
	public QACredentialOrganization regulatedBy;

	/**
	 * http://purl.org/ctdl/terms/regulatedIn
	 * The resource being described is regulated in the jurisdiction being referenced.
	 * @property regulatedIn
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile regulatedIn;

	/**
	 * http://purl.org/ctdl/terms/renews
	 * The described agent handles the renewal of an award of the referenced credential.
	 * @property renews
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object renews;

	/**
	 * http://purl.org/ctdl/terms/revokes
	 * The described agent ends the validity or operation of the resource being referenced based on cause.
	 * @property revokes
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object revokes;

	/**
	 * http://purl.org/ctdl/terms/sameAs
	 * The resource being described is the same as the resource being referenced.
	 * @property sameAs
	 * @type anyURI
	 */
	public String sameAs;

	/**
	 * http://purl.org/ctdl/terms/serviceType
	 * The type of service offered by the agent being described.
	 * @property serviceType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject serviceType;

	/**
	 * http://purl.org/ctdl/terms/socialMedia
	 * A social media resource for the resource being described.
	 * @property socialMedia
	 * @type anyURI
	 */
	public String socialMedia;

	/**
	 * http://purl.org/ctdl/terms/subjectWebpage
	 * The web page where the subject of the resource being described is located.
	 * @property subjectWebpage
	 * @type anyURI
	 */
	public String subjectWebpage;

	/**
	 * http://purl.org/ctdl/terms/subOrganization
	 * The organization being described is the parent of the organization being referenced.
	 * @property subOrganization
	 * @type CredentialOrganization | QACredentialOrganization
	 */
	public Object subOrganization;

	/**
	 * http://purl.org/ctdl/terms/targetContactPoint
	 * Options for contacting the resource being described.
	 * @property targetContactPoint
	 * @type ContactPoint
	 */
	public ContactPoint targetContactPoint;

}