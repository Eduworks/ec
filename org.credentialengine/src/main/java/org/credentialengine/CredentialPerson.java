package org.credentialengine;

/**
 * credentialengine.org/CredentialPerson
 * A person who plays a role as primary agent in a credentialing action.
 *
 * @author credentialengine.org
 * @class CredentialPerson
 * @module org.credentialengine
 * @extends Agent
 */
public class CredentialPerson extends Agent {
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
	 * http://purl.org/ctdl/terms/approves
	 * The agent being described officially accepts or authorizes the resource being referenced.
	 *
	 * @property approves
	 * @type ApprenticeshipCertificate | AssessmentProfile | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | CompetencyFramework | Credential | CredentialOrganization | CredentialPerson | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QACredentialOrganization | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object approves;
	/**
	 * http://purl.org/ctdl/terms/contactPoint
	 * A contact point for a person or organization.
	 *
	 * @property contactPoint
	 * @type ContactPoint
	 */
	public ContactPoint contactPoint;
	/**
	 * http://purl.org/ctdl/terms/description
	 * A short description of the resource being described.
	 *
	 * @property description
	 * @type Literal
	 */
	public String description;
	/**
	 * http://purl.org/ctdl/terms/email
	 * Email address of the agent being described.
	 *
	 * @property email
	 * @type Literal
	 */
	public String email;
	/**
	 * http://purl.org/ctdl/terms/image
	 * The image or icon that represents the resource.
	 *
	 * @property image
	 * @type anyURI
	 */
	public String image;
	/**
	 * http://purl.org/ctdl/terms/keyword
	 * Keywords or key phrases describing aspects of a resource considered useful for its discovery.
	 *
	 * @property keyword
	 * @type Literal
	 */
	public String keyword;
	/**
	 * http://purl.org/ctdl/terms/offers
	 * The agent being described offers or confers the resource being referenced.
	 *
	 * @property offers
	 * @type ApprenticeshipCertificate | AssessmentProfile | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object offers;
	/**
	 * http://purl.org/ctdl/terms/owns
	 * The described agent has legal title to the referenced resource.
	 *
	 * @property owns
	 * @type ApprenticeshipCertificate | AssessmentProfile | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object owns;
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
	 * http://purl.org/ctdl/terms/recognizes
	 * The agent being described recommends, endorses, indicates preference for, or otherwise provides positive judgment of a resource.
	 *
	 * @property recognizes
	 * @type ApprenticeshipCertificate | AssessmentProfile | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | CompetencyFramework | Credential | CredentialOrganization | CredentialPerson | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QACredentialOrganization | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object recognizes;
	/**
	 * http://purl.org/ctdl/terms/renews
	 * The described agent handles the renewal of an award of the referenced credential.
	 *
	 * @property renews
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object renews;
	/**
	 * http://purl.org/ctdl/terms/revokes
	 * The described agent ends the validity or operation of the resource being referenced based on cause.
	 *
	 * @property revokes
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object revokes;
	/**
	 * http://purl.org/ctdl/terms/sameAs
	 * The resource being described is the same as the resource being referenced.
	 *
	 * @property sameAs
	 * @type anyURI
	 */
	public String sameAs;
	/**
	 * http://purl.org/ctdl/terms/serviceType
	 * The type of service offered by the agent being described.
	 *
	 * @property serviceType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject serviceType;
	/**
	 * http://purl.org/ctdl/terms/socialMedia
	 * A social media resource for the resource being described.
	 *
	 * @property socialMedia
	 * @type anyURI
	 */
	public String socialMedia;
	/**
	 * http://purl.org/ctdl/terms/subjectWebpage
	 * The web page where the subject of the resource being described is located.
	 *
	 * @property subjectWebpage
	 * @type anyURI
	 */
	public String subjectWebpage;
	/**
	 * http://purl.org/ctdl/terms/targetContactPoint
	 * Options for contacting the resource being described.
	 *
	 * @property targetContactPoint
	 * @type ContactPoint
	 */
	public ContactPoint targetContactPoint;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public CredentialPerson() {
		context = "http://schema.eduworks.com/simpleCtdl";
		type = "CredentialPerson";
	}

}