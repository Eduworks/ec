package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/CredentialPerson
 * Person who plays a role as primary agent in a credentialing action.
 * The ceterms:CredentialPerson class should be used to describe persons directly engaged as primary agent in credentialing actions such as approving, offering, recognizing, renewing and revoking credentials and should not include persons merely affiliated with, or employed by organizations that perform such actions.
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
		context="http://schema.eduworks.com/simpleCtdl";
		type="CredentialPerson";
	}

	/**
	 * http://purl.org/ctdl/terms/affiliation
	 * Organization to which a person is formally related through work, sudy, or social engagement.
	 * @property affiliation
	 * @type CredentialOrganization | QACredentialOrganization
	 */
	public Object affiliation;

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
	 * http://purl.org/ctdl/terms/description
	 * Statememnt, characterization or account of the entity.
	 * @property description
	 * @type langString
	 */
	public langString description;

	/**
	 * http://purl.org/ctdl/terms/email
	 * Email address of the organization or person.
	 * @property email
	 * @type string
	 */
	public string email;

	/**
	 * http://purl.org/ctdl/terms/familyName
	 * Family name such as the last name of a person in the U.S..
	 * The ceterms:familyName property can be used along with givenName instead of the ceterms:name property.
	 * @property familyName
	 * @type langString
	 */
	public langString familyName;

	/**
	 * http://purl.org/ctdl/terms/givenName
	 * First name of a person.
	 * @property givenName
	 * @type langString
	 */
	public langString givenName;

	/**
	 * http://purl.org/ctdl/terms/honorificSuffix
	 * Honorific suffix preceding a person's name such as M.D. , PhD, or MSCSW.
	 * @property honorificSuffix
	 * @type langString
	 */
	public langString honorificSuffix;

	/**
	 * http://purl.org/ctdl/terms/image
	 * Image, icon or logo that represents the entity including registered trade or service marks.
	 * @property image
	 * @type anyURI
	 */
	public String image;

	/**
	 * http://purl.org/ctdl/terms/keyword
	 * Keyword or key phrase describing relevant aspects of an entity.
	 * @property keyword
	 * @type langString
	 */
	public langString keyword;

	/**
	 * http://purl.org/ctdl/terms/offers
	 * Credential, learning opportunity or assessment offered or conferred by the organization or person.
	 * @property offers
	 * @type ApprenticeshipCertificate | AssessmentProfile | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object offers;

	/**
	 * http://purl.org/ctdl/terms/owns
	 * Credential, learning opportunity or assesment over which the organization or person claims legal title.
	 * Generally, the value of the property should be one of the subclasses of ceterms:Credential.
	 * @property owns
	 * @type ApprenticeshipCertificate | AssessmentProfile | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object owns;

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
	 * http://purl.org/ctdl/terms/renews
	 * Credential type that has its validity extended by the organization or person.
	 * The value of ceterms:renews should be one of the specific subclasses of ceterms:Credential.
	 * @property renews
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object renews;

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
	 * http://purl.org/ctdl/terms/targetContactPoint
	 * Options for contacting the organization or person.
	 * @property targetContactPoint
	 * @type ContactPoint
	 */
	public ContactPoint targetContactPoint;

	/**
	 * http://purl.org/ctdl/terms/worksFor
	 * Person's place of employment.
	 * @property worksFor
	 * @type CredentialOrganization | QACredentialOrganization
	 */
	public Object worksFor;

}