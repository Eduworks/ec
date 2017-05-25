package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/Degree
 * An academic credential conferred upon completion of a program or course of study, typically over multiple years at postsecondary education institutions.
 * @author credentialengine.org
 * @class Degree
 * @module org.credentialengine
 * @extends Credential
 */
public class Degree extends Credential
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Degree()
	{
		context="http://schema.eduworks.com/simpleCtdl";
		type="Degree";
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
	 * http://purl.org/ctdl/terms/administrationProcess
	 * A profile of the process by which the resource being described, or aspects of it, are administered.
	 * @property administrationProcess
	 * @type ProcessProfile
	 */
	public ProcessProfile administrationProcess;

	/**
	 * http://purl.org/ctdl/terms/advancedStandingFrom
	 * The resource being described has time or cost reduced by the resource being referenced.
	 * @property advancedStandingFrom
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object advancedStandingFrom;

	/**
	 * http://purl.org/ctdl/terms/alternateName
	 * An alias for the item.
	 * @property alternateName
	 * @type Literal
	 */
	public String alternateName;

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
	 * http://purl.org/ctdl/terms/audienceLevelType
	 * A point in a progression through an educational or training context, for which the described resource is intended.
	 * @property audienceLevelType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject audienceLevelType;

	/**
	 * http://purl.org/ctdl/terms/availabilityListing
	 * A resource that lists online and/or physical locations for the described resource.
	 * @property availabilityListing
	 * @type anyURI
	 */
	public String availabilityListing;

	/**
	 * http://purl.org/ctdl/terms/availableAt
	 * The location where the described resource is available.
	 * @property availableAt
	 * @type GeoCoordinates
	 */
	public GeoCoordinates availableAt;

	/**
	 * http://purl.org/ctdl/terms/availableOnlineAt
	 * The online location where the described resource is available.
	 * @property availableOnlineAt
	 * @type anyURI
	 */
	public String availableOnlineAt;

	/**
	 * http://purl.org/ctdl/terms/broadAlignment
	 * The resource being referenced covers all of the relevant concepts in the resource being described as well as relevant concepts not found in the resource being described.
	 * @property broadAlignment
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object broadAlignment;

	/**
	 * http://purl.org/ctdl/terms/codedNotation
	 * A short set of alpha-numeric symbols that uniquely identifies a resource and supports its discovery.
	 * @property codedNotation
	 * @type Literal
	 */
	public String codedNotation;

	/**
	 * http://purl.org/ctdl/terms/commonConditions
	 * The resource being referenced describes a set of common conditions applicable to the resource being described.
	 * @property commonConditions
	 * @type ConditionManifest
	 */
	public ConditionManifest commonConditions;

	/**
	 * http://purl.org/ctdl/terms/copyrightHolder
	 * The party holding the legal copyright to the CreativeWork.
	 * @property copyrightHolder
	 * @type CredentialOrganization | CredentialPerson | QACredentialOrganization
	 */
	public Object copyrightHolder;

	/**
	 * http://purl.org/ctdl/terms/corequisite
	 * The resource being referenced must be pursued concurrently with the resource being described.
	 * @property corequisite
	 * @type ConditionProfile
	 */
	public ConditionProfile corequisite;

	/**
	 * http://purl.org/ctdl/terms/credentialId
	 * A globally unique identifier by which the creator/owner/provider of a credential recognizes the credential in transactions with the external environment (e.g., in verifiable claims involving the credential).
	 * @property credentialId
	 * @type Literal
	 */
	public String credentialId;

	/**
	 * http://purl.org/ctdl/terms/credentialStatusType
	 * The status of the credential.
	 * @property credentialStatusType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject credentialStatusType;

	/**
	 * http://purl.org/ctdl/terms/ctid
	 * A globally unique Credential Transparency Identifier (CTID) issued by the Credential Registry Service (CRS) by which the creator/owner/provider of a credential recognizes the credential in transactions with the external environment (e.g., in verifiable claims involving the credential).
	 * @property ctid
	 * @type Literal
	 */
	public String ctid;

	/**
	 * http://purl.org/ctdl/terms/dateEffective
	 * The effective date of the described resource content.
	 * @property dateEffective
	 * @type date
	 */
	public String dateEffective;

	/**
	 * http://purl.org/ctdl/terms/degreeConcentration
	 * A structured plan of study within a degree major.
	 * @property degreeConcentration
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject degreeConcentration;

	/**
	 * http://purl.org/ctdl/terms/degreeMajor
	 * The primary field of study of a degree-seeking student.
	 * @property degreeMajor
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject degreeMajor;

	/**
	 * http://purl.org/ctdl/terms/degreeMinor
	 * An optional, secondary field of study of a degree-seeking student.
	 * @property degreeMinor
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject degreeMinor;

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
	 * http://purl.org/ctdl/terms/earnings
	 * The resource being referenced is a profile of credential holder earnings data
	 * @property earnings
	 * @type EarningsProfile
	 */
	public EarningsProfile earnings;

	/**
	 * http://purl.org/ctdl/terms/employmentOutcome
	 * A profile of jobs obtained with this credential by occupation and industry for a given period and area.
	 * @property employmentOutcome
	 * @type EmploymentOutcomeProfile
	 */
	public EmploymentOutcomeProfile employmentOutcome;

	/**
	 * http://purl.org/ctdl/terms/estimatedCost
	 * The estimated cost of the described resource.
	 * @property estimatedCost
	 * @type CostProfile
	 */
	public CostProfile estimatedCost;

	/**
	 * http://purl.org/ctdl/terms/estimatedDuration
	 * The estimated time it will take to complete the described activity.
	 * @property estimatedDuration
	 * @type DurationProfile
	 */
	public DurationProfile estimatedDuration;

	/**
	 * http://purl.org/ctdl/terms/exactAlignment
	 * The relevant concepts in the resources being compared are coextensive.
	 * @property exactAlignment
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object exactAlignment;

	/**
	 * http://purl.org/ctdl/terms/financialAssistance
	 * The types of financial assistance for which the resource being described qualifies.
	 * @property financialAssistance
	 * @type FinancialAlignmentObject
	 */
	public FinancialAlignmentObject financialAssistance;

	/**
	 * http://purl.org/ctdl/terms/hasPart
	 * Indicates a resource that is (in some sense) a part of the resource being described.
	 * @property hasPart
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object hasPart;

	/**
	 * http://purl.org/ctdl/terms/holders
	 * A profile of the number and characteristics of credentialed individuals and their geographic locations.
	 * @property holders
	 * @type HoldersProfile
	 */
	public HoldersProfile holders;

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
	 * http://purl.org/ctdl/terms/inLanguage
	 * The primary language used in or by the resource being described.
	 * @property inLanguage
	 * @type language
	 */
	public String inLanguage;

	/**
	 * http://purl.org/ctdl/terms/isAdvancedStandingFor
	 * The resource being described reduces time or cost for the resource being referenced.
	 * @property isAdvancedStandingFor
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object isAdvancedStandingFor;

	/**
	 * http://purl.org/ctdl/terms/isPartOf
	 * Indicates a resource that the resource being described is (in some sense) part of.
	 * @property isPartOf
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object isPartOf;

	/**
	 * http://purl.org/ctdl/terms/isPreparationFor
	 * The resource being described provides preparation for the resource being referenced.
	 * @property isPreparationFor
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object isPreparationFor;

	/**
	 * http://purl.org/ctdl/terms/isRecommendedFor
	 * The resource being described is recommended for the resource being referenced.
	 * @property isRecommendedFor
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object isRecommendedFor;

	/**
	 * http://purl.org/ctdl/terms/isRequiredFor
	 * The resource being described is required for the resource being referenced.
	 * @property isRequiredFor
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object isRequiredFor;

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
	 * http://purl.org/ctdl/terms/latestVersion
	 * The latest version of the credential being described.
	 * @property latestVersion
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object latestVersion;

	/**
	 * http://purl.org/ctdl/terms/maintenanceProcess
	 * The process by which the resource being described is maintained including review and updating.
	 * @property maintenanceProcess
	 * @type ProcessProfile
	 */
	public ProcessProfile maintenanceProcess;

	/**
	 * http://purl.org/ctdl/terms/majorAlignment
	 * There is major overlap of relevant concepts between the two resources being compared.
	 * @property majorAlignment
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object majorAlignment;

	/**
	 * http://purl.org/ctdl/terms/maximumDuration
	 * The maximum amount of time it will take to complete the described resource.
	 * @property maximumDuration
	 * @type duration
	 */
	public String maximumDuration;

	/**
	 * http://purl.org/ctdl/terms/minorAlignment
	 * There is minor overlap of relevant concepts between the two resources being compared.
	 * @property minorAlignment
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object minorAlignment;

	/**
	 * http://purl.org/ctdl/terms/name
	 * The name of the resource being described.
	 * @property name
	 * @type Literal
	 */
	public String name;

	/**
	 * http://purl.org/ctdl/terms/narrowAlignment
	 * The resource being described covers all of the relevant concepts in the referenced resource as well as relevant concepts not found in the referenced resource.
	 * @property narrowAlignment
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object narrowAlignment;

	/**
	 * http://purl.org/ctdl/terms/occupationType
	 * The relevant occupation.
	 * @property occupationType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject occupationType;

	/**
	 * http://purl.org/ctdl/terms/offeredBy
	 * Access to the described resource is offered by the referenced agent.
	 * @property offeredBy
	 * @type CredentialOrganization | CredentialPerson | QACredentialOrganization
	 */
	public Object offeredBy;

	/**
	 * http://purl.org/ctdl/terms/offeredIn
	 * The resource being described is offered in the jurisdiction being referenced.
	 * @property offeredIn
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile offeredIn;

	/**
	 * http://purl.org/ctdl/terms/ownedBy
	 * An agent that has an enforceable claim or title to a resource.
	 * @property ownedBy
	 * @type CredentialOrganization | CredentialPerson | QACredentialOrganization
	 */
	public Object ownedBy;

	/**
	 * http://purl.org/ctdl/terms/preparationFrom
	 * Preparation for the resource being described is provided by the resource being referenced.
	 * @property preparationFrom
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object preparationFrom;

	/**
	 * http://purl.org/ctdl/terms/previousVersion
	 * The version of the credential that immediately precedes the credential being described.
	 * @property previousVersion
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object previousVersion;

	/**
	 * http://purl.org/ctdl/terms/processStandards
	 * A resource describing the criteria, standards, and/or requirements used.
	 * @property processStandards
	 * @type anyURI
	 */
	public String processStandards;

	/**
	 * http://purl.org/ctdl/terms/processStandardsDescription
	 * A description of the criteria, standards, and/or requirements used.
	 * @property processStandardsDescription
	 * @type Literal
	 */
	public String processStandardsDescription;

	/**
	 * http://purl.org/ctdl/terms/purposeType
	 * The intended type of application of the credential by the holder.
	 * @property purposeType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject purposeType;

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
	 * http://purl.org/ctdl/terms/recommends
	 * The resource being described recommends the resource being referenced.
	 * @property recommends
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | CredentialAlignmentObject | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object recommends;

	/**
	 * http://purl.org/ctdl/terms/region
	 * A geo-political area of the described resource.
	 * @property region
	 * @type GeoCoordinates
	 */
	public GeoCoordinates region;

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
	 * http://purl.org/ctdl/terms/relatedAction
	 * An action related to the described resource.
	 * @property relatedAction
	 * @type AccreditAction | AdvancedStandingAction | ApproveAction | CredentialingAction | OfferAction | RecognizeAction | RegulateAction | RenewAction | RevokeAction | RightsAction
	 */
	public Object relatedAction;

	/**
	 * http://purl.org/ctdl/terms/renewal
	 * Conditions necessary to maintenance and renewal of an awarded credential.
	 * @property renewal
	 * @type ConditionProfile
	 */
	public ConditionProfile renewal;

	/**
	 * http://purl.org/ctdl/terms/renewedBy
	 * The agent being referenced handles the renewal of awards of the credential being described.
	 * @property renewedBy
	 * @type CredentialOrganization | CredentialPerson | QACredentialOrganization
	 */
	public Object renewedBy;

	/**
	 * http://purl.org/ctdl/terms/renewedIn
	 * The resource being described is renewed in the jurisdiction being referenced.
	 * @property renewedIn
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile renewedIn;

	/**
	 * http://purl.org/ctdl/terms/requires
	 * The resource being described requires the resource being referenced.
	 * @property requires
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | CredentialAlignmentObject | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object requires;

	/**
	 * http://purl.org/ctdl/terms/revocation
	 * Processes and criteria for ending (revoking) the validity or operation of an awarded credential.
	 * @property revocation
	 * @type RevocationProfile
	 */
	public RevocationProfile revocation;

	/**
	 * http://purl.org/ctdl/terms/revokedBy
	 * The referenced agent handles the revocation of an awarded credential from the credential holder due to violations.
	 * @property revokedBy
	 * @type CredentialOrganization | CredentialPerson | QACredentialOrganization
	 */
	public Object revokedBy;

	/**
	 * http://purl.org/ctdl/terms/revokedIn
	 * The resource being described is revoked in the jurisdiction being referenced.
	 * @property revokedIn
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile revokedIn;

	/**
	 * http://purl.org/ctdl/terms/subject
	 * Words or brief phrases describing topicality of a resource.
	 * @property subject
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject subject;

	/**
	 * http://purl.org/ctdl/terms/subjectWebpage
	 * The web page where the subject of the resource being described is located.
	 * @property subjectWebpage
	 * @type anyURI
	 */
	public String subjectWebpage;

	/**
	 * http://purl.org/ctdl/terms/url
	 * URL of the resource being described.
	 * @property url
	 * @type anyURI
	 */
	public String url;

	/**
	 * http://purl.org/ctdl/terms/versionIdentifier
	 * An alphanumeric identifier of a version of the resource being described that is unique within the organizational context.
	 * @property versionIdentifier
	 * @type IdentifierValue
	 */
	public IdentifierValue versionIdentifier;

}