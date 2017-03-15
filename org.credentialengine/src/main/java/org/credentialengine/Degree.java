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
		context="http://purl.org/ctdl/terms/";
		type="Degree";
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
	 * credentialengine.org/advancedStandingFrom
	 * The resource being described has time or cost reduced by the resource being referenced.
	 * @property advancedStandingFrom
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object advancedStandingFrom;

	/**
	 * credentialengine.org/alternateName
	 * An alias for the item.
	 * @property alternateName
	 * @type Literal
	 */
	public String alternateName;

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
	 * credentialengine.org/audienceLevelType
	 * A point in a progression through an educational or training context, for which the described resource is intended.
	 * @property audienceLevelType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject audienceLevelType;

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
	 * credentialengine.org/broadAlignment
	 * The resource being referenced covers all of the relevant concepts in the resource being described as well as relevant concepts not found in the resource being described.
	 * @property broadAlignment
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object broadAlignment;

	/**
	 * credentialengine.org/codedNotation
	 * A short set of alpha-numeric symbols that uniquely identifies a resource and supports its discovery.
	 * @property codedNotation
	 * @type Literal
	 */
	public String codedNotation;

	/**
	 * credentialengine.org/copyrightHolder
	 * The party holding the legal copyright to the CreativeWork.
	 * @property copyrightHolder
	 * @type CredentialOrganization | CredentialPerson
	 */
	public Object copyrightHolder;

	/**
	 * credentialengine.org/credentialId
	 * A globally unique identifier by which the creator/owner/provider of a credential recognizes the credential in transactions with the external environment (e.g., in verifiable claims involving the credential).
	 * @property credentialId
	 * @type Literal
	 */
	public String credentialId;

	/**
	 * credentialengine.org/credentialStatusType
	 * The status of the credential.
	 * @property credentialStatusType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject credentialStatusType;

	/**
	 * credentialengine.org/ctid
	 * A globally unique Credential Transparency Identifier (CTID) issued by the Credential Registry Service (CRS) by which the creator/owner/provider of a credential recognizes the credential in transactions with the external environment (e.g., in verifiable claims involving the credential).
	 * @property ctid
	 * @type Literal
	 */
	public String ctid;

	/**
	 * credentialengine.org/dateEffective
	 * The effective date of the described resource content.
	 * @property dateEffective
	 * @type dateTime
	 */
	public String dateEffective;

	/**
	 * credentialengine.org/degreeConcentration
	 * A structured plan of study within a degree major.
	 * @property degreeConcentration
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject degreeConcentration;

	/**
	 * credentialengine.org/degreeMajor
	 * The primary field of study of a degree-seeking student.
	 * @property degreeMajor
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject degreeMajor;

	/**
	 * credentialengine.org/degreeMinor
	 * An optional, secondary field of study of a degree-seeking student.
	 * @property degreeMinor
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject degreeMinor;

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
	 * credentialengine.org/earnings
	 * The resource being referenced is a profile of credential holder earnings data
	 * @property earnings
	 * @type EarningsProfile
	 */
	public EarningsProfile earnings;

	/**
	 * credentialengine.org/employmentOutcome
	 * A profile of jobs obtained with this credential by occupation and industry for a given period and area.
	 * @property employmentOutcome
	 * @type EmploymentOutcomeProfile
	 */
	public EmploymentOutcomeProfile employmentOutcome;

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
	 * credentialengine.org/exactAlignment
	 * The relevant concepts in the resources being compared are coextensive.
	 * @property exactAlignment
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object exactAlignment;

	/**
	 * credentialengine.org/hasPart
	 * Indicates a resource that is (in some sense) a part of the resource being described.
	 * @property hasPart
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object hasPart;

	/**
	 * credentialengine.org/holders
	 * A profile of the number and characteristics of credentialed individuals and their geographic locations.
	 * @property holders
	 * @type HoldersProfile
	 */
	public HoldersProfile holders;

	/**
	 * credentialengine.org/image
	 * The image or icon that represents the resource.
	 * @property image
	 * @type Image
	 */
	public org.schema.ImageObject image;

	/**
	 * credentialengine.org/industryType
	 * The class identifier for the industry context from an established framework.
	 * @property industryType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject industryType;

	/**
	 * credentialengine.org/isAdvancedStandingFor
	 * The resource being described reduces time or cost for the resource being referenced.
	 * @property isAdvancedStandingFor
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object isAdvancedStandingFor;

	/**
	 * credentialengine.org/isPartOf
	 * Indicates a resource that the resource being described is (in some sense) part of.
	 * @property isPartOf
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object isPartOf;

	/**
	 * credentialengine.org/isPreparationFor
	 * The resource being described provides preparation for the resource being referenced.
	 * @property isPreparationFor
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object isPreparationFor;

	/**
	 * credentialengine.org/isRecommendedFor
	 * The resources being described is recommended for the resource being referenced.
	 * @property isRecommendedFor
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object isRecommendedFor;

	/**
	 * credentialengine.org/isRequiredFor
	 * The resource being described is required for the resource being referenced.
	 * @property isRequiredFor
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object isRequiredFor;

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
	 * credentialengine.org/latestVersion
	 * The latest version of the credential being described.
	 * @property latestVersion
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object latestVersion;

	/**
	 * credentialengine.org/maintenanceProcess
	 * The process by which the resource being described is maintained including review and updating.
	 * @property maintenanceProcess
	 * @type ProcessProfile
	 */
	public ProcessProfile maintenanceProcess;

	/**
	 * credentialengine.org/majorAlignment
	 * There is major overlap of relevant concepts between the two resources being compared.
	 * @property majorAlignment
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object majorAlignment;

	/**
	 * credentialengine.org/maximumDuration
	 * The maximum amount of time it will take to complete the described resource.
	 * @property maximumDuration
	 * @type duration
	 */
	public String maximumDuration;

	/**
	 * credentialengine.org/minorAlignment
	 * There is minor overlap of relevant concepts between the two resources being compared.
	 * @property minorAlignment
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object minorAlignment;

	/**
	 * credentialengine.org/name
	 * The name of the resource being described.
	 * @property name
	 * @type Literal
	 */
	public String name;

	/**
	 * credentialengine.org/narrowAlignment
	 * The resource being described covers all of the relevant concepts in the referenced resource as well as relevant concepts not found in the referenced resource.
	 * @property narrowAlignment
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object narrowAlignment;

	/**
	 * credentialengine.org/occupationType
	 * The relevant occupation.
	 * @property occupationType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject occupationType;

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
	 * credentialengine.org/preparationFrom
	 * Preparation for the resource being described is provided by the resource being referenced.
	 * @property preparationFrom
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object preparationFrom;

	/**
	 * credentialengine.org/previousVersion
	 * The version of the credential that immediately precedes the credential being described.
	 * @property previousVersion
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object previousVersion;

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
	 * credentialengine.org/purposeType
	 * The intended type of application of the credential by the holder.
	 * @property purposeType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject purposeType;

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
	 * credentialengine.org/relatedAction
	 * An action related to the described resource.
	 * @property relatedAction
	 * @type AccreditAction | AdvancedStandingAction | ApproveAction | CredentialingAction | OfferAction | RecognizeAction | RegulateAction | RenewAction | RevokeAction | RightsAction
	 */
	public Object relatedAction;

	/**
	 * credentialengine.org/renewal
	 * Conditions necessary to maintenance and renewal of an awarded credential.
	 * @property renewal
	 * @type ConditionProfile
	 */
	public ConditionProfile renewal;

	/**
	 * credentialengine.org/renewedBy
	 * The agent being referenced handles the renewal of awards of the credential being described.
	 * @property renewedBy
	 * @type CredentialOrganization | CredentialPerson | QACredentialOrganization
	 */
	public Object renewedBy;

	/**
	 * credentialengine.org/renewedIn
	 * The resource being described is renewed in the jurisdiction being referenced.
	 * @property renewedIn
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile renewedIn;

	/**
	 * credentialengine.org/requires
	 * The resource being described requires the resource being referenced.
	 * @property requires
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | CredentialAlignmentObject | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object requires;

	/**
	 * credentialengine.org/revocation
	 * Processes and criteria for ending (revoking) the validity or operation of an awarded credential.
	 * @property revocation
	 * @type RevocationProfile
	 */
	public RevocationProfile revocation;

	/**
	 * credentialengine.org/revokedBy
	 * The referenced agent handles the revocation of an awarded credential from the credential holder due to violations.
	 * @property revokedBy
	 * @type CredentialOrganization | CredentialPerson | QACredentialOrganization
	 */
	public Object revokedBy;

	/**
	 * credentialengine.org/revokedIn
	 * The resource being described is revoked in the jurisdiction being referenced.
	 * @property revokedIn
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile revokedIn;

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
	 * credentialengine.org/url
	 * URL of the resource being described.
	 * @property url
	 * @type anyURI
	 */
	public String url;

	/**
	 * credentialengine.org/versionIdentifier
	 * An alphanumeric identifier of a version of the resource being described that is unique within the organizational context.
	 * @property versionIdentifier
	 * @type IdentifierValue
	 */
	public IdentifierValue versionIdentifier;

}