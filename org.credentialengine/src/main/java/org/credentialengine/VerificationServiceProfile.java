package org.credentialengine;

/**
 * credentialengine.org/VerificationServiceProfile
 * A resource describing the means by which someone can verify whether a credential has been attained.
 * @author credentialengine.org
 * @class VerificationServiceProfile
 * @module org.credentialengine
 * @extends Intangible
 */
public class VerificationServiceProfile extends org.schema.Intangible
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public VerificationServiceProfile()
	{
		context="http://schema.eduworks.com/simpleCtdl";
		type="VerificationServiceProfile";
	}

	/**
	 * http://purl.org/ctdl/terms/dateEffective
	 * The effective date of the described resource content.
	 * @property dateEffective
	 * @type date
	 */
	public String dateEffective;

	/**
	 * http://purl.org/ctdl/terms/description
	 * A short description of the resource being described.
	 * @property description
	 * @type Literal
	 */
	public String description;

	/**
	 * http://purl.org/ctdl/terms/estimatedCost
	 * The estimated cost of the described resource.
	 * @property estimatedCost
	 * @type CostProfile
	 */
	public CostProfile estimatedCost;

	/**
	 * http://purl.org/ctdl/terms/jurisdiction
	 * The geo-political region in which the described resource is applicable.
	 * @property jurisdiction
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile jurisdiction;

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
	 * http://purl.org/ctdl/terms/region
	 * A geo-political area of the described resource.
	 * @property region
	 * @type GeoCoordinates
	 */
	public GeoCoordinates region;

	/**
	 * http://purl.org/ctdl/terms/targetCredential
	 * A credential that is a focus or target of the resource being described.
	 * @property targetCredential
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object targetCredential;

	/**
	 * http://purl.org/ctdl/terms/verificationMethodDescription
	 * Description of the methods used to evaluate the resource validity and reliability.
	 * @property verificationMethodDescription
	 * @type Literal
	 */
	public String verificationMethodDescription;

}