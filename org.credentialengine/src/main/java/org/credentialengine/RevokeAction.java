package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/RevokeAction
 * An action by an authoritative agent removing a credential assertion from the credential holder based on violations.
 * @author credentialengine.org
 * @class RevokeAction
 * @module org.credentialengine
 * @extends CredentialingAction
 */
public class RevokeAction extends CredentialingAction
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public RevokeAction()
	{
		context="http://purl.org/ctdl/terms/";
		type="RevokeAction";
	}

	/**
	 * credentialengine.org/actingAgent
	 * The direct performer or driver (animate or inanimate) of an action.
	 * @property actingAgent
	 * @type CredentialOrganization | CredentialPerson | QACredentialOrganization
	 */
	public Object actingAgent;

	/**
	 * credentialengine.org/actionStatusType
	 * Indicates the current disposition of the action.
	 * @property actionStatusType
	 * @type ActionStatusType
	 */
	public org.schema.ActionStatusType actionStatusType;

	/**
	 * credentialengine.org/agent
	 * The direct performer or driver of the action (animate or inanimate).
	 * @property agent
	 * @type CredentialOrganization | CredentialPerson | QACredentialOrganization
	 */
	public Object agent;

	/**
	 * credentialengine.org/description
	 * A short description of the resource being described.
	 * @property description
	 * @type Literal
	 */
	public String description;

	/**
	 * credentialengine.org/endTime
	 * The endTime of something.
	 * @property endTime
	 * @type dateTime
	 */
	public String endTime;

	/**
	 * credentialengine.org/instrument
	 * The object that helped the agent perform the action. e.g. John wrote a book with a pen.
	 * @property instrument
	 * @type ApprenticeshipCertificate | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Credential | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object instrument;

	/**
	 * credentialengine.org/object
	 * The object upon [which] the action is carried out, whose state is kept intact or changed.
	 * @property object
	 * @type ApprenticeshipCertificate | AssessmentProfile | AssociateDegree | BachelorDegree | Badge | Certificate | Certification | Competency | CompetencyFramework | Credential | CredentialOrganization | CredentialPerson | Degree | DigitalBadge | Diploma | DoctoralDegree | GeneralEducationDevelopment | JourneymanCertificate | LearningOpportunityProfile | License | MasterCertificate | MasterDegree | MicroCredential | OpenBadge | ProfessionalDoctorate | QualityAssuranceCredential | ResearchDoctorate | SecondarySchoolDiploma
	 */
	public Object object;

	/**
	 * credentialengine.org/participant
	 * Other co-agents that participated in the action indirectly.
	 * @property participant
	 * @type CredentialOrganization | CredentialPerson | QACredentialOrganization
	 */
	public Object participant;

	/**
	 * credentialengine.org/resultingAward
	 * The result produced in the action.
	 * @property resultingAward
	 * @type CredentialAssertion
	 */
	public CredentialAssertion resultingAward;

	/**
	 * credentialengine.org/startTime
	 * The startTime of something.
	 * @property startTime
	 * @type dateTime
	 */
	public String startTime;

}