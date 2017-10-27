package org.credentialengine;

import org.stjs.javascript.Date;
import org.cassproject.schema.general.EcRemoteLinkedData;

/**
 * credentialengine.org/FinancialAlignmentObject
 * An alignment to a financial framework.
 * Examples include, but are not limited to, Free Application for Federal Student Aid (FAFSA) in the U.S.
 * @author credentialengine.org
 * @class FinancialAlignmentObject
 * @module org.credentialengine
 * @extends CredentialAlignmentObject
 */
public class FinancialAlignmentObject extends CredentialAlignmentObject
{
	/**
	 * Constructor, automatically sets @context and @type.
	 * @constructor
	 */
	public FinancialAlignmentObject()
	{
		context="http://schema.eduworks.com/simpleCtdl";
		type="FinancialAlignmentObject";
	}

	/**
	 * http://purl.org/ctdl/terms/alignmentDate
	 * The date  the alignment was made.
	 * @property alignmentDate
	 * @type date
	 */
	public String alignmentDate;

	/**
	 * http://purl.org/ctdl/terms/alignmentType
	 * Type of relationship between two entities.
	 * In CTDL, the alignment type value is definitively identified by the property for which the AlignmentObject is the rdfs:range; therefore, use of this property is generally redundant.
	 * @property alignmentType
	 * @type string
	 */
	public String alignmentType;

	/**
	 * http://purl.org/ctdl/terms/codedNotation
	 * Set of alpha-numeric symbols that uniquely identifies an item and supports its discovery and use.
	 * Examples include the alpha-numeric code "CCSS.MATH.CONTENT.HSA.CED.A.2" identifying a node in the U.S. Common Core State Standards on creating equations in algebra, or, the code "8021" in the U.S. Standard Industrial Classification (SIC) for identifying the occupational context for "Offices and Clinics of Dentists".
	 * @property codedNotation
	 * @type string
	 */
	public String codedNotation;

	/**
	 * http://purl.org/ctdl/terms/framework
	 * Credential framework to which the entity is aligned.
	 * Frameworks may include, but are not limited to, competency frameworks and concept schemes such as industry, occupation, and instructional program codes.
	 * @property framework
	 * @type anyURI
	 */
	public String framework;

	/**
	 * http://purl.org/ctdl/terms/frameworkName
	 * Name of the framework.
	 * @property frameworkName
	 * @type langString
	 */
	public String frameworkName;

	/**
	 * http://purl.org/ctdl/terms/targetNode
	 * Individual entry in a formally defined framework such as a competency or an industry, instructional program, or occupation code.
	 * @property targetNode
	 * @type anyURI
	 */
	public String targetNode;

	/**
	 * http://purl.org/ctdl/terms/targetNodeDescription
	 * Textual description of an individual concept or competency in a formally defined framework.
	 * @property targetNodeDescription
	 * @type langString
	 */
	public String targetNodeDescription;

	/**
	 * http://purl.org/ctdl/terms/targetNodeName
	 * Name of an individual concept or competency in a formally defined framework.
	 * @property targetNodeName
	 * @type langString
	 */
	public String targetNodeName;

	/**
	 * http://purl.org/ctdl/terms/weight
	 * Measurement of the weight, degree, percent, or strength of a recommendation, requirement, or comparison.
	 * @property weight
	 * @type float
	 */
	public Float weight;

}