package org.credentialengine;

/**
 * credentialengine.org/EmploymentOutcomeProfile
 * The employment outcomes and related statistical information for a given credential.
 * @author credentialengine.org
 * @class EmploymentOutcomeProfile
 * @module org.credentialengine
 * @extends CreativeWork
 */
public class EmploymentOutcomeProfile extends org.schema.CreativeWork
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public EmploymentOutcomeProfile()
	{
		context="http://schema.eduworks.com/simpleCtdl";
		type="EmploymentOutcomeProfile";
	}

	/**
	 * http://purl.org/ctdl/terms/credentialProfiled
	 * The resource being described is a profile of the credential being referenced.
	 * @property credentialProfiled
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object credentialProfiled;

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
	 * http://purl.org/ctdl/terms/jurisdiction
	 * The geo-political region in which the described resource is applicable.
	 * @property jurisdiction
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile jurisdiction;

	/**
	 * http://purl.org/ctdl/terms/source
	 * The source of this resource's information.
	 * @property source
	 * @type anyURI
	 */
	public String source;

}