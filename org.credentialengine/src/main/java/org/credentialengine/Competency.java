package org.credentialengine;

import org.cassproject.schema.general.EcRemoteLinkedData;
import org.w3.skos.Concept;

/**
 * credentialengine.org/Competency
 * Description of knowledge, skills, and/or abilities.
 * @author credentialengine.org
 * @class CeCompetency
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
	 * http://purl.org/ctdlasn/terms/alignFrom
	 * A competency framework or competency from which this competency framework or competency is aligned.
	 * An alignment is an assertion of some degree of equivalency between the subject and the object of the assertion.
	 * @property alignFrom
	 * @type Competency | CompetencyFramework
	 */
	public Object alignFrom;

	/**
	 * http://purl.org/ctdlasn/terms/alignTo
	 * A competency framework or competency to which this competency framework or competency is aligned.
	 * An alignment is an assertion of some degree of equivalency between the subject and the object of the assertion.
	 * @property alignTo
	 * @type Competency | CompetencyFramework
	 */
	public Object alignTo;

	/**
	 * http://purl.org/ctdlasn/terms/altCodedNotation
	 * An alphanumeric notation or ID code identifying this competency in common use among end-users.
	 * Unlike the codedNotation property, the value for the altCodedNotation property need not be an official identifier created by the promulgating agency. It must be an identifier in common use among end-users of the competency. This property should be seldom used and only with a clear demonstration of need (i.e., in common use). For example, in the Common Core State Standards (Math) in the U.S., the official codedNotation of "CCSS.Math.Content.1.NBT.C.4" is abbreviated in common use by end-users to the unofficial altCodedNotation of "1.NBT.4".
	 * @property altCodedNotation
	 * @type string
	 */
	public String altCodedNotation;

	/**
	 * http://purl.org/ctdlasn/terms/author
	 * A person or organization chiefly responsible for the intellectual or artistic content of this competency framework or competency.
	 * @property author
	 * @type string
	 */
	public String author;

	/**
	 * http://purl.org/ctdlasn/terms/broadAlignment
	 * The referenced competency covers all of the relevant concepts in this competency as well as relevant concepts not found in this competency.
	 * @property broadAlignment
	 * @type Competency
	 */
	public Competency broadAlignment;

	/**
	 * http://purl.org/ctdlasn/terms/codedNotation
	 * An alphanumeric notation or ID code as defined by the promulgating body to identify this competency.
	 * This property should be used only for codes created by the promulgating body. For alternative competency notations in common use in the community of practice, but not endorsed by the promulgating body, the altCodedNotation property can be used (sparingly on clear evidence of common use and need).
	 * @property codedNotation
	 * @type string
	 */
	public String codedNotation;

	/**
	 * http://purl.org/ctdlasn/terms/comment
	 * Supplemental text provided by the promulgating body that clarifies the nature, scope or use of this competency.
	 * Use this property when the text provides useful context for this competency.
	 * @property comment
	 * @type langString
	 */
	public String comment;

	/**
	 * http://purl.org/ctdlasn/terms/competencyCategory
	 * The textual label identifying the category of the competency as designated by the promulgating body.
	 * This property points to a class, not to instances of that class. For example, where two competencies in a competency framework have been identified respectively by the promulgating agency as "Strand: Rennaisance" and "Strand: Social history", the statementLabel for both these competencies is "Strand".
	 * @property competencyCategory
	 * @type langString
	 */
	public String competencyCategory;

	/**
	 * http://purl.org/ctdlasn/terms/competencyText
	 * The text of the competency.
	 * @property competencyText
	 * @type langString
	 */
	public String competencyText;

	/**
	 * http://purl.org/ctdlasn/terms/complexityLevel
	 * The expected performance level of a learner or professional as defined by a competency.
	 * @property complexityLevel
	 * @type ProficiencyScale
	 */
	public ProficiencyScale complexityLevel;

	/**
	 * http://purl.org/ctdlasn/terms/comprisedOf
	 * This competency includes, comprehends or encompasses, in whole or in part, the meaning, nature or importance of the referenced competency.
	 * @property comprisedOf
	 * @type Competency
	 */
	public Competency comprisedOf;

	/**
	 * http://purl.org/ctdlasn/terms/conceptKeyword
	 * A word or phrase used by the promulgating agency to refine and differentiate individual competencies contextually.
	 * The conceptKeyword property is used in ASN-conforming data solely to denote the significant topicality of the competency using free-text keywords and phrases derived and assigned by the indexer, e.g., "George Washington", "Ayers Rock", etc.
	 * @property conceptKeyword
	 * @type langString
	 */
	public String conceptKeyword;

	/**
	 * http://purl.org/ctdlasn/terms/conceptTerm
	 * A term drawn from a controlled vocabulary used by the promulgating agency to refine and differentiate individual competencies contextually.
	 * The conceptTerm property is used in ASN-conforming data solely to denote the topicality of the competency - e.g., "Pythagorean Theorem", "Trigonometric functions", "Forces and energy", "Scientific method", "Oral history" etc. The value of the conceptTerm property must be drawn from a controlled vocabulary where concepts have all been assigned URI - e.g., terms drawn from the Australia Schools Online Thesaurus (ScOT).
	 * @property conceptTerm
	 * @type Concept
	 */
	public Concept conceptTerm;

	/**
	 * http://purl.org/ctdlasn/terms/creator
	 * An entity primarily responsible for making this competency framework or competency.
	 * The creator property is used with non-canonical statements created by a third party.
	 * @property creator
	 * @type CredentialOrganization | QACredentialOrganization
	 */
	public Object creator;

	/**
	 * http://purl.org/ctdlasn/terms/crossSubjectReference
	 * A relationship between this competency and a competency in a separate competency framework.
	 * An interdisciplinary statement reference.
	 * @property crossSubjectReference
	 * @type Competency
	 */
	public Competency crossSubjectReference;

	/**
	 * http://purl.org/ctdlasn/terms/dateCreated
	 * Date of creation of this competency framework or competency.
	 * The dateCreated property is used for non-canonical statements created by a third party.
	 * @property dateCreated
	 * @type date
	 */
	public String dateCreated;

	/**
	 * http://purl.org/ctdlasn/terms/dateModified
	 * The date on which this framework or competency was most recently modified in some way.
	 * @property dateModified
	 * @type dateTime
	 */
	public String dateModified;

	/**
	 * http://purl.org/ctdlasn/terms/derivedFrom
	 * A third party version of the entity being reference that has been modified in meaning through editing, extension or refinement.
	 * @property derivedFrom
	 * @type Competency | CompetencyFramework
	 */
	public Object derivedFrom;

	/**
	 * http://purl.org/ctdlasn/terms/educationLevelType
	 * A general statement describing the education or training context. Alternatively, a more specific statement of the location of the audience in terms of its progression through an education or training context.
	 * Best practice is to use terms from the http://purl.org/ctdl/terms/AudienceLevel concept scheme.
	 * @property educationLevelType
	 * @type Concept
	 */
	public Concept educationLevelType;

	/**
	 * http://purl.org/ctdlasn/terms/exactAlignment
	 * The relevant concepts in this competency and the referenced competency are coextensive.
	 * @property exactAlignment
	 * @type Competency
	 */
	public Competency exactAlignment;

	/**
	 * http://purl.org/ctdlasn/terms/hasChild
	 * The referenced competency is lower in some arbitrary hierarchy than this competency.
	 * @property hasChild
	 * @type Competency
	 */
	public Competency hasChild;

	/**
	 * http://purl.org/ctdlasn/terms/identifier
	 * An alternative URI by which this competency framework or competency is identified.
	 * @property identifier
	 * @type anyURI
	 */
	public String identifier;

	/**
	 * http://purl.org/ctdlasn/terms/inLanguage
	 * The primary language used in or by this competency framework or competency.
	 * @property inLanguage
	 * @type language
	 */
	public String inLanguage;

	/**
	 * http://purl.org/ctdlasn/terms/isChildOf
	 * The referenced competency is higher in some arbitrary hierarchy than this competency.
	 * @property isChildOf
	 * @type Competency
	 */
	public Competency isChildOf;

	/**
	 * http://purl.org/ctdlasn/terms/isPartOf
	 * Competency framework that this competency is a part of.
	 * @property isPartOf
	 * @type CompetencyFramework
	 */
	public CompetencyFramework isPartOf;

	/**
	 * http://purl.org/ctdlasn/terms/isTopChildOf
	 * Indicates that this competency is at the top of some arbitrary hierarchy.
	 * @property isTopChildOf
	 * @type CompetencyFramework
	 */
	public CompetencyFramework isTopChildOf;

	/**
	 * http://purl.org/ctdlasn/terms/isVersionOf
	 * A related competency of which this competency is a version, edition, or adaptation.
	 * Changes in version imply substantive changes in content rather than differences in format.
	 * @property isVersionOf
	 * @type Competency
	 */
	public Competency isVersionOf;

	/**
	 * http://purl.org/ctdlasn/terms/listID
	 * An alphanumeric string found in the source framework indicating the relative position of a competency in an ordered list of competencies such as "A", "B", or "a", "b", or "I", "II", or "1", "2".
	 * @property listID
	 * @type string
	 */
	public String listID;

	/**
	 * http://purl.org/ctdlasn/terms/localSubject
	 * The text string denoting the subject of the competency framework or competency as designated by the promulgating agency.
	 * @property localSubject
	 * @type langString
	 */
	public String localSubject;

	/**
	 * http://purl.org/ctdlasn/terms/majorAlignment
	 * Major overlap of relevant concepts between the this competency and the referenced competency.
	 * @property majorAlignment
	 * @type Competency
	 */
	public Competency majorAlignment;

	/**
	 * http://purl.org/ctdlasn/terms/minorAlignment
	 * Minor overlap of relevant concepts between this competency and the referenced competency.
	 * @property minorAlignment
	 * @type Competency
	 */
	public Competency minorAlignment;

	/**
	 * http://purl.org/ctdlasn/terms/narrowAlignment
	 * This competency covers all of the relevant concepts in the referenced competency as well as relevant concepts not found in the referenced competency.
	 * @property narrowAlignment
	 * @type Competency
	 */
	public Competency narrowAlignment;

	/**
	 * http://purl.org/ctdlasn/terms/prerequisiteAlignment
	 * This competency is a prerequisite to the referenced competency.
	 * @property prerequisiteAlignment
	 * @type Competency
	 */
	public Competency prerequisiteAlignment;

	/**
	 * http://purl.org/ctdlasn/terms/shouldIndex
	 * Indicates whether correlators should or should not assign the competency during correlation.
	 * @property shouldIndex
	 * @type boolean
	 */
	public boolean shouldIndex;

	/**
	 * http://purl.org/ctdlasn/terms/skillEmbodied
	 * Cognitive, affective, and psychomotor skills directly or indirectly embodied in this competency.
	 * @property skillEmbodied
	 * @type anyURI
	 */
	public String skillEmbodied;

	/**
	 * http://purl.org/ctdlasn/terms/weight
	 * An asserted measurement of the weight, degree, percent, or strength of a recommendation, requirement, or comparison.
	 * Best practice is to assigned a decimal value weight between 0 and 1 that indicates the strength of the assertion, with 0 being weakest and 1 being strongest.
	 * @property weight
	 * @type float
	 */
	public Float weight;
}