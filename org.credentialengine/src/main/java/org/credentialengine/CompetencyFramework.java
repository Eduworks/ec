package org.credentialengine;

import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * ceasn:CompetencyFramework
 * A description of a competency framework as a whole.
 * @author credentialengine.org
 * @class CompetencyFramework
 * @module org.credentialengine
 */
public class CompetencyFramework extends EcRemoteLinkedData
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public CompetencyFramework()
	{
		super("http://credreg.net/ctdlasn/schema/context/json?releaseID=20170929","CompetencyFramework");
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
	 * ceasn:author
	 * A person or organization chiefly responsible for the intellectual or artistic content of this competency framework or competency.
	 * @property author
	 * @type string
	 */
	public String author;

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
	 * ceasn:dateCopyrighted
	 * Date of a statement of copyright for this competency framework, such as ©2017.
	 * @property dateCopyrighted
	 * @type string
	 */
	public String dateCopyrighted;

	/**
	 * ceasn:dateCreated
	 * Date of creation of this competency framework or competency.
	 * The dateCreated property is used for non-canonical statements created by a third party.
	 * @property dateCreated
	 * @type date
	 */
	public String dateCreated;

	/**
	 * ceasn:dateValidFrom
	 * Beginning date of validity of this competency framework.
	 * @property dateValidFrom
	 * @type date
	 */
	public String dateValidFrom;

	/**
	 * ceasn:dateValidUntil
	 * End date of validity of this competency framework.
	 * @property dateValidUntil
	 * @type date
	 */
	public String dateValidUntil;

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
	 * ceasn:hasTopChild
	 * Top-level child competency of a competency framework.
	 * @property hasTopChild
	 * @type Competency
	 */
	public Competency hasTopChild;

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
	 * ceasn:license
	 * A legal document giving official permission to do something with this competency framework.
	 * Value must be the URI to a license document (e.g., Creative Commons license or bespoke license).
	 * @property license
	 * @type anyURI
	 */
	public String license;

	/**
	 * ceasn:localSubject
	 * The text string denoting the subject of the competency framework or competency as designated by the promulgating agency.
	 * @property localSubject
	 * @type langString
	 */
	public String localSubject;

	/**
	 * ceasn:name
	 * The name or title of this competency framework.
	 * @property name
	 * @type langString
	 */
	public String name;

	/**
	 * ceasn:publicationStatusType
	 * The publication status of the of this competency framework.
	 * @property publicationStatusType
	 * @type Concept
	 */
	public Object publicationStatusType;

	/**
	 * ceasn:publisher
	 * An entity responsible for making this competency framework available.
	 * Also referred to as the promulgating agency of the competency framework.
	 * @property publisher
	 * @type CredentialOrganization | QACredentialOrganization
	 */
	public Object publisher;

	/**
	 * ceasn:repositoryDate
	 * The date this competency framework was added to the repository.
	 * @property repositoryDate
	 * @type date
	 */
	public String repositoryDate;

	/**
	 * ceasn:rights
	 * Information about rights held in and over this competency framework.
	 * @property rights
	 * @type anyURI
	 */
	public String rights;

	/**
	 * ceasn:rightsHolder
	 * An agent owning or managing rights over this competency framework.
	 * @property rightsHolder
	 * @type CredentialOrganization | QACredentialOrganization
	 */
	public Object rightsHolder;

	/**
	 * ceasn:source
	 * The original competency framework which this competency framework is based on or derived from.
	 * @property source
	 * @type anyURI
	 */
	public String source;

	/**
	 * ceasn:tableOfContents
	 * A list of sub-units of this competency framework.
	 * The table of contents is a "manifest", or a hierarchic, ordered, syntactic representation of the competencies that are part of this competency framework.
	 * @property tableOfContents
	 * @type langString
	 */
	public String tableOfContents;

	/**
	 * http://purl.org/ctdl/terms/ctid
	 * Globally unique Credential Transparency Identifier (CTID) by which the creator, owner or provider of a credential, learning opportunity competency, or assessment recognizes the entity in transactions with the external environment (e.g., in verifiable claims involving a credential).
	 * The CTID is the equivalent of a version identifier for the resource. Different versions of a resource are considered distinct expressions and each must be assigned its own CTID. Each version of a resource can have only one CTID assigned. However, a single version of a resource may have distinct identifier values for both the ctid property and the credentialId property. In such a case both identifiers will be recognized by the resource creator/owner/provider in transactions with the external environment.
	 * @property ctid
	 * @type string
	 */
	public String ctid;

}