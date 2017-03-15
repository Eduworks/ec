package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/CredentialPerson
 * An person who plays one or more key roles in the lifecycle of a credential.
 * @author credentialengine.org
 * @class CredentialPerson
 * @module org.credentialengine
 * @extends Agent
 */
public class CredentialPerson extends Agent
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public CredentialPerson()
	{
		context="http://purl.org/ctdl/terms/";
		type="CredentialPerson";
	}

	/**
	 * credentialengine.org/accreditedBy
	 * An agent that accredits the described resource.
	 * @property accreditedBy
	 * @type QACredentialOrganization
	 */
	public QACredentialOrganization accreditedBy;

	/**
	 * credentialengine.org/address
	 * Physical address of the resource.
	 * @property address
	 * @type PostalAddress
	 */
	public PostalAddress address;

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
	 * credentialengine.org/approves
	 * The agent being described officially accepts or authorizes the resource being referenced.
	 * @property approves
	 * @type ApprenticeshipCertificate | AssessmentProfile | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | CompetencyFramework | Credential | CredentialOrganization | CredentialPerson | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QACredentialOrganization | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object approves;

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
	 * credentialengine.org/fein
	 * A Federal Employer Identification Number (FEIN) for identifying organizations, persons, states, government agencies, corporations, and companies.
	 * @property fein
	 * @type Literal
	 */
	public String fein;

	/**
	 * credentialengine.org/hasVerificationService
	 * A profile of available systems provided by the described agent to verify credential holders.
	 * @property hasVerificationService
	 * @type VerificationServiceProfile
	 */
	public VerificationServiceProfile hasVerificationService;

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
	 * credentialengine.org/offers
	 * Offers access to or issues the resource being referenced.
	 * @property offers
	 * @type ApprenticeshipCertificate | AssessmentProfile | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object offers;

	/**
	 * credentialengine.org/owns
	 * The described agent has legal title to the referenced resource.
	 * @property owns
	 * @type ApprenticeshipCertificate | AssessmentProfile | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object owns;

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

}