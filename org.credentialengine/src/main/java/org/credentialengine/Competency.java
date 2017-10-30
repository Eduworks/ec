package org.credentialengine;

import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * ceasn:Competency
 * Description of knowledge, skills, and/or abilities.
 * @author credentialengine.org
 * @class Competency
 * @module org.credentialengine
 */
public class Competency extends EcRemoteLinkedData
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public Competency()
	{
		super("http://schema.eduworks.com/simpleCtdl","Competency");
	}

	/**
	 * ceasn:alignFrom
	 * A competency framework or competency from which this competency framework or competency is aligned.
	 * An alignment is an assertion of some degree of equivalency between the subject and the object of the assertion.
	 * @property alignFrom
	 * @type Competency | CompetencyFramework
	 */
	public Object alignFrom;

	/**
	 * ceasn:alignTo
	 * A competency framework or competency to which this competency framework or competency is aligned.
	 * An alignment is an assertion of some degree of equivalency between the subject and the object of the assertion.
	 * @property alignTo
	 * @type Competency | CompetencyFramework
	 */
	public Object alignTo;

	/**
	 * ceasn:altCodedNotation
	 * An alphanumeric notation or ID code identifying this competency in common use among end-users.
	 * Unlike the codedNotation property, the value for the altCodedNotation property need not be an official identifier created by the promulgating agency. It must be an identifier in common use among end-users of the competency. This property should be seldom used and only with a clear demonstration of need (i.e., in common use). For example, in the Common Core State Standards (Math) in the U.S., the official codedNotation of "CCSS.Math.Content.1.NBT.C.4" is abbreviated in common use by end-users to the unofficial altCodedNotation of "1.NBT.4".
	 * @property altCodedNotation
	 * @type string
	 */
	public String altCodedNotation;

	/**
	 * ceasn:author
	 * A person or organization chiefly responsible for the intellectual or artistic content of this competency framework or competency.
	 * @property author
	 * @type string
	 */
	public String author;

	/**
	 * ceasn:broadAlignment
	 * The referenced competency covers all of the relevant concepts in this competency as well as relevant concepts not found in this competency.
	 * @property broadAlignment
	 * @type Competency
	 */
	public Competency broadAlignment;

	/**
	 * ceasn:codedNotation
	 * An alphanumeric notation or ID code as defined by the promulgating body to identify this competency.
	 * This property should be used only for codes created by the promulgating body. For alternative competency notations in common use in the community of practice, but not endorsed by the promulgating body, the altCodedNotation property can be used (sparingly on clear evidence of common use and need).
	 * @property codedNotation
	 * @type string
	 */
	public String codedNotation;

	/**
	 * ceasn:comment
	 * Supplemental text provided by the promulgating body that clarifies the nature, scope or use of this competency.
	 * Use this property when the text provides useful context for this competency.
	 * @property comment
	 * @type langString
	 */
	public String comment;

	/**
	 * ceasn:competencyCategory
	 * The textual label identifying the category of the competency as designated by the promulgating body.
	 * This property points to a class, not to instances of that class. For example, where two competencies in a competency framework have been identified respectively by the promulgating agency as "Strand: Rennaisance" and "Strand: Social history", the statementLabel for both these competencies is "Strand".
	 * @property competencyCategory
	 * @type langString
	 */
	public String competencyCategory;

	/**
	 * ceasn:competencyText
	 * The text of the competency.
	 * @property competencyText
	 * @type langString
	 */
	public String competencyText;

	/**
	 * ceasn:complexityLevel
	 * The expected performance level of a learner or professional as defined by a competency.
	 * @property complexityLevel
	 * @type ProficiencyScale
	 */
	public ProficiencyScale complexityLevel;

	/**
	 * ceasn:comprisedOf
	 * This competency includes, comprehends or encompasses, in whole or in part, the meaning, nature or importance of the referenced competency.
	 * @property comprisedOf
	 * @type Competency
	 */
	public Competency comprisedOf;

	/**
	 * ceasn:conceptKeyword
	 * A word or phrase used by the promulgating agency to refine and differentiate individual competencies contextually.
	 * The conceptKeyword property is used in ASN-conforming data solely to denote the significant topicality of the competency using free-text keywords and phrases derived and assigned by the indexer, e.g., "George Washington", "Ayers Rock", etc.
	 * @property conceptKeyword
	 * @type langString
	 */
	public String conceptKeyword;

	/**
	 * ceasn:conceptTerm
	 * A term drawn from a controlled vocabulary used by the promulgating agency to refine and differentiate individual competencies contextually.
	 * The conceptTerm property is used in ASN-conforming data solely to denote the topicality of the competency - e.g., "Pythagorean Theorem", "Trigonometric functions", "Forces and energy", "Scientific method", "Oral history" etc. The value of the conceptTerm property must be drawn from a controlled vocabulary where concepts have all been assigned URI - e.g., terms drawn from the Australia Schools Online Thesaurus (ScOT).
	 * @property conceptTerm
	 * @type ConceptScheme
	 */
	public Object conceptTerm;

	/**
	 * ceasn:creator
	 * An entity primarily responsible for making this competency framework or competency.
	 * The creator property is used with non-canonical statements created by a third party.
	 * @property creator
	 * @type CredentialOrganization | QACredentialOrganization
	 */
	public Object creator;

	/**
	 * ceasn:crossSubjectReference
	 * A relationship between this competency and a competency in a separate competency framework.
	 * An interdisciplinary statement reference.
	 * @property crossSubjectReference
	 * @type Competency
	 */
	public Competency crossSubjectReference;

	/**
	 * ceasn:dateCreated
	 * Date of creation of this competency framework or competency.
	 * The dateCreated property is used for non-canonical statements created by a third party.
	 * @property dateCreated
	 * @type date
	 */
	public String dateCreated;

	/**
	 * ceasn:derivedFrom
	 * The URI of a competency from which this competency has been derived.
	 * The derivedFrom property is used by 3rd parties only in derived competencies.
	 * @property derivedFrom
	 * @type Competency | CompetencyFramework
	 */
	public Object derivedFrom;

	/**
	 * ceasn:description
	 * A short description of this competency framework or competency.
	 * @property description
	 * @type langString
	 */
	public String description;

	/**
	 * ceasn:educationLevelType
	 * A general statement describing the education or training context. Alternatively, a more specific statement of the location of the audience in terms of its progression through an education or training context.
	 * Best practice is to use terms from the http://purl.org/ctdl/terms/AudienceLevel concept scheme.
	 * @property educationLevelType
	 * @type Concept
	 */
	public Object educationLevelType;

	/**
	 * ceasn:exactAlignment
	 * The relevant concepts in this competency and the referenced competency are coextensive.
	 * @property exactAlignment
	 * @type Competency
	 */
	public Competency exactAlignment;

	/**
	 * ceasn:hasChild
	 * The referenced competency is lower in some arbitrary hierarchy than this competency.
	 * @property hasChild
	 * @type Competency
	 */
	public Competency hasChild;

	/**
	 * ceasn:identifier
	 * An alternative URI by which this competency framework or competency is identified.
	 * @property identifier
	 * @type anyURI
	 */
	public String identifier;

	/**
	 * ceasn:inLanguage
	 * The primary language used in or by this competency framework or competency.
	 * @property inLanguage
	 * @type language
	 */
	public String inLanguage;

	/**
	 * ceasn:isChildOf
	 * The referenced competency is higher in some arbitrary hierarchy than this competency.
	 * @property isChildOf
	 * @type Competency
	 */
	public Competency isChildOf;

	/**
	 * ceasn:isPartOf
	 * Competency framework that this competency is a part of.
	 * @property isPartOf
	 * @type CompetencyFramework
	 */
	public CompetencyFramework isPartOf;

	/**
	 * ceasn:isVersionOf
	 * A related competency of which this competency is a version, edition, or adaptation.
	 * Changes in version imply substantive changes in content rather than differences in format.
	 * @property isVersionOf
	 * @type Competency
	 */
	public Competency isVersionOf;

	/**
	 * ceasn:listID
	 * An alphanumeric string indicating this competency's position in a list of competencies at the same level in some arbitrary hierarchy.
	 * Competencies with lower alphanumeric values for this property come before competencies with higher values.
	 * @property listID
	 * @type string
	 */
	public String listID;

	/**
	 * ceasn:localSubject
	 * The text string denoting the subject of the competency framework or competency as designated by the promulgating agency.
	 * @property localSubject
	 * @type langString
	 */
	public String localSubject;

	/**
	 * ceasn:majorAlignment
	 * Major overlap of relevant concepts between the this competency and the referenced competency.
	 * @property majorAlignment
	 * @type Competency
	 */
	public Competency majorAlignment;

	/**
	 * ceasn:minorAlignment
	 * Minor overlap of relevant concepts between this competency and the referenced competency.
	 * @property minorAlignment
	 * @type Competency
	 */
	public Competency minorAlignment;

	/**
	 * ceasn:narrowAlignment
	 * This competency covers all of the relevant concepts in the referenced competency as well as relevant concepts not found in the referenced competency.
	 * @property narrowAlignment
	 * @type Competency
	 */
	public Competency narrowAlignment;

	/**
	 * ceasn:prerequisiteAlignment
	 * This competency is a prerequisite to the referenced competency.
	 * @property prerequisiteAlignment
	 * @type Competency
	 */
	public Competency prerequisiteAlignment;

	/**
	 * ceasn:shouldIndex
	 * Indicates whether correlators should or should not assign the competency during correlation.
	 * @property shouldIndex
	 * @type boolean
	 */
	public boolean shouldIndex;

	/**
	 * ceasn:skillEmbodied
	 * Cognitive, affective, and psychomotor skills directly or indirectly embodied in this competency.
	 * @property skillEmbodied
	 * @type anyURI
	 */
	public String skillEmbodied;

	/**
	 * ceasn:weight
	 * An asserted measurement of the weight, degree, percent, or strength of a recommendation, requirement, or comparison.
	 * Best practice is to assigned a decimal value weight between 0 and 1 that indicates the strength of the assertion, with 0 being weakest and 1 being strongest.
	 * @property weight
	 * @type float
	 */
	public Float weight;

	/**
	 * http://purl.org/ctdl/terms/ctid
	 * Globally unique Credential Transparency Identifier (CTID) by which the creator, owner or provider of a credential, learning opportunity competency, or assessment recognizes the entity in transactions with the external environment (e.g., in verifiable claims involving a credential).
	 * The CTID is the equivalent of a version identifier for the resource. Different versions of a resource are considered distinct expressions and each must be assigned its own CTID. Each version of a resource can have only one CTID assigned. However, a single version of a resource may have distinct identifier values for both the ctid property and the credentialId property. In such a case both identifiers will be recognized by the resource creator/owner/provider in transactions with the external environment.
	 * @property ctid
	 * @type string
	 */
	public String ctid;

}