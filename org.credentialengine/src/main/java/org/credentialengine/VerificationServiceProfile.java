package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

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
		context="http://purl.org/ctdl/terms/";
		type="VerificationServiceProfile";
	}

	/**
	 * credentialengine.org/dateEffective
	 * The effective date of the described resource content.
	 * @property dateEffective
	 * @type dateTime
	 */
	public String dateEffective;

	/**
	 * credentialengine.org/description
	 * A short description of the resource being described.
	 * @property description
	 * @type Literal
	 */
	public String description;

	/**
	 * credentialengine.org/estimatedCost
	 * The estimated cost of the described resource.
	 * @property estimatedCost
	 * @type CostProfile
	 */
	public CostProfile estimatedCost;

	/**
	 * credentialengine.org/jurisdiction
	 * The geo-political region in which the described resource is applicable.
	 * @property jurisdiction
	 * @type JurisdictionProfile
	 */
	public JurisdictionProfile jurisdiction;

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
	 * credentialengine.org/region
	 * A geo-political area of the described resource.
	 * @property region
	 * @type GeoCoordinates
	 */
	public GeoCoordinates region;

	/**
	 * credentialengine.org/targetCredential
	 * A credential that is a focus or target of the resource being described.
	 * @property targetCredential
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object targetCredential;

	/**
	 * credentialengine.org/verificationMethodDescription
	 * Description of the methods used to evaluate the resource validity and reliability.
	 * @property verificationMethodDescription
	 * @type Literal
	 */
	public String verificationMethodDescription;

}