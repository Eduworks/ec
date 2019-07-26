package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/RenewAction
 * Action by an agent renewing an existing credential assertion.
 * Since an instance of ceterms:CredentialingAction is a claim that a certain agent has taken the action being described, creation of such a ceterms:CredentialingAction should be reserved to the agent of that action.
 * @author credentialengine.org
 * @class RenewAction
 * @module org.credentialengine
 * @extends CredentialingAction
 */
public class RenewAction extends CredentialingAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public RenewAction()
	{
		context="http://schema.eduworks.com/simpleCtdl";
		type="RenewAction";
	}

	/**
	 * http://purl.org/ctdl/terms/actingAgent
	 * Organization or person performing an action.
	 * @property actingAgent
	 * @type CredentialOrganization | CredentialPerson | QACredentialOrganization
	 */
	public Object actingAgent;

	/**
	 * http://purl.org/ctdl/terms/actionStatusType
	 * Entity describing the current disposition or standing of an action; select from an existing enumeration of such types.
	 * @property actionStatusType
	 * @type CredentialAlignmentObject
	 */
	public CredentialAlignmentObject actionStatusType;

	/**
	 * http://purl.org/ctdl/terms/description
	 * Statement, characterization or account of the entity.
	 * @property description
	 * @type langString
	 */
	public String description;

	/**
	 * http://purl.org/ctdl/terms/endDate
	 * Date some event or activity ends.
	 * @property endDate
	 * @type date
	 */
	public String endDate;

	/**
	 * http://purl.org/ctdl/terms/evidenceOfAction
	 * Entity that proves that the action occured or that the action continues to be valid.
	 * The evidence verifies the information in the action and is particular to it. It is not a directory of such evidentiary entities or a description of how such verifications might generically be characterized.
	 * @property evidenceOfAction
	 * @type anyURI
	 */
	public String evidenceOfAction;

	/**
	 * http://purl.org/ctdl/terms/instrument
	 * Object that helped the agent perform the action. e.g. John wrote a book with a pen.
	 * A credential or other instrument whose criteria was applied in executing the action.
	 * @property instrument
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object instrument;

	/**
	 * http://purl.org/ctdl/terms/object
	 * Object upon which the action is carried out, whose state is kept intact or changed.
	 * @property object
	 * @type ApprenticeshipCertificate | AssessmentProfile | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Competency | CompetencyFramework | Credential | CredentialOrganization | CredentialPerson | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QACredentialOrganization | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object object;

	/**
	 * http://purl.org/ctdl/terms/participant
	 * Co-agents that participated in the action indirectly.
	 * @property participant
	 * @type CredentialOrganization | CredentialPerson | QACredentialOrganization
	 */
	public Object participant;

	/**
	 * http://purl.org/ctdl/terms/resultingAward
	 * Awarded credential resulting from an action.
	 * An awarded credential is of the type ceterms:CredentialAssertion.
	 * @property resultingAward
	 * @type CredentialAssertion
	 */
	public CredentialAssertion resultingAward;

	/**
	 * http://purl.org/ctdl/terms/startDate
	 * Date the validity or usefulness of the information in this resource begins.
	 * @property startDate
	 * @type date
	 */
	public String startDate;

}