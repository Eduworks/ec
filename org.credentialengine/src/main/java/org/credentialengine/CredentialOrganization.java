package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/CredentialOrganization
 * Organization that plays one or more key roles in the lifecycle of a credential.
 * @author credentialengine.org
 * @class CredentialOrganization
 * @module org.credentialengine
 * @extends Agent
 */
public class CredentialOrganization extends Agent
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public CredentialOrganization()
	{
		context="http://schema.eduworks.com/simpleCtdl";
		type="CredentialOrganization";
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
	 * http://purl.org/ctdl/terms/address
	 * Particulars describing the location of the place.
	 * @property address
	 * @type Place
	 */
	public Place address;

	/**
	 * http://purl.org/ctdl/terms/administrationProcess
	 * Entity describing the process by which a credential, assessment, organization, or aspects of it, are administered.
	 * Processes described include the execution of events and the development of resources in the lifecycle of a credential or organization, such as the process for the proctoring of assessments.
	 * @property administrationProcess
	 * @type ProcessProfile
	 */
	public ProcessProfile administrationProcess;

	/**
	 * http://purl.org/ctdl/terms/agentPurpose
	 * Organization's primary purpose as found on an "about" page of a website.
	 * @property agentPurpose
	 * @type anyURI
	 */
	public String agentPurpose;

	/**
	 * http://purl.org/ctdl/terms/agentPurposeDescription
	 * Short, key phrases describing the primary purpose of an organization as might be derived from the "about" page of it's website.
	 * @property agentPurposeDescription
	 * @type langString
	 */
	public String agentPurposeDescription;

	/**
	 * http://purl.org/ctdl/terms/agentSectorType
	 * Type of sociological, economic, or political subdivision served by an organization; select from an existing enumeration of such types.
	 * @property agentSectorType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject agentSectorType;

	/**
	 * http://purl.org/ctdl/terms/agentType
	 * Type of organization such as educational institution, credentialing organization or quality assurance body; select from an existing enumeration of such types.
	 * @property agentType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject agentType;

	/**
	 * http://purl.org/ctdl/terms/alternateName
	 * Alias for the entity including acronyms, alpha-numeric notations, and other forms of name abbreviations in common use such as PhD, MA, and BA.
	 * @property alternateName
	 * @type langString
	 */
	public String alternateName;

	/**
	 * http://purl.org/ctdl/terms/alternativeIdentifier
	 * Alternative, publicly available and globally unique identifier for an organization issued by an authoritative entity.
	 * The alternative identifier should be used where no identifier is available for the DUNS, FEIN, NAICS or IPEDS ID properties.
	 * @property alternativeIdentifier
	 * @type IdentifierValue
	 */
	public IdentifierValue alternativeIdentifier;

	/**
	 * http://purl.org/ctdl/terms/appealProcess
	 * Formal process for objecting to decisions of the organization regarding credentials, assessments or processes.
	 * @property appealProcess
	 * @type ProcessProfile
	 */
	public ProcessProfile appealProcess;

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
	 * http://purl.org/ctdl/terms/approves
	 * Credential, assessment, learning opportunity, or organization for which this organization pronounces favorable judgment.
	 * @property approves
	 * @type ApprenticeshipCertificate | AssessmentProfile | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | CompetencyFramework | Credential | CredentialOrganization | CredentialPerson | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QACredentialOrganization | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object approves;

	/**
	 * http://purl.org/ctdl/terms/availabilityListing
	 * Listing of online and/or physical locations where a credential can be pursued.
	 * @property availabilityListing
	 * @type anyURI
	 */
	public String availabilityListing;

	/**
	 * http://purl.org/ctdl/terms/complaintProcess
	 * Process for handling complaints about a credential, or aspects of it including related learning opportunities and assessments.
	 * @property complaintProcess
	 * @type ProcessProfile
	 */
	public ProcessProfile complaintProcess;

	/**
	 * http://purl.org/ctdl/terms/credentialingAction
	 * Indicates a past or potential credentialing action in which the resource being described plays an 'object' role.
	 * @property credentialingAction
	 * @type AccreditAction | AdvancedStandingAction | ApproveAction | CredentialingAction | OfferAction | RecognizeAction | RegulateAction | RenewAction | RevokeAction | RightsAction
	 */
	public Object credentialingAction;

	/**
	 * http://purl.org/ctdl/terms/ctid
	 * Globally unique Credential Transparency Identifier (CTID) by which the creator, owner or provider of a credential, learning opportunity competency, or assessment recognizes the entity in transactions with the external environment (e.g., in verifiable claims involving a credential).
	 * The CTID is the equivalent of a version identifier for the resource. Different versions of a resource are considered distinct expressions and each must be assigned its own CTID. Each version of a resource can have only one CTID assigned. However, a single version of a resource may have distinct identifier values for both the ctid property and the credentialId property. In such a case both identifiers will be recognized by the resource creator/owner/provider in transactions with the external environment.
	 * @property ctid
	 * @type string
	 */
	public String ctid;

	/**
	 * http://purl.org/ctdl/terms/department
	 * Department of the organization.
	 * @property department
	 * @type CredentialOrganization | QACredentialOrganization
	 */
	public Object department;

	/**
	 * http://purl.org/ctdl/terms/description
	 * Statement, characterization or account of the entity.
	 * @property description
	 * @type langString
	 */
	public String description;

	/**
	 * http://purl.org/ctdl/terms/developmentProcess
	 * Entity describing the process by which a credential, or aspects of it, were created.
	 * @property developmentProcess
	 * @type ProcessProfile
	 */
	public ProcessProfile developmentProcess;

	/**
	 * http://purl.org/ctdl/terms/duns
	 * Dun & Bradstreet DUNS number for identifying an organization or business person.
	 * @property duns
	 * @type string
	 */
	public String duns;

	/**
	 * http://purl.org/ctdl/terms/email
	 * Email address of the organization or person.
	 * @property email
	 * @type string
	 */
	public String email;

	/**
	 * http://purl.org/ctdl/terms/employee
	 * Person employed for wages or salary by the organization.
	 * @property employee
	 * @type CredentialPerson
	 */
	public CredentialPerson employee;

	/**
	 * http://purl.org/ctdl/terms/fein
	 * Federal Employer Identification Number (FEIN) identifying organizations, persons, states, government agencies, corporations, and companies.
	 * @property fein
	 * @type string
	 */
	public String fein;

	/**
	 * http://purl.org/ctdl/terms/foundingDate
	 * Date the organization was founded.
	 * @property foundingDate
	 * @type string
	 */
	public String foundingDate;

	/**
	 * http://purl.org/ctdl/terms/hasConditionManifest
	 * Entity that describes a set of constraints, prerequisites, entry conditions, or requirements applicable across the organization, sub-organization or sets of credentials or acitivites.
	 * @property hasConditionManifest
	 * @type ConditionManifest
	 */
	public ConditionManifest hasConditionManifest;

	/**
	 * http://purl.org/ctdl/terms/hasCostManifest
	 * Entity that describes a set of cost data applicable across the organization, sub-organization or sets of credentials or acitivites.
	 * @property hasCostManifest
	 * @type CostManifest
	 */
	public CostManifest hasCostManifest;

	/**
	 * http://purl.org/ctdl/terms/hasVerificationService
	 * Entity describing available systems provided by the agent to verify credential holders.
	 * Systems in place to verify credential holders and communicate the current credentialing status of all credential holders to employers and other labor market participants, as well as to education and workforce development funders and regulators.
	 * @property hasVerificationService
	 * @type VerificationServiceProfile
	 */
	public VerificationServiceProfile hasVerificationService;

	/**
	 * http://purl.org/ctdl/terms/image
	 * Image, icon or logo that represents the entity including registered trade or service marks.
	 * @property image
	 * @type anyURI
	 */
	public String image;

	/**
	 * http://purl.org/ctdl/terms/industryType
	 * Type of industry; select from an existing enumeration of such types such as the SIC, NAICS, and ISIC classifications.
	 * @property industryType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject industryType;

	/**
	 * http://purl.org/ctdl/terms/ipedsID
	 * Unique six digit identifier assigned to all U.S. institutions that have submitted data to the Integrated Postsecondary Education Data System (IPEDS).
	 * @property ipedsID
	 * @type string
	 */
	public String ipedsID;

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
	public String keyword;

	/**
	 * http://purl.org/ctdl/terms/leiCode
	 * A 20-digit, alpha-numeric code, based on the ISO 17442 standard, for identifying legal entities participating in financial transactions.
	 * @property leiCode
	 * @type string
	 */
	public String leiCode;

	/**
	 * http://purl.org/ctdl/terms/maintenanceProcess
	 * Entity describing the process by which the credential is maintained including review and updating.
	 * Such maintenance does not include renewal of a credential by an individual holder.
	 * @property maintenanceProcess
	 * @type ProcessProfile
	 */
	public ProcessProfile maintenanceProcess;

	/**
	 * http://purl.org/ctdl/terms/missionAndGoalsStatement
	 * Webpage or online document that defines or explains the mission and goals of the organization.
	 * @property missionAndGoalsStatement
	 * @type anyURI
	 */
	public String missionAndGoalsStatement;

	/**
	 * http://purl.org/ctdl/terms/missionAndGoalsStatementDescription
	 * Textual statement of the mission and goals of the organization.
	 * @property missionAndGoalsStatementDescription
	 * @type langString
	 */
	public String missionAndGoalsStatementDescription;

	/**
	 * http://purl.org/ctdl/terms/naics
	 * North American Industry Classification System (NAICS) code of an organization or business person.
	 * @property naics
	 * @type string
	 */
	public String naics;

	/**
	 * http://purl.org/ctdl/terms/name
	 * Name or title of the entity.
	 * @property name
	 * @type langString
	 */
	public String name;

	/**
	 * http://purl.org/ctdl/terms/offers
	 * Credential, learning opportunity or assessment offered or conferred by the organization or person.
	 * @property offers
	 * @type ApprenticeshipCertificate | AssessmentProfile | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object offers;

	/**
	 * http://purl.org/ctdl/terms/opeID
	 * OPE ID number (U.S. Office of Postsecondary Education Identification), sometimes referred to as the Federal School Code.
	 * Identification number used by the U.S. Department of Education's Office of Postsecondary Education (OPE) to identify schools that have Program Participation Agreements (PPA) so that its students are eligible to participate in Federal Student Financial Assistance (FAFSA) programs under Title IV regulations. This is a 6-digit number followed by a 2-digit suffix used to identify branches, additional locations, and other entities that are part of the eligible institution.
	 * @property opeID
	 * @type string
	 */
	public String opeID;

	/**
	 * http://purl.org/ctdl/terms/owns
	 * Credential, learning opportunity or assessment over which the organization or person claims legal title.
	 * Generally, the value of the property should be one of the subclasses of ceterms:Credential.
	 * @property owns
	 * @type ApprenticeshipCertificate | AssessmentProfile | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object owns;

	/**
	 * http://purl.org/ctdl/terms/parentOrganization
	 * Larger organization exercising authority over the organization being described.
	 * @property parentOrganization
	 * @type CredentialOrganization | QACredentialOrganization
	 */
	public Object parentOrganization;

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
	 * http://purl.org/ctdl/terms/recognizes
	 * Credential, learning opportunity or assessment that the agent recommends, endorses, indicates preference for, or otherwise provides a positive judgment.
	 * @property recognizes
	 * @type ApprenticeshipCertificate | AssessmentProfile | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | CompetencyFramework | Credential | CredentialOrganization | CredentialPerson | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QACredentialOrganization | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object recognizes;

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
	 * http://purl.org/ctdl/terms/renews
	 * Credential type that has its validity extended by the organization or person.
	 * The value of ceterms:renews should be one of the specific subclasses of ceterms:Credential.
	 * @property renews
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object renews;

	/**
	 * http://purl.org/ctdl/terms/reviewProcess
	 * Entity that describes the process by which the credential, or aspects of it, are reviewed.
	 * @property reviewProcess
	 * @type ProcessProfile
	 */
	public ProcessProfile reviewProcess;

	/**
	 * http://purl.org/ctdl/terms/revocationProcess
	 * Entity describing the process by which the credential is revoked.
	 * @property revocationProcess
	 * @type ProcessProfile
	 */
	public ProcessProfile revocationProcess;

	/**
	 * http://purl.org/ctdl/terms/revokes
	 * Credential type that can be invalidated or retracted by the awarding agent.
	 * The value of ceterms:revokes should be one of the specific subclasses of ceterms:Credential.
	 * @property revokes
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object revokes;

	/**
	 * http://purl.org/ctdl/terms/sameAs
	 * Another entity that unambiguously indicates the identity of the entity being described.
	 * Entities that may indicate identity include, but are not limited to, descriptions of entities in open databases such as DBpedia and Wikidata or social media accounts such as FaceBook and LinkedIn.
	 * @property sameAs
	 * @type anyURI
	 */
	public String sameAs;

	/**
	 * http://purl.org/ctdl/terms/serviceType
	 * Type of service offered by the agent being described; select from an existing enumeration of such terms.
	 * @property serviceType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject serviceType;

	/**
	 * http://purl.org/ctdl/terms/socialMedia
	 * Social media access point for an agent or an agent's contact point.
	 * @property socialMedia
	 * @type anyURI
	 */
	public String socialMedia;

	/**
	 * http://purl.org/ctdl/terms/subjectWebpage
	 * The webpage that describes this entity.
	 * The web page being referenced describes the entity. The value of subjectWebpage is an authoritative location for information about the subject but should not assumed to be a persistent identifier of the subject.
	 * @property subjectWebpage
	 * @type anyURI
	 */
	public String subjectWebpage;

	/**
	 * http://purl.org/ctdl/terms/subOrganization
	 * Organization in a subordinate or lower position than a parent organization.
	 * @property subOrganization
	 * @type CredentialOrganization | QACredentialOrganization
	 */
	public Object subOrganization;

}