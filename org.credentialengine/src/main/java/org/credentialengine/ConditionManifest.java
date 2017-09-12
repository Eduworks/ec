package org.credentialengine;

import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/ConditionManifest
 * A set of conditions maintained at the organizational and/or sub-organizational level.
 *
 * @author credentialengine.org
 * @class ConditionManifest
 * @module org.credentialengine
 */
public class ConditionManifest extends EcRemoteLinkedData {
	/**
	 * http://purl.org/ctdl/terms/advancedStandingFrom
	 * The resource being described has time or cost reduced by the resource being referenced.
	 *
	 * @property advancedStandingFrom
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object advancedStandingFrom;
	/**
	 * http://purl.org/ctdl/terms/commonConditions
	 * The resource being referenced describes a set of common conditions applicable to the resource being described.
	 *
	 * @property commonConditions
	 * @type ConditionManifest
	 */
	public ConditionManifest commonConditions;
	/**
	 * http://purl.org/ctdl/terms/description
	 * A short description of the resource being described.
	 *
	 * @property description
	 * @type Literal
	 */
	public String description;
	/**
	 * http://purl.org/ctdl/terms/entryCondition
	 * The prerequisites for entry into the resource being described.
	 *
	 * @property entryCondition
	 * @type ConditionProfile
	 */
	public ConditionProfile entryCondition;
	/**
	 * http://purl.org/ctdl/terms/isAdvancedStandingFor
	 * The resource being described reduces time or cost for the resource being referenced.
	 *
	 * @property isAdvancedStandingFor
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object isAdvancedStandingFor;
	/**
	 * http://purl.org/ctdl/terms/isPreparationFor
	 * The resource being described provides preparation for the resource being referenced.
	 *
	 * @property isPreparationFor
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object isPreparationFor;
	/**
	 * http://purl.org/ctdl/terms/isRecommendedFor
	 * The resource being described is recommended for the resource being referenced.
	 *
	 * @property isRecommendedFor
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object isRecommendedFor;
	/**
	 * http://purl.org/ctdl/terms/isRequiredFor
	 * The resource being described is required for the resource being referenced.
	 *
	 * @property isRequiredFor
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object isRequiredFor;
	/**
	 * http://purl.org/ctdl/terms/name
	 * The name of the resource being described.
	 *
	 * @property name
	 * @type Literal
	 */
	public String name;
	/**
	 * http://purl.org/ctdl/terms/preparationFrom
	 * Preparation for the resource being described is provided by the resource being referenced.
	 *
	 * @property preparationFrom
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object preparationFrom;
	/**
	 * http://purl.org/ctdl/terms/recommends
	 * The resource being described recommends the resource being referenced.
	 *
	 * @property recommends
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | CredentialAlignmentObject | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object recommends;
	/**
	 * http://purl.org/ctdl/terms/requires
	 * The resource being described requires the resource being referenced.
	 *
	 * @property requires
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | ConditionProfile | Credential | CredentialAlignmentObject | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object requires;
	/**
	 * http://purl.org/ctdl/terms/subjectWebpage
	 * The web page where the subject of the resource being described is located.
	 *
	 * @property subjectWebpage
	 * @type anyURI
	 */
	public String subjectWebpage;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ConditionManifest() {
		super("http://schema.eduworks.com/simpleCtdl", "ConditionManifest");
	}

}