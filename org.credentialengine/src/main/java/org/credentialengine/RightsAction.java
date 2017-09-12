package org.credentialengine;

/**
 * credentialengine.org/RightsAction
 * An action asserting rights by an authoritative agent to possess, defend, transfer, license, and grant conditional access to a resource.
 *
 * @author credentialengine.org
 * @class RightsAction
 * @module org.credentialengine
 * @extends CredentialingAction
 */
public class RightsAction extends CredentialingAction {
	/**
	 * http://purl.org/ctdl/terms/actingAgent
	 * The direct performer or driver (animate or inanimate) of an action.
	 *
	 * @property actingAgent
	 * @type CredentialOrganization | CredentialPerson | QACredentialOrganization
	 */
	public Object actingAgent;
	/**
	 * http://purl.org/ctdl/terms/actionStatusType
	 * Indicates the current disposition of the action.
	 *
	 * @property actionStatusType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject actionStatusType;
	/**
	 * http://purl.org/ctdl/terms/agent
	 * The direct performer or driver of the action (animate or inanimate).
	 *
	 * @property agent
	 * @type CredentialOrganization | CredentialPerson | QACredentialOrganization
	 */
	public Object agent;
	/**
	 * http://purl.org/ctdl/terms/description
	 * A short description of the resource being described.
	 *
	 * @property description
	 * @type Literal
	 */
	public String description;
	/**
	 * http://purl.org/ctdl/terms/endDate
	 * The end date of something.
	 *
	 * @property endDate
	 * @type date
	 */
	public String endDate;
	/**
	 * http://purl.org/ctdl/terms/evidenceOfAction
	 * A resource that provides evidence of the continuing validity of the action being described.
	 *
	 * @property evidenceOfAction
	 * @type anyURI
	 */
	public String evidenceOfAction;
	/**
	 * http://purl.org/ctdl/terms/instrument
	 * The object that helped the agent perform the action. e.g. John wrote a book with a pen.
	 *
	 * @property instrument
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object instrument;
	/**
	 * http://purl.org/ctdl/terms/object
	 * The object upon [which] the action is carried out, whose state is kept intact or changed.
	 *
	 * @property object
	 * @type ApprenticeshipCertificate | AssessmentProfile | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Competency | CompetencyFramework | Credential | CredentialOrganization | CredentialPerson | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QACredentialOrganization | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object object;
	/**
	 * http://purl.org/ctdl/terms/participant
	 * Other co-agents that participated in the action indirectly.
	 *
	 * @property participant
	 * @type CredentialOrganization | CredentialPerson | QACredentialOrganization
	 */
	public Object participant;
	/**
	 * http://purl.org/ctdl/terms/resultingAward
	 * The result produced in the action.
	 *
	 * @property resultingAward
	 * @type CredentialAssertion
	 */
	public CredentialAssertion resultingAward;
	/**
	 * http://purl.org/ctdl/terms/startDate
	 * The start date of something.
	 *
	 * @property startDate
	 * @type date
	 */
	public String startDate;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public RightsAction() {
		context = "http://schema.eduworks.com/simpleCtdl";
		type = "RightsAction";
	}

}